package com.nike.nordgym.controller;

import com.nike.nordgym.model.UserDto;
import com.nike.nordgym.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto userDto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.register(userDto));

    }
}
