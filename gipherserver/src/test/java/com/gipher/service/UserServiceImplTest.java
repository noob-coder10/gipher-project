package com.gipher.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;

import com.gipher.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.gipher.exception.UserAlreadyExistsException;
import com.gipher.models.User;
import com.gipher.repo.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl service;
    User user;
    Optional<User> optUser;

    @Before
    public void setUp() throws Exception {
        user =new User(2147483649L, "Gipher", "Gipher", "app", "f@gmail.com", "0987654321", true);
        optUser = Optional.of(user);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRegisterUserSuccess() throws Exception {
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        User addedUser = service.createUser(user);
        assertEquals(user.getEmail(), addedUser.getEmail());
        verify(userRepository).save(Mockito.any());
    }
    @Test
    public void testRegisterUserFailure() throws UserAlreadyExistsException {
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        when(userRepository.save(Mockito.any(User.class))).thenReturn(null);
    }
    @Test
    public void testUpdateUserSuccess() throws UserAlreadyExistsException {
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
    }

    @Test
    public void testUpdateUserFailure() throws UserAlreadyExistsException {
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        when(userRepository.save(Mockito.any(User.class))).thenReturn(null);
    }
    @Test
    public void testAuthenticateUserSuccess() {
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
    }

    @Test
    public void testAuthenticateUserFailure() {
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        when(userRepository.save(Mockito.any(User.class))).thenReturn(null);
    }


}
