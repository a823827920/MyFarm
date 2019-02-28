package com.ncuedu.adminCon;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Admin;
import com.ncuedu.service.AdminService;
import com.ncuedu.service.AdminServiceImpl;


@WebServlet("/LoginAdminServ")
public class LoginAdminServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String temp=request.getParameter("id");
		int id=Integer.parseInt(temp);
		String password=request.getParameter("password");
		AdminService as=new AdminServiceImpl();
		Admin admin=new Admin(id, password);
		boolean result=as.login(admin);
		if(result) {
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("admin/login.jsp?message=用户名或密码错误").forward(request, response);
		}
	}

}
