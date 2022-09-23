package com.gipher.controller;

import com.gipher.config.JwtUtil;
import com.gipher.exception.UserDisabledException;
import com.gipher.exception.UserNotFoundException;
import com.gipher.models.JwtRequest;
import com.gipher.models.JwtResponse;
import com.gipher.models.User;
import com.gipher.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        UserDetails user = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(user);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception{
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e)
        {
            throw new UserDisabledException("USER DISABLED ");
        }
            catch (BadCredentialsException e)
        {
            throw new UserNotFoundException("User not found !!");
        }
    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {
        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }

}
