package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User addUser(UserDto userDto) {
        User user = new User();
        user.setFullName(userDto.getName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        userDao.save(user);
        return user;
    }

    @Override
    public User getUser(String userId) throws Exception {
        Optional<User> user = userDao.findById(Long.parseLong(userId));
        if (user.isPresent()) {
            return user.get();
        }
        throw new Exception("User not found!");
    }
}
