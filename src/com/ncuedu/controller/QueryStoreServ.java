package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.StoreItem;
import com.ncuedu.entity.User;
import com.ncuedu.service.StoreItemService;
import com.ncuedu.service.StoreItemServiceImpl;

import net.sf.json.JSONArray;


@WebServlet("/QueryStoreServ")
public class QueryStoreServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		StoreItemService sis=new StoreItemServiceImpl();
		int id=0;
		User user=(User)request.getSession().getAttribute("user");
		if(user!=null) {
			id=user.getId();
		}
		ArrayList<StoreItem> list=sis.getStoreById(id);
		JSONArray fromObject = JSONArray.fromObject(list);
		PrintWriter pw=response.getWriter();
		pw.println(fromObject.toString());
		pw.flush();
		pw.close();
	}
}
