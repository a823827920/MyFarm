package com.ncuedu.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ncuedu.entity.Plant;

public interface PlantService {
	public Plant getPlantById(int id);
	public ArrayList<Plant> getAllOnlinePlant();
	public boolean updatePlant(Plant plant);
	public ArrayList<Plant> getPlantByName(String namelike);
	public ArrayList<Plant> getPlantByPrice(BigDecimal begin,BigDecimal end);
	public ArrayList<Plant> getAllPlant(int limit,int page);
	public int getAllPlantNum();
	public int upDownShelf(int id,int flag);
	public int addPlant(Plant plant);
}
