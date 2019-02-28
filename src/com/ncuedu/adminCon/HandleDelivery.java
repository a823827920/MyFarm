package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.service.OrderService;
import com.ncuedu.service.OrderServiceImpl;

@WebServlet("/HandleDelivery")
public class HandleDelivery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Sid=request.getParameter("id");
		int id=Integer.parseInt(Sid);
		OrderService os=new OrderServiceImpl();
		int result=os.handleDelivery(id);
		PrintWriter pw=response.getWriter();
		pw.println(result);
		pw.flush();
		pw.close();
	}
}
