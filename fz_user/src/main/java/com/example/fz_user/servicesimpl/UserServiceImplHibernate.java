package com.example.fz_user.servicesimpl;

import com.example.fz_user.entities.User;
import com.example.fz_user.mapper.UserMapper;
import com.example.fz_user.repositoty.UserRepositoty;
import com.example.fz_user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Primary
public class UserServiceImplHibernate implements UserService {
    @Autowired
    UserRepositoty userRepositoty;

    @Override
    public List<User> findAllUser() {
        return userRepositoty.findAll();
    }

    @Override
    public User findUserById(int id) {
        return userRepositoty.findUserById(id);
    }

    @Override
    public int saveUser(User user) {
        return userRepositoty.saveUser(user.getName(),user.getPwd(),user.getGender(),user.getEmail());
    }

    @Override
    public int delUser(int id) {
        return userRepositoty.deleteUserById(id);
    }
}
