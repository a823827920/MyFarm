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

@WebServlet("/SetUserInfo")
public class SetUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String map=request.getParameter("map");
		JSONObject obj=JSONObject.fromObject(map);
		User userChange=(User)JSONObject.toBean(obj, User.class);
		User user=(User)request.getSession().getAttribute("user");
		int id=0;
		try {
			id=user.getId();
		}catch(Exception e) {
			e.printStackTrace();
		}
		userChange.setId(id);
		UserService us=new UserServiceImpl();
		user.setName(userChange.getName());
		user.setTel(userChange.getTel());
		user.setEmail(userChange.getEmail());
		user.setSex(userChange.getSex());
		user.setDes(userChange.getDes());
		request.getSession().setAttribute("user", user);
		int result=us.setUserInfo(userChange);
		PrintWriter pw=response.getWriter();
		pw.println(result);
		pw.flush();
		pw.close();
	}

}
