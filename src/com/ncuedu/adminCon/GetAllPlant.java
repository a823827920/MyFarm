package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;
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
import net.sf.json.JSONObject;

@WebServlet("/GetAllPlant")
public class GetAllPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String limitS=request.getParameter("limit");
		String pageS=request.getParameter("page");
		int limit=Integer.parseInt(limitS);
		int page=Integer.parseInt(pageS);
		PlantService ps=new PlantServiceImpl();
		ArrayList<Plant> plants=ps.getAllPlant(limit,page);
		int count=ps.getAllPlantNum();
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("data", plants);
		obj.put("count", count);
		PrintWriter writer=response.getWriter();
		String str=obj.toString();
		writer.println(str);
		writer.flush();
		writer.close();
	}

}
