package com.nike.nordgym.service;

import com.nike.nordgym.model.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    void register(UserDto userDto);
}
