package com.nike.nordgym.controller;

import com.nike.nordgym.model.OrderDto;
import com.nike.nordgym.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping("/all")
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/open")
    public List<OrderDto> getAllOpen() {
        return orderService.getAllOpen();
    }

    @PostMapping("/save")
    public ResponseEntity<OrderDto> save(@Valid @RequestBody OrderDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.orderService.save(dto));
    }
    @PatchMapping("/complete")
    public ResponseEntity<OrderDto> complete(@RequestBody Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.orderService.complete(id));
    }
}
