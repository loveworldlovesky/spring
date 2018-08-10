package com.example.demo.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mybatis.dao.UserDao;
import com.example.demo.mybatis.domain.TUser;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserDao userDao;

	@Override
	public TUser getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public Object getStr() {
		return userDao.getStr();
	}
//	@Transactional
	@Override
	public void insert(int userId, String userName) {
		userDao.insert(userId, userName);
		
//		try {
//			for(int i = 10;i>0;i--) {
//				System.out.println("倒计时查看事务控制结果："+i);
//				Thread.sleep(1000);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(5/0);
		
	}

	@Override
	public void update(int userId, String userName) {
		userDao.update(userId, userName);
	}
	@Override
	public void delete(int userId) {
		userDao.delete(userId);
	}

	@Override
	public List<TUser> getAllUser() {
		return userDao.getAllUser();
	}


}
