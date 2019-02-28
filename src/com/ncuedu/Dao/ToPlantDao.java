package com.ncuedu.Dao;

import java.util.ArrayList;

import com.ncuedu.entity.RoomItem;

public interface ToPlantDao {
	public int toAddPlant(int user_id,int plant_id);
	public int toShareId();
	public ArrayList<RoomItem> queryAll();
	public ArrayList<RoomItem> queryAll(int limit,int page);
	public ArrayList<RoomItem> queryAll(int limit,int page,int flag);
	public int queryAllPlantNum();
	public int upDownShelf(int id);
	public ArrayList<RoomItem> queryByFlag(int flag);
	public int queryAllPlantNum(int flag);
}
