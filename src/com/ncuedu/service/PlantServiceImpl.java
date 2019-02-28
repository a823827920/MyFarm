package com.ncuedu.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ncuedu.Dao.PlantDao;
import com.ncuedu.Dao.PlantDaoImpl;
import com.ncuedu.entity.Plant;

public class PlantServiceImpl implements PlantService {
	
	PlantDao pd=new PlantDaoImpl();
	@Override
	public Plant getPlantById(int id) {
		return pd.queryPlantById(id);
	}
	@Override
	public ArrayList<Plant> getAllOnlinePlant() {
		return pd.queryAllOnlinePlants();
	}
	@Override
	public boolean updatePlant(Plant plant) {
		if(pd.updatePlant(plant)>=1) {
			return true;
		}
		return false;
	}
	@Override
	public ArrayList<Plant> getPlantByName(String namelike) {
		return pd.queryPlantByName(namelike);
	}
	@Override
	public ArrayList<Plant> getPlantByPrice(BigDecimal begin, BigDecimal end) {
		return pd.queryPlantByPrice(begin, end);
	}
	@Override
	public ArrayList<Plant> getAllPlant(int limit,int page) {
		return pd.queryAllPlant(limit, page);
	}
	@Override
	public int getAllPlantNum() {
		return pd.queryAllPlantNum();
	}
	@Override
	public int upDownShelf(int id,int flag) {
		return pd.delAddPlant(id, flag);
	}
	@Override
	public int addPlant(Plant plant) {
		return pd.addPlant(plant);
	}

}
