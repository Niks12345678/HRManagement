package com.nagarro.hrmanagement.repository;

import com.nagarro.hrmanagement.model.User;

public interface UserRepository {

    /**
     * validate a user
     * 
     * @param user
     * @return
     */
    public User validateUser(User user);
}
