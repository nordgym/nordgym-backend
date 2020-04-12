package com.nike.nordgym.service;

import com.nike.nordgym.domain.Membership;
import com.nike.nordgym.model.MembershipDto;
import com.nike.nordgym.model.OrderDto;
import com.nike.nordgym.repository.MembershipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;
    private final ModelMapper modelMapper;

    public MembershipServiceImpl(MembershipRepository membershipRepository, ModelMapper modelMapper) {
        this.membershipRepository = membershipRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MembershipDto> getAll() {
        return membershipRepository.findAll()
                .stream()
                .map(membership -> modelMapper.map(membership, MembershipDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MembershipDto save(MembershipDto dto) {
        Membership membership = modelMapper.map(dto, Membership.class);
        return modelMapper.map(membershipRepository.save(membership), MembershipDto.class);
    }
}
