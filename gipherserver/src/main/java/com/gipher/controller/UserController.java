package com.gipher.controller;


import com.gipher.models.User;
import com.gipher.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    private static final Logger logger= LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return this.userService.createUser(user);
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable("email") String email) throws Exception {
        return this.userService.getUser(email);
    }

    //delete the user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId)
    {
        this.userService.deleteUser(userId);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
        User u = userService.updateUser(user);
        logger.info("user has been updated");
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    @PutMapping("/updatePassword")
    public ResponseEntity<User> updateUserPassword(@RequestBody User user) throws Exception {

        User u = userService.updateUserPassword(user);
        logger.info("inside updateUser method");
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
