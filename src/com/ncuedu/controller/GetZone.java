package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.RoomItem;
import com.ncuedu.entity.User;
import com.ncuedu.service.RoomItemService;
import com.ncuedu.service.RoomItemServiceImpl;

import net.sf.json.JSONArray;


@WebServlet("/GetZone")
public class GetZone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		RoomItemService ris=new RoomItemServiceImpl();
		User user=(User)request.getSession().getAttribute("user");
		int uid=0;
		if(user!=null) {
			uid=user.getId();
		}
		ArrayList<RoomItem> list=ris.getRoomItemByUid(uid);
		JSONArray array=JSONArray.fromObject(list);
		String str=array.toString();
		PrintWriter pw=response.getWriter();
		pw.println(str);
		pw.flush();
		pw.close();
	}
}
