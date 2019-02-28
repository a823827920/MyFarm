package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/UpDownShelf")
public class UpDownShelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Sid=request.getParameter("id");
		String Sflag=request.getParameter("flag");
		int id=Integer.parseInt(Sid);
		int flag=Integer.parseInt(Sflag);
		PlantService ps=new PlantServiceImpl();
		int result=ps.upDownShelf(id,flag);
		PrintWriter writer=response.getWriter();
		writer.println(result);
		writer.flush();
		writer.close();
	}
}
