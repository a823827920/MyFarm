package com.ncuedu.Dao;

import java.util.ArrayList;

import com.ncuedu.entity.Operation;

public interface OperationDao {
	public int addOperation(Operation o);
	public ArrayList<Operation> queryOperation(int limit,int page);
	public int queryOperationNum();
	public int deleteOperation(int id);
}
