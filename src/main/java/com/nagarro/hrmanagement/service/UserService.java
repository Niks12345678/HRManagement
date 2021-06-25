package com.nagarro.hrmanagement.service;

import com.nagarro.hrmanagement.model.User;

public interface UserService {

    /**
     * Validate a user
     * 
     * @param user
     * @return
     */
    public User validateUser(User user);
}
