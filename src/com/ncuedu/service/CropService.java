package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.entity.Crop;

public interface CropService {
	public ArrayList<Crop> getCropByUid(int uid);
	public Crop getCropByCid(int id);
	public int deleteCrop(int id);
	public int addAnCrop(Crop crop);
}
