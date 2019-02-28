package com.ncuedu.entity;

public class StoreItem {
	private int item_id;
	private Plant plant;
	private int plant_num;
	private int user_id;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public int getPlant_num() {
		return plant_num;
	}
	public void setPlant_num(int plant_num) {
		this.plant_num = plant_num;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public StoreItem(int item_id, Plant plant, int plant_num, int user_id) {
		super();
		this.item_id = item_id;
		this.plant = plant;
		this.plant_num = plant_num;
		this.user_id = user_id;
	}
	public StoreItem(Plant plant, int plant_num, int user_id) {
		super();
		this.plant = plant;
		this.plant_num = plant_num;
		this.user_id = user_id;
	}
	public StoreItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
