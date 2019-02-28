package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.entity.Operation;

public interface OperationService {
	public int addAnOperation(Operation o);
	public ArrayList<Operation> getOperation(int limit,int page);
	public int getOperationNum();
	public int deleteOperation(int id);
}
