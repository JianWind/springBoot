package com.sk.boot.springboot.service;

import com.sk.boot.springboot.entity.User;

public interface UserService {

    com.github.pagehelper.Page<User> getUserPages(User tNlmSysUser, Integer pageNum, Integer pageSize);
}
