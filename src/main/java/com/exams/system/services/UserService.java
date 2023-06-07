package com.exams.system.services;

import com.exams.system.model.User;
import com.exams.system.model.UserRol;

import java.util.Set;

public interface UserService {
    public User saveUser(User user, Set<UserRol> userRoles) throws Exception;

    public User obtainUser(String username);

    public void deleteUser(Long userId);
}
