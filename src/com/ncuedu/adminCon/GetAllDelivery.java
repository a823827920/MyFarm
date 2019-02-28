package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Order;
import com.ncuedu.service.OrderService;
import com.ncuedu.service.OrderServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/GetAllDelivery")
public class GetAllDelivery extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		OrderService os=new OrderServiceImpl();
		String Slimit=request.getParameter("limit");
		String Spage=request.getParameter("page");
		int limit=Integer.parseInt(Slimit);
		int page=Integer.parseInt(Spage);
		ArrayList<Order> orders=os.getAllOrder(limit,page);
		int count=os.getDeliveryCount();
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("data", orders);
		obj.put("count", count);
		String str=obj.toString();
		PrintWriter pw=response.getWriter();
		pw.println(str);
		pw.flush();
		pw.close();
	}
}
