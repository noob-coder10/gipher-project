package com.gipher.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import com.gipher.exception.UserAlreadyExistsException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gipher.controller.UserController;

import com.gipher.models.User;
import com.gipher.service.UserService;

//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;
    @MockBean
    private UserController userController;


    private User user;
    Optional<User> optUser;


    @Before
    public void setUp() throws Exception {
        user = new User(21649L, "Gipher", "Gipher", "app", "gipher@gmail.com", "0987654321", true);
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test(expected = Exception.class)
    public void testGetUserFailure() throws Exception {
        when(service.getUser(Mockito.anyString())).thenThrow(Exception.class);
        mockMvc.perform(get("/user/gipher@gmail.com")).andExpect(status().isConflict())
                .andDo(print());
        verify(service).getUser(Mockito.anyString());
    }

}
