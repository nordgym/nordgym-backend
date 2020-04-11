package com.nike.nordgym.service;

import com.nike.nordgym.constant.Constants;
import com.nike.nordgym.domain.User;
import com.nike.nordgym.error.DuplicatedResourceException;
import com.nike.nordgym.error.ResourceNotFoundException;
import com.nike.nordgym.model.UserDto;
import com.nike.nordgym.repository.OrderRepository;
import com.nike.nordgym.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAll() {

        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto dto) {
        User user = modelMapper.map(dto, User.class);
        this.userRepository.findBySubscriptionNumber(user.getSubscriptionNumber())
                .ifPresent(e -> {
                    throw new DuplicatedResourceException(Constants.DUPLICATED_RESOURCE);
                });

        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserDto delete(Long id) {
        User user = this.userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException(
                    String.format(Constants.USER_NOT_FOUND_BY_ID, id)
            );
        }
        this.orderRepository.deleteAll(user.getOrders());
        this.userRepository.delete(user);
        return this.modelMapper.map(user, UserDto.class);
    }
}
