package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.entity.User;

public interface UserService {
	public boolean register(User user);
	public int getID();
	public User login(User user);
	public String getImg(int id);
	public int updateUser(User user);
	public ArrayList<User> getAllUser(int limit,int page);
	public int getAllUserNum();
	public int setUserInfo(User user);
	public int setUserImg(User user);
	public int setUserPassword(User user);
}
