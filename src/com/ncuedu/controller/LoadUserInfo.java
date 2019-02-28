package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.User;

import net.sf.json.JSONObject;

@WebServlet("/LoadUserInfo")
public class LoadUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		User user=(User)request.getSession().getAttribute("user");
		JSONObject obj=JSONObject.fromObject(user);
		String str=obj.toString();
		PrintWriter pw=response.getWriter();
		pw.println(str);
		pw.flush();
		pw.close();
	}

}
