package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Crop;
import com.ncuedu.entity.Plant;
import com.ncuedu.entity.User;
import com.ncuedu.service.CropService;
import com.ncuedu.service.CropServiceImpl;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/AddCrop")
public class AddCrop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String map=request.getParameter("map");
		JSONObject obj=JSONObject.fromObject(map);
		int user_id=obj.getInt("user_id");
		int plant_id=obj.getInt("plant_id");
		PlantService ps=new PlantServiceImpl();
		Plant plant=ps.getPlantById(plant_id);
		String Sweight=obj.getString("weight");
		double weight=0;
		try {
			weight=Double.parseDouble(Sweight);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Crop crop=new Crop(plant, weight, user_id);
		CropService cs=new CropServiceImpl();
		int result=cs.addAnCrop(crop);
		PrintWriter pw=response.getWriter();
		pw.println(result);
		pw.flush();
		pw.close();
	}
}
