package com.ncuedu.Dao;

import java.util.ArrayList;

import com.ncuedu.entity.RoomItem;

public interface RoomItemDao {
	public int addItem(RoomItem ri);
	public ArrayList<RoomItem> queryItemByUid(int user_id);
	public RoomItem queryRoomItemByFid(int field_id);
}
