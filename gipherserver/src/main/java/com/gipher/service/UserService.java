package com.gipher.service;

import com.gipher.exception.UserAlreadyExistsException;
import com.gipher.exception.UserNotFoundException;
import com.gipher.models.JwtRequest;
import com.gipher.models.User;

public interface UserService {
    public User createUser(User user) throws UserAlreadyExistsException;

    public User getUser(String email) throws UserNotFoundException;

    public void deleteUser(Long userid);

    public User updateUser(User user) throws UserNotFoundException;

    public User updateUserPassword(User user) throws UserNotFoundException;
}
