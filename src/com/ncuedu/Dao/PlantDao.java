package com.ncuedu.Dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ncuedu.entity.Plant;

public interface PlantDao {
	public Plant queryPlantById(int id);
	public ArrayList<Plant> queryAllOnlinePlants();
	public int updatePlant(Plant plant);
	public ArrayList<Plant> queryPlantByName(String namelike);
	public ArrayList<Plant> queryPlantByPrice(BigDecimal begin,BigDecimal end);
	public ArrayList<Plant> queryAllPlant(int limit,int page);
	public int queryAllPlantNum();
	public int delAddPlant(int id,int flag);
	public int addPlant(Plant plant);
}
