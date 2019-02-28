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
import com.ncuedu.entity.RoomItem;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;
import com.ncuedu.service.ToPlantService;
import com.ncuedu.service.ToPlantServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetAllRoomItems
 */
@WebServlet("/GetAllRoomItems")
public class GetAllRoomItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String flagS=request.getParameter("flag");
		String limitS=request.getParameter("limit");
		String pageS=request.getParameter("page");
		int limit=Integer.parseInt(limitS);
		int page=Integer.parseInt(pageS);
		int flag=Integer.parseInt(flagS);
		System.out.println(flag);
		ToPlantService tp=new ToPlantServiceImpl();
		ArrayList<RoomItem> plants=tp.queryAll(limit, page, flag);
		int count=tp.queryAllPlantNum(flag);
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
