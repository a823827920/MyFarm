package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.Dao.StoreItemDao;
import com.ncuedu.Dao.StoreItemDaoImpl;
import com.ncuedu.entity.StoreItem;

public class StoreItemServiceImpl implements StoreItemService {
	StoreItemDao sid=new StoreItemDaoImpl();
	@Override
	public boolean addStoreItem(StoreItem si) {
		if(sid.addStoreItem(si)>=1) {
			return true;
		}
		return false;
	}
	@Override
	public ArrayList<StoreItem> getStoreById(int id) {
		return sid.queryStockById(id);
	}
	@Override
	public int updateStoreItem(StoreItem si) {
		return sid.updateStoreItem(si);
	}

}
