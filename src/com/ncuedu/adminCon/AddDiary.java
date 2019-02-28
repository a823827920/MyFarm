package com.ncuedu.adminCon;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncuedu.entity.Diary;
import com.ncuedu.service.DiaryService;
import com.ncuedu.service.DiaryServiceImpl;
import com.ncuedu.service.OperationService;
import com.ncuedu.service.OperationServiceImpl;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;
import com.ncuedu.service.RoomItemService;
import com.ncuedu.service.RoomItemServiceImpl;

import net.sf.json.JSONObject;

@WebServlet("/AddDiary")
public class AddDiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String map=request.getParameter("map");
		JSONObject object=JSONObject.fromObject(map);
		String Sid=(String)object.get("id");
		int id=Integer.parseInt(Sid);
		OperationService os=new OperationServiceImpl();
		os.deleteOperation(id);
		Diary diary=(Diary)JSONObject.toBean(object,Diary.class);
		diary.setTime(new Date());
		int field_id=diary.getField_id();
		RoomItemService ris=new RoomItemServiceImpl();
		Date start=ris.getRoomItemByFid(field_id).getStart();
		LocalDate startd=LocalDate.of(start.getYear(), start.getMonth(), start.getDate());
		LocalDate now=LocalDate.now();
		diary.setPlant_growday((int)(now.toEpochDay()-startd.toEpochDay()));
		PrintWriter writer=response.getWriter();
		DiaryService ds=new DiaryServiceImpl();
		int result=ds.addAnDiary(diary);
		writer.println(result);
		writer.flush();
		writer.close();
	}

}
