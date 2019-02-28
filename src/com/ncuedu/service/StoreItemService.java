package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.entity.StoreItem;

public interface StoreItemService {
	public boolean addStoreItem(StoreItem si);
	public ArrayList<StoreItem> getStoreById(int id);
	public int updateStoreItem(StoreItem si);
}
