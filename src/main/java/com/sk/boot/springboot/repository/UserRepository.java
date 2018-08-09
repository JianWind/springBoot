package com.sk.boot.springboot.repository;

import com.sk.boot.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * jpa所需Dao,继承Repository
 */
public interface UserRepository extends JpaRepository<User, Long> {

   // User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);

    User findById(long id);

    @Query(value = "select u from User u where u.userName = :userName")
    public User findByUsername(@Param("userName") String username);

    @Query(value = "select u from User u order by u.age desc ")
    public List<User> findAllOrderByAgeDesc();
}