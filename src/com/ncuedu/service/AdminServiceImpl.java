package com.ncuedu.service;

import com.ncuedu.Dao.AdminDao;
import com.ncuedu.Dao.AdminDaoImpl;
import com.ncuedu.entity.Admin;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao ad=new AdminDaoImpl();
	@Override
	public boolean login(Admin admin) {
		return ad.checkAdmin(admin);
	}
	
}
