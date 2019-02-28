package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.Dao.ToPlantDao;
import com.ncuedu.Dao.ToPlantDaoImpl;
import com.ncuedu.entity.RoomItem;

public class ToPlantServiceImpl implements ToPlantService {
	ToPlantDao tp=new ToPlantDaoImpl();
	public int toAddPlant(int user_id,int plant_id) {
		return tp.toAddPlant(user_id, plant_id);
		
	}
	public ArrayList<RoomItem> queryAll(int limit,int page){
		return tp.queryAll(limit, page);
	}
	public int queryAllPlantNum() {
		return tp.queryAllPlantNum();
	}
	public int upDownShelf(int id) {
		return tp.upDownShelf(id);
	}
	public ArrayList<RoomItem> queryPlantByFlag(int flag) {
		return null;
	}
	public ArrayList<RoomItem> queryAll(int limit,int page,int flag){
		return tp.queryAll(limit, page, flag);
	}
	public int queryAllPlantNum(int flag) {
		return tp.queryAllPlantNum(flag);
	}

}
