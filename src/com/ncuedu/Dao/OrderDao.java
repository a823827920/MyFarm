package com.ncuedu.Dao;

import java.util.ArrayList;

import com.ncuedu.entity.Order;

public interface OrderDao {
	public int addOrder(Order o);
	public ArrayList<Order> queryAllOrder(int limit,int page);
	public int queryDeliveryCount();
	public int deleteDelivery(int id);
}
