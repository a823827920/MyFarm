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
import com.ncuedu.service.ToPlantService;
import com.ncuedu.service.ToPlantServiceImpl;


@WebServlet("/UpDownRIShelf")
public class UpDownRIShelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Sid=request.getParameter("id");
		int id=Integer.parseInt(Sid);
		ToPlantService tp=new ToPlantServiceImpl();
		int result=tp.upDownShelf(id);
		PrintWriter writer=response.getWriter();
		writer.println(result);
		writer.flush();
		writer.close();
	}
}
