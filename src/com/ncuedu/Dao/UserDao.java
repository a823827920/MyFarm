package com.ncuedu.Dao;

import java.util.ArrayList;

import com.ncuedu.entity.User;

public interface UserDao {
	public int addUser(User user);
	public User checkUser(User user);
	public int getID();
	public String queryImgById(int id);
	public int updateUser(User user);
	public ArrayList<User> queryAllUser(int limit,int page);
	public int getAllUserNum();
	public int updateUserInfo(User user);
	public int updateUserImg(User user);
	public int updateUserPassword(User user);
}
