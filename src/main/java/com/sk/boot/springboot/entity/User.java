package com.sk.boot.springboot.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false,name = "username",unique = true)
	private String userName;
	@Column(nullable = false,name = "password")
	private String passWord;
	@Column(nullable = false,name = "email",unique = true)
	private String email;
	@Column(nullable = true,name = "nickname",unique = true)
	private String nickName;
	@Column(nullable = false,name = "regtime")
	private String regTime;
	@Column(nullable = false,name = "age")
	private String age;

	public User() {
		super();
	}
	public User(String email, String nickName, String passWord, String userName, String regTime,String age) {
		super();
		this.email = email;
		this.nickName = nickName;
		this.passWord = passWord;
		this.userName = userName;
		this.regTime = regTime;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getAge(){return  age;}
	public void setAge(String age){this.age = age;}


}