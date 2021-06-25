package com.nagarro.hrmanagement.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.hrmanagement.model.User;
import com.nagarro.hrmanagement.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    /**
     * Validate a user
     */
    @Override
    public User validateUser(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        List<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.userName='" + userName + "' AND u.password='" + password + "'",
                User.class).getResultList();
        if (!query.isEmpty()) {
            return query.get(0);
        }
        return null;
    }
}
