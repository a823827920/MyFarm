package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.service.UserService;
import com.ncuedu.service.UserServiceImpl;

/**
 * Servlet implementation class LoginImgServ
 */
@WebServlet("/LoginImgServ")
public class LoginImgServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=0;
		String temp=request.getParameter("id");
		try {
			id=Integer.parseInt(temp);
		}catch(NumberFormatException e) {
			
		}finally {
			UserService us=new UserServiceImpl();
			String img=us.getImg(id);
			if(img==null) {
				img="default.png";
			}
			PrintWriter pw=response.getWriter();
			pw.print(img);
		}
	}
}
