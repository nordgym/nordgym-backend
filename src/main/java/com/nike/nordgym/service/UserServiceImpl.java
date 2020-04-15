package com.nike.nordgym.service;

import com.nike.nordgym.constant.Constants;
import com.nike.nordgym.domain.User;
import com.nike.nordgym.error.DuplicatedResourceException;
import com.nike.nordgym.model.UserDto;
import com.nike.nordgym.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAll() {

        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto register(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        this.userRepository.findBySubscriptionNumber(user.getSubscriptionNumber())
                .ifPresent(e -> {
                    throw new DuplicatedResourceException(Constants.DUPLICATED_RESOURCE);
                });

        return modelMapper.map(userRepository.save(user), UserDto.class);
    }
}
