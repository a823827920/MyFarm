package com.ncuedu.Dao;

import java.util.ArrayList;

import com.ncuedu.entity.Crop;

public interface CropDao {
	public ArrayList<Crop> queryCropByUid(int uid);
	public Crop queryCropByCid(int id);
	public int deleteCrop(int id);
	public int addCrop(Crop crop);
}
