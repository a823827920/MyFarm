package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.entity.RoomItem;

public interface ToPlantService {
	public int toAddPlant(int user_id,int plant_id);
	public ArrayList<RoomItem> queryAll(int limit,int page);
	public ArrayList<RoomItem> queryAll(int limit,int page,int flag);
	public int queryAllPlantNum();
	public int queryAllPlantNum(int flag);
	public int upDownShelf(int id);
	public ArrayList<RoomItem> queryPlantByFlag(int flag);
}
