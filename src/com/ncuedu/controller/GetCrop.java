package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Crop;
import com.ncuedu.entity.User;
import com.ncuedu.service.CropService;
import com.ncuedu.service.CropServiceImpl;

import net.sf.json.JSONArray;

@WebServlet("/GetCrop")
public class GetCrop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		CropService cs=new CropServiceImpl();
		User user=(User)request.getSession().getAttribute("user");
		int uid=0;
		if(user!=null) uid=user.getId();
		ArrayList<Crop> crops=cs.getCropByUid(uid);
		JSONArray array=JSONArray.fromObject(crops);
		PrintWriter pw=response.getWriter();
		String str=array.toString();
		pw.println(str);
		pw.flush();
		pw.close();
	}

}
