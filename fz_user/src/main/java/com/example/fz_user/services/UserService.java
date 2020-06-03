package com.example.fz_user.services;

import com.example.fz_user.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserById(int id);
    int saveUser(User user);
    int delUser(int id);
}
