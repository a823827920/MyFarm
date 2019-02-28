package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Plant;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;

import net.sf.json.JSONArray;
@WebServlet("/QueryPlant")
public class QueryPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		PlantService ps=new PlantServiceImpl();
		response.setCharacterEncoding("utf-8");
		if(flag.equals("1")) {
			String name=request.getParameter("name");
			System.out.println(name);
			ArrayList<Plant> plants=ps.getPlantByName(name);
			JSONArray fromObject = JSONArray.fromObject(plants);
			String str=fromObject.toString();
			PrintWriter writer=response.getWriter();
			writer.println(str);
			writer.flush();
			writer.close();
		}else if(flag.equals("2")) {
			String temp1=request.getParameter("begin");
			String temp2=request.getParameter("end");
			if(temp1=="") {
				temp1="0";
			}
			if(temp2=="") {
				temp2="999999";
			}
			Pattern pattern=Pattern.compile("[0-9]*");
			Matcher isNum=pattern.matcher(temp1);
			if(!isNum.matches()) {
				temp1="0";
			}
			isNum=pattern.matcher(temp2);
			if(!isNum.matches()) {
				temp2="999999";
			}
			int bbegin=0,eend=0;
			try {
				bbegin=Integer.parseInt(temp1);
				eend=Integer.parseInt(temp2);
				if(bbegin>eend) {
					bbegin=0;
					eend=999999;
				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}finally {
				BigDecimal begin=new BigDecimal(bbegin);
				BigDecimal end=new BigDecimal(eend);
				ArrayList<Plant> plants=ps.getPlantByPrice(begin, end);
				JSONArray fromObject = JSONArray.fromObject(plants);
				String str=fromObject.toString();
				PrintWriter writer=response.getWriter();
				writer.println(str);
				writer.flush();
				writer.close();
			}
		}
	}
}
