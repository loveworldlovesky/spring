package com.example.demo.mybatis.service;

import java.util.List;

import com.example.demo.mybatis.domain.TUser;

public interface UserService {
	TUser getUser(int id);
	List<TUser> getAllUser();
	Object getStr();
	
	void insert(int userId,String userName);
	void update(int userId,String userName);
	void delete(int userId);

}
