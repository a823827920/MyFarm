package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.User;
import com.ncuedu.service.UserService;
import com.ncuedu.service.UserServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/SetUserPassword")
public class SetUserPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user=(User)request.getSession().getAttribute("user");
		String map=request.getParameter("map");
		JSONObject obj=JSONObject.fromObject(map);
		User user1=(User)JSONObject.toBean(obj, User.class);
		user.setPassword(user1.getPassword());
		UserService us=new UserServiceImpl();
		int result=us.setUserPassword(user);
		request.getSession().setAttribute("user", user);
		PrintWriter pw=response.getWriter();
		pw.println(result);
		pw.flush();
		pw.close();
	}

}
