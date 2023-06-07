package com.exams.system.controller;

import com.exams.system.services.UserService;
import com.exams.system.model.Rol;
import com.exams.system.model.User;
import com.exams.system.model.UserRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) throws Exception{
        user.setProfile("default.png");

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRol> userRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setNameRol("NORMAL");

        UserRol userRol = new UserRol();
        userRol.setUser(user);
        userRol.setRol(rol);

        userRoles.add(userRol);
        return userService.saveUser(user,userRoles);
    }


    @GetMapping("/{username}")
    public User obtainUser(@PathVariable("username") String username){
        return userService.obtainUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}
