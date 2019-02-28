package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.entity.Diary;

public interface DiaryService {
	public int addAnDiary(Diary d);
	public ArrayList<Diary> getDiaryByField(int field_id);
	public Diary getLatestDiaryByField(int field_id);
}
