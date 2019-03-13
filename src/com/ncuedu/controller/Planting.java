package com.ncuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Plant;
import com.ncuedu.entity.RoomItem;
import com.ncuedu.entity.StoreItem;
import com.ncuedu.entity.User;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;
import com.ncuedu.service.RoomItemService;
import com.ncuedu.service.RoomItemServiceImpl;
import com.ncuedu.service.StoreItemService;
import com.ncuedu.service.StoreItemServiceImpl;


@WebServlet("/Planting")
public class Planting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Spid=request.getParameter("pid");
		String Samount=request.getParameter("amount");
		int pid=0;
		int amount=0;
		try {
			pid=Integer.parseInt(Spid);
			amount=Integer.parseInt(Samount);
		}catch(Exception e) {
			e.printStackTrace();
		}
		User user=(User)request.getSession().getAttribute("user");
		int uid=0;
		if(user!=null) {
			uid=user.getId();
		}
		PlantService ps=new PlantServiceImpl();
		Plant plant=ps.getPlantById(pid);
		StoreItemService sis=new StoreItemServiceImpl();
		StoreItem si=new StoreItem(plant, amount, uid);
		sis.updateStoreItem(si);
		RoomItemService ris=new RoomItemServiceImpl();
		RoomItem ri=new RoomItem(plant, 0, uid, 0, null, null);
		for(int i=0;i<amount;i++)
		{
			ris.addAnItem(ri);
		}
		request.getRequestDispatcher("zone.jsp").forward(request, response);
	}

}
