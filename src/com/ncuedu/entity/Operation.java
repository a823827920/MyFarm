package com.ncuedu.entity;

import java.util.Date;

public class Operation {
	private int id;
	private int user_id;
	private int type;
	private Date date;
	private int field_id;
	public Operation(int user_id, int type, Date date, int field_id) {
		super();
		this.user_id = user_id;
		this.type = type;
		this.date = date;
		this.field_id = field_id;
	}
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(int id, int user_id, int type, Date date, int field_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.type = type;
		this.date = date;
		this.field_id = field_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
}
