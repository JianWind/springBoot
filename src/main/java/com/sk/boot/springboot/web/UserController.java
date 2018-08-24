package com.sk.boot.springboot.web;

import com.github.pagehelper.Page;
import com.sk.boot.springboot.entity.User;
import com.sk.boot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员控制器
 *
 * @author Jane
 *
 */
@RestController
@RequestMapping("member")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserPages")
    public @ResponseBody Page<User> getTNlmSysUserPage(@ModelAttribute User user, Integer pageNum, Integer pageSize){
        Page<User> userPages =  userService.getUserPages(user, pageNum, pageSize);
        return userPages;
    }

}