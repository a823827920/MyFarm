	package com.ncuedu.Dao;

import java.util.ArrayList;

import com.ncuedu.entity.Diary;

public interface DiaryDao {
	public int addDiary(Diary d);
	public ArrayList<Diary> queryDiaryByField(int field_id);
	public Diary queryLatestDiaryByField(int field_id);
}
