package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.entity.Diary;
import com.ncuedu.entity.RoomItem;

public interface RoomItemService {
	public int addAnItem(RoomItem ri);
	public ArrayList<RoomItem> getRoomItemByUid(int user_id);
	public RoomItem getRoomItemByFid(int field_id);
}
