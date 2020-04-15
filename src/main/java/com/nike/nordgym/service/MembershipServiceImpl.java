package com.nike.nordgym.service;

import com.nike.nordgym.constant.Constants;
import com.nike.nordgym.domain.Membership;
import com.nike.nordgym.error.ResourceNotFoundException;
import com.nike.nordgym.model.MembershipDto;
import com.nike.nordgym.repository.MembershipRepository;
import com.nike.nordgym.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public MembershipServiceImpl(MembershipRepository membershipRepository, OrderRepository orderRepository, ModelMapper modelMapper) {
        this.membershipRepository = membershipRepository;
        this.orderRepository = orderRepository;
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

    @Override
    public MembershipDto delete(Long id) {
        Membership membership = this.membershipRepository.findById(id).orElse(null);
        if (membership == null) {
            throw new ResourceNotFoundException(
                    String.format(Constants.MEMBERSHIP_NOT_FOUND_BY_ID, id)
            );
        }
        this.orderRepository.deleteAll(membership.getOrders());
        this.membershipRepository.delete(membership);
        return this.modelMapper.map(membership, MembershipDto.class);
    }
}
