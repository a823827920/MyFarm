package com.ncuedu.entity;

public class Crop {
	private int id;
	private Plant plant;
	private double weight;
	private int user_id;
	@Override
	public String toString() {
		return "Crop [id=" + id + ", plant=" + plant + ", weight=" + weight + ", user_id=" + user_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Plant getPlant() {
		return plant;
	}
	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Crop(int id, Plant plant, double weight, int user_id) {
		super();
		this.id = id;
		this.plant = plant;
		this.weight = weight;
		this.user_id = user_id;
	}
	public Crop(Plant plant, double weight, int user_id) {
		super();
		this.plant = plant;
		this.weight = weight;
		this.user_id = user_id;
	}
	public Crop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
