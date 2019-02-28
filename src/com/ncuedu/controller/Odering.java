package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Crop;
import com.ncuedu.entity.Order;
import com.ncuedu.service.CropService;
import com.ncuedu.service.CropServiceImpl;
import com.ncuedu.service.OrderService;
import com.ncuedu.service.OrderServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/Odering")
public class Odering extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String map=request.getParameter("map");
		JSONObject obj=JSONObject.fromObject(map);
		Order o=new Order();
		int cid=obj.getInt("id");
		CropService cs=new CropServiceImpl();
		Crop crop=cs.getCropByCid(cid);
		cs.deleteCrop(cid);
		o.setCrop(crop);
		o.setDowndate(new Date());
		o.setAddr(obj.getString("P1")+obj.getString("C1")+obj.getString("A1")+obj.getString("area"));
		o.setName(obj.getString("name"));
		o.setTel(obj.getString("tel"));
		OrderService os=new OrderServiceImpl();
		int result=os.addAnOrder(o);
		PrintWriter pw=response.getWriter();
		pw.println(result);
		pw.flush();
		pw.close();
	}

}
