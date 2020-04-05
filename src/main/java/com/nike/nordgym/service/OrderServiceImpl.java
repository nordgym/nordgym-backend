package com.nike.nordgym.service;

import com.nike.nordgym.domain.Order;
import com.nike.nordgym.model.OrderDto;
import com.nike.nordgym.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.findAll()
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto save(OrderDto dto) {
        Order order = modelMapper.map(dto, Order.class);
        return modelMapper.map(orderRepository.save(order), OrderDto.class);
    }
}
