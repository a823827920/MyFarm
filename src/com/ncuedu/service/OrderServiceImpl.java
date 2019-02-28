package com.ncuedu.service;

import java.util.ArrayList;

import com.ncuedu.Dao.OrderDao;
import com.ncuedu.Dao.OrderDaoImpl;
import com.ncuedu.entity.Order;

public class OrderServiceImpl implements OrderService {

	private OrderDao od=new OrderDaoImpl();
	@Override
	public int addAnOrder(Order o) {
		return od.addOrder(o);
	}
	@Override
	public ArrayList<Order> getAllOrder(int limit,int page) {
		return od.queryAllOrder(limit,page);
	}
	@Override
	public int getDeliveryCount() {
		return od.queryDeliveryCount();
	}
	@Override
	public int handleDelivery(int id) {
		return od.deleteDelivery(id);
	}

}
