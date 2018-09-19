package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    User addUser(UserDto userDto);

    User getUser(String userId) throws Exception;
}
