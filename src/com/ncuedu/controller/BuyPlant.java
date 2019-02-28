package com.ncuedu.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Plant;
import com.ncuedu.entity.StoreItem;
import com.ncuedu.entity.User;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;
import com.ncuedu.service.StoreItemService;
import com.ncuedu.service.StoreItemServiceImpl;
import com.ncuedu.service.UserService;
import com.ncuedu.service.UserServiceImpl;

@WebServlet("/BuyPlant")
public class BuyPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int plant_id=Integer.parseInt(request.getParameter("id"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		User user=(User)request.getSession().getAttribute("user");
		if(user==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		int user_id=user.getId();
		PlantService ps=new PlantServiceImpl();
		Plant p=ps.getPlantById(plant_id);
		BigDecimal money=p.getSalePrice().multiply(new BigDecimal(amount));
		user.setMoney(user.getMoney().subtract(money));
		if(user.getMoney().compareTo(new BigDecimal(0))<0) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		UserService us=new UserServiceImpl();
		us.updateUser(user);
		p.setStock(p.getStock()-amount);
		ps.updatePlant(p);
		StoreItemService sis=new StoreItemServiceImpl();
		StoreItem si=new StoreItem(p, amount, user_id);
		boolean result=sis.addStoreItem(si);
		if(result) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
