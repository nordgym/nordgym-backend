package com.nike.nordgym.controller;

import com.nike.nordgym.model.UserDto;
import com.nike.nordgym.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {

       return userService.getAll();
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto){

        userService.register(userDto);
    }
}
