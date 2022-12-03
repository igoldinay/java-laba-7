package com.example.testsequrity2dbthemelyf.service;

import com.example.testsequrity2dbthemelyf.dto.UserDto;
import com.example.testsequrity2dbthemelyf.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDTO);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
