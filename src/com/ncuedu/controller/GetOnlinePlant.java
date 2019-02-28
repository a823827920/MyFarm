package com.ncuedu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Plant;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;

import net.sf.json.JSONArray;

@WebServlet("/GetOnlinePlant")
public class GetOnlinePlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PlantService ps=new PlantServiceImpl();
		ArrayList<Plant> list=ps.getAllOnlinePlant();
		JSONArray fromObject = JSONArray.fromObject(list);
		String str=fromObject.toString();
		//System.out.println(str);
		response.getWriter().println(str);
	}
}
