package com.exams.system.services.impl;

import com.exams.system.exceptions.UserFoundException;
import com.exams.system.model.User;
import com.exams.system.model.UserRol;
import com.exams.system.repository.RolRepository;
import com.exams.system.repository.UserRepository;
import com.exams.system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;

    @Override
    public User saveUser(User user, Set<UserRol> userRoles) throws Exception {
        User userAux = userRepository.findByUsername(user.getUsername());
        if(userAux != null){
            System.out.println("User already exist");
            throw new UserFoundException("User is present");
        }else {
            for (UserRol userRol:userRoles){
                rolRepository.save(userRol.getRol());
            }
            user.getUserRoles().addAll(userRoles);
            userAux = userRepository.save(user);
        }
        return userAux;
    }

    @Override
    public User obtainUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
