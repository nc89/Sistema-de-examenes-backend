package com.exams.system.controller;

import com.exams.system.config.JwtUtils;
import com.exams.system.exceptions.UserNotFoundException;
import com.exams.system.model.jwt.JwtRequest;
import com.exams.system.model.jwt.JwtResponse;
import com.exams.system.model.User;
import com.exams.system.services.impl.UserDetailsServiceImpl;
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
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (UserNotFoundException exception){
            exception.printStackTrace();
            throw new Exception("User doesn't exist");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USER DISABLED " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Invalid credentials " + e.getMessage());
        }
    }

    @GetMapping("/current-user")
    public User obteinUserCurrent(Principal principal){
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
