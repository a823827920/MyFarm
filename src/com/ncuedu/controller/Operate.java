package com.ncuedu.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Operation;
import com.ncuedu.entity.User;
import com.ncuedu.service.OperationService;
import com.ncuedu.service.OperationServiceImpl;

@WebServlet("/Operate")
public class Operate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Stype=request.getParameter("type");
		int type=Integer.parseInt(Stype);
		String Sfield_id=request.getParameter("field_id");
		int field_id=Integer.parseInt(Sfield_id);
		User user=(User)request.getSession().getAttribute("user");
		try{
			int user_id=user.getId();
			Date date=new Date(new java.util.Date().getTime());
			Operation o=new Operation(user_id, type, date, field_id);
			OperationService os=new OperationServiceImpl();
			os.addAnOperation(o);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
