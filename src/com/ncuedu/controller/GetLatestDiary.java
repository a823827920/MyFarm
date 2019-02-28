package com.ncuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Diary;
import com.ncuedu.service.DiaryService;
import com.ncuedu.service.DiaryServiceImpl;

import net.sf.json.JSONObject;


@WebServlet("/GetLatestDiary")
public class GetLatestDiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		DiaryService ds=new DiaryServiceImpl();
		String Sfield_id=request.getParameter("field_id");
		int field_id=0;
		try {
			field_id=Integer.parseInt(Sfield_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Diary d=ds.getLatestDiaryByField(field_id);
		JSONObject obj=JSONObject.fromObject(d);
		String str=obj.toString();
		PrintWriter pw=response.getWriter();
		pw.println(str);
		pw.flush();
		pw.close();
	}
}
