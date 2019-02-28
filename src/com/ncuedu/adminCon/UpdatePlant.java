package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

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

@WebServlet("/UpdatePlant")
public class UpdatePlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String map=request.getParameter("map");
		JSONObject object=JSONObject.fromObject(map);
		Plant plant=(Plant)JSONObject.toBean(object,Plant.class);
		PrintWriter writer=response.getWriter();
		PlantService ps=new PlantServiceImpl();
		boolean result=ps.updatePlant(plant);
		if(result) {
			writer.println(1);
		}else {
			writer.println(0);
		}
		writer.flush();
		writer.close();
	}
}
