package com.gipher.service.impl;

import com.gipher.exception.UserAlreadyExistsException;
import com.gipher.exception.UserNotFoundException;
import com.gipher.models.JwtRequest;
import com.gipher.models.User;
import com.gipher.repo.UserRepository;
import com.gipher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) throws UserAlreadyExistsException {

        User local = this.userRepository.findByemail(user.getEmail());

        if(local != null)
        {

            throw new UserAlreadyExistsException("User already present !!!");
        }
        else
        {
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String email) throws UserNotFoundException {
        User local = this.userRepository.findByemail(email);
        if(local==null)
        {
            throw new UserNotFoundException("User not found !");
        }
        else
        {
            return local;
        }
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User updatedData) throws UserNotFoundException {
        User user = getUser(updatedData.getEmail());
        if (user != null) {
            user.setFirstname(updatedData.getFirstname());
            user.setLastname(updatedData.getLastname());
            user.setPhone(updatedData.getPhone());
            user.setPassword(updatedData.getPassword());
            this.userRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    public User updateUserPassword(User updatedData) throws UserNotFoundException {
        User user = getUser(updatedData.getEmail());
        if (user != null) {
            user.setPassword(passwordEncoder.encode(updatedData.getPassword()));
            this.userRepository.save(user);
            return user;
        }
        return null;
    }

}
