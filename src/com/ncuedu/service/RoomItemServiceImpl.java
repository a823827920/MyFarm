package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.Dao.RoomItemDao;
import com.ncuedu.Dao.RoomItemDaoImpl;
import com.ncuedu.entity.Diary;
import com.ncuedu.entity.RoomItem;

public class RoomItemServiceImpl implements RoomItemService {

	private RoomItemDao rid=new RoomItemDaoImpl();
	@Override
	public int addAnItem(RoomItem ri) {
		return rid.addItem(ri);
	}

	@Override
	public ArrayList<RoomItem> getRoomItemByUid(int user_id) {
		return rid.queryItemByUid(user_id);
	}

	@Override
	public RoomItem getRoomItemByFid(int field_id) {
		return rid.queryRoomItemByFid(field_id);
	}

}
