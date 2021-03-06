package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Operation;
import com.ncuedu.service.OperationService;
import com.ncuedu.service.OperationServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/GetOperation")
public class GetOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String limitS=request.getParameter("limit");
		String pageS=request.getParameter("page");
		int limit=Integer.parseInt(limitS);
		int page=Integer.parseInt(pageS);
		OperationService os=new OperationServiceImpl();
		ArrayList<Operation> list=os.getOperation(limit,page);
		int count=os.getOperationNum();
		JSONObject obj=new JSONObject();
		obj.put("code", 0);
		obj.put("data", list);
		obj.put("count", count);
		PrintWriter writer=response.getWriter();
		String str=obj.toString();
		writer.println(str);
		writer.flush();
		writer.close();
	}
}
