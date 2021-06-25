package com.nagarro.hrmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.hrmanagement.model.User;
import com.nagarro.hrmanagement.repository.UserRepository;
import com.nagarro.hrmanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Validate a user
     */
    @Override
    public User validateUser(User user) {
        return userRepository.validateUser(user);
    }
}
