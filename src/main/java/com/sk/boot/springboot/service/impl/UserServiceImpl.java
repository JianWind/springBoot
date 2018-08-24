package com.sk.boot.springboot.service.impl;

import com.github.pagehelper.Page;
import com.sk.boot.springboot.entity.User;
import com.github.pagehelper.PageHelper;
import com.sk.boot.springboot.repository.UserRepository;
import com.sk.boot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> getUserPages(@ModelAttribute User user, Integer pageNum, Integer pageSize) {
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        List<User> list = userRepository.findAll();
        return page;
    }
}


