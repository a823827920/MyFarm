package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.Dao.OperationDao;
import com.ncuedu.Dao.OperationDaoImpl;
import com.ncuedu.entity.Operation;

public class OperationServiceImpl implements OperationService{

	private OperationDao od=new OperationDaoImpl();
	@Override
	public int addAnOperation(Operation o) {
		return od.addOperation(o);
	}
	@Override
	public ArrayList<Operation> getOperation(int limit,int page) {
		return od.queryOperation(limit,page);
	}
	@Override
	public int getOperationNum() {
		return od.queryOperationNum();
	}
	@Override
	public int deleteOperation(int id) {
		return od.deleteOperation(id);
	}
	
}
