package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Plant;
import com.ncuedu.entity.RoomItem;
import com.ncuedu.service.RoomItemService;
import com.ncuedu.service.RoomItemServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/GetRoomInfo")
public class GetRoomInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String Sfield_id=request.getParameter("field_id");
		int field_id=0;
		try {
			field_id=Integer.parseInt(Sfield_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		RoomItemService ris=new RoomItemServiceImpl();
		RoomItem ri=ris.getRoomItemByFid(field_id);
		JSONObject obj=JSONObject.fromObject(ri);
		String str=obj.toString();
		PrintWriter pw=response.getWriter();
		pw.print(str);
		pw.flush();
		pw.close();
	}
}
