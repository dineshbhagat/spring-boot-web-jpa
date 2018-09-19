package com.example.converter;

import com.example.dto.UserDto;
import com.example.entity.User;

public class UserConverter {
    public static UserDto getDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getFullName());
        userDto.setDateOfBirth(user.getDateOfBirth());
        return userDto;
    }
}
