package com.sk.boot.springboot.entity;

import java.text.DateFormat;
import java.util.Date;

import com.sk.boot.springboot.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {


	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

//		userRepository.save(new User("aa@126.com", "aa3", "aa", "aa123",formattedDate));
//		userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
		User user = userRepository.findOne(10L);
		user.setUserName("fengjian");




		Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa1"));
	}

}