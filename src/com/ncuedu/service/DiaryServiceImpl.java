package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.Dao.DiaryDao;
import com.ncuedu.Dao.DiaryDaoImpl;
import com.ncuedu.entity.Diary;

public class DiaryServiceImpl implements DiaryService {

	private DiaryDao dd=new DiaryDaoImpl();
	@Override
	public int addAnDiary(Diary d) {
		return dd.addDiary(d);
	}
	@Override
	public ArrayList<Diary> getDiaryByField(int field_id) {
		return dd.queryDiaryByField(field_id);
	}
	@Override
	public Diary getLatestDiaryByField(int field_id) {
		return dd.queryLatestDiaryByField(field_id);
	}

}
