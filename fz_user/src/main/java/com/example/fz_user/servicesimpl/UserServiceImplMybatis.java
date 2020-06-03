package com.example.fz_user.servicesimpl;

import com.example.fz_user.entities.User;
import com.example.fz_user.mapper.UserMapper;
import com.example.fz_user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
//@Primary
public class UserServiceImplMybatis implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public int delUser(int id) {
        return userMapper.delUser(id);
    }
}
