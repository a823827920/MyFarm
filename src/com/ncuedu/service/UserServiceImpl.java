package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.Dao.UserDao;
import com.ncuedu.Dao.UserDaoImpl;
import com.ncuedu.entity.User;

public class UserServiceImpl implements UserService {
	private UserDao ud=new UserDaoImpl();
	@Override
	public boolean register(User user) {
		if(ud.addUser(user)>=1) return true;
		else return false;
	}
	@Override
	public User login(User user) {
		return ud.checkUser(user);
	}
	@Override
	public int getID() {
		return ud.getID();
	}
	@Override
	public String getImg(int id) {
		return ud.queryImgById(id);
	}
	@Override
	public int updateUser(User user) {
		return ud.updateUser(user);
	}
	@Override
	public ArrayList<User> getAllUser(int limit,int page) {
		return ud.queryAllUser(limit,page);
	}
	@Override
	public int getAllUserNum() {
		return ud.getAllUserNum();
	}
	@Override
	public int setUserInfo(User user) {
		return ud.updateUserInfo(user);
	}
	@Override
	public int setUserImg(User user) {
		return ud.updateUserImg(user);
	}
	@Override
	public int setUserPassword(User user) {
		return ud.updateUserPassword(user);
	}

}
