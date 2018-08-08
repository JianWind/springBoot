package com.sk.boot.springboot.repository;

import com.sk.boot.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);

    User findById(long id);

    Long deleteById(Long id);

}