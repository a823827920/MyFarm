package com.ncuedu.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.User;
import com.ncuedu.service.UserService;
import com.ncuedu.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		User user=new User(password, name, sex, tel, email, new BigDecimal(10000), 0,"default.png",null);
		UserService us=new UserServiceImpl();
		boolean result=us.register(user);
		if(result) {
			int id=us.getID();
			user.setId(id);
			request.setAttribute("id", id);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("registerInfo.jsp").forward(request, response);
		}
	}

}
