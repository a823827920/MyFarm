package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.Dao.CropDao;
import com.ncuedu.Dao.CropDaoImpl;
import com.ncuedu.entity.Crop;

public class CropServiceImpl implements CropService {

	private CropDao cd=new CropDaoImpl();
	@Override
	public ArrayList<Crop> getCropByUid(int uid) {
		return cd.queryCropByUid(uid);
	}
	@Override
	public Crop getCropByCid(int id) {
		return cd.queryCropByCid(id);
	}
	@Override
	public int deleteCrop(int id) {
		return cd.deleteCrop(id);
	}
	@Override
	public int addAnCrop(Crop crop) {
		return cd.addCrop(crop);
	}
	
}
