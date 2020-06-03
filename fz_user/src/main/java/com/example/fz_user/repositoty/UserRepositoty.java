package com.example.fz_user.repositoty;

import com.example.fz_user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepositoty extends JpaRepository<User,Integer>{

//    List<User> findAll();
//    User findUserById(int id);
//    @Transactional
//    int deleteUserById(int id);

//    通过JPQL（JPA 规范提供了Java Persistence Query Language）@Query采用自定义方式实现
      @Query("select u from User u")
      List<User> findAll();

      @Query(value = "select u from User u where u.id= :id")
      User findUserById(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "insert into xf_user(name,pwd,gender,email) value(?,?,?,?)", nativeQuery = true)
    int saveUser(@Param("name")String name,@Param("pwd") String pwd,@Param("int") Integer gender,@Param("email") String email);

    /*
     * 删除  必须加入@Modifying和@Transactional
     * */
    @Modifying
    @Transactional
    @Query("delete from User u where u.id=:id")
    int deleteUserById(@Param("id") Integer id);
}
