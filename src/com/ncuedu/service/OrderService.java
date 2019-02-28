package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.entity.Order;

public interface OrderService {
	public int addAnOrder(Order o);
	public ArrayList<Order> getAllOrder(int limit,int page);
	public int getDeliveryCount();
	public int handleDelivery(int id);
}
