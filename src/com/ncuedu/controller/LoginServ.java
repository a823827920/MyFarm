package com.ncuedu.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.User;
import com.ncuedu.service.UserService;
import com.ncuedu.service.UserServiceImpl;


@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String temp=request.getParameter("id");
		int id=0;
		try {
			id=Integer.parseInt(temp);
		}catch(NumberFormatException e) {
			
		}finally {
			String password=request.getParameter("password");
			User user=new User(id, password);
			UserService us=new UserServiceImpl();
			user=us.login(user);
			if(user!=null) {
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				String message="用户名或密码错误！";
				request.getRequestDispatcher("login.jsp?message="+message).forward(request, response);
			}
		}
	}

}
