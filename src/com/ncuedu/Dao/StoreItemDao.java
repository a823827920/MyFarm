package com.ncuedu.Dao;

import java.util.ArrayList;

import com.ncuedu.entity.StoreItem;

public interface StoreItemDao {
	public int addStoreItem(StoreItem si);
	public ArrayList<StoreItem> queryStockById(int id);
	public int updateStoreItem(StoreItem si);
}
