package com.nike.nordgym.service;

import com.nike.nordgym.model.OrderDto;


import java.util.List;

public interface OrderService {

    List<OrderDto> getAll();

    OrderDto save(OrderDto dto);

    List<OrderDto> getAllOpen();

    OrderDto complete(Long id);

    List<OrderDto> getAllByUserId(Long id);
}
