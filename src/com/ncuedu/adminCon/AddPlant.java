package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Plant;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/AddPlant")
public class AddPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String map=request.getParameter("map");
		JSONObject object=JSONObject.fromObject(map);
		Plant plant=(Plant)JSONObject.toBean(object,Plant.class);
		PrintWriter writer=response.getWriter();
		PlantService ps=new PlantServiceImpl();
		int result=ps.addPlant(plant);
		writer.println(result);
		writer.flush();
		writer.close();
	}

}
