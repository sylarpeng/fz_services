package com.example.fz_user.mapper;

import com.example.fz_user.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    List<User> findAllUser();
    User findUserById(int id);
    int saveUser(User user);
    int delUser(int id);

}
