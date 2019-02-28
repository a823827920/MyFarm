package com.ncuedu.entity;

import java.util.Date;

public class Diary {
	private int id;
	private Date time;
	private int field_id;
	private String plant_height;
	private String field_state;
	private String insect_state;
	private String grass_state;
	private int plant_growday;
	private String img1;
	private String img2;
	private String img3;
	@Override
	public String toString() {
		return "Diary [id=" + id + ", time=" + time + ", field_id=" + field_id + ", plant_height=" + plant_height
				+ ", field_state=" + field_state + ", insect_state=" + insect_state + ", grass_state=" + grass_state
				+ ", plant_growday=" + plant_growday + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	public String getPlant_height() {
		return plant_height;
	}
	public void setPlant_height(String plant_height) {
		this.plant_height = plant_height;
	}
	public String getField_state() {
		return field_state;
	}
	public void setField_state(String field_state) {
		this.field_state = field_state;
	}
	public String getInsect_state() {
		return insect_state;
	}
	public void setInsect_state(String insect_state) {
		this.insect_state = insect_state;
	}
	public String getGrass_state() {
		return grass_state;
	}
	public void setGrass_state(String grass_state) {
		this.grass_state = grass_state;
	}
	public int getPlant_growday() {
		return plant_growday;
	}
	public void setPlant_growday(int plant_growday) {
		this.plant_growday = plant_growday;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public Diary(int id, Date time, int field_id, String plant_height, String field_state, String insect_state,
			String grass_state, int plant_growday, String img1, String img2, String img3) {
		super();
		this.id = id;
		this.time = time;
		this.field_id = field_id;
		this.plant_height = plant_height;
		this.field_state = field_state;
		this.insect_state = insect_state;
		this.grass_state = grass_state;
		this.plant_growday = plant_growday;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}
	public Diary(Date time, int field_id, String plant_height, String field_state, String insect_state,
			String grass_state, int plant_growday, String img1, String img2, String img3) {
		super();
		this.time = time;
		this.field_id = field_id;
		this.plant_height = plant_height;
		this.field_state = field_state;
		this.insect_state = insect_state;
		this.grass_state = grass_state;
		this.plant_growday = plant_growday;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
	}
	public Diary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
