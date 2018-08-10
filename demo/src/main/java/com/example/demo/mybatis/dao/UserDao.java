package com.example.demo.mybatis.dao;

import java.util.List;

import com.example.demo.mybatis.domain.TUser;

public interface UserDao {
	TUser getUser(int id);
	List<TUser> getAllUser();

	Object getStr();
	//#{userId},#{userName},#{password},#{phone}
	void insert(int userId,String userName);
	void update(int userId,String userName);
	void delete(int userId);

}
