package com.ncuedu.adminCon;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject obj=new JSONObject();
		String str="";
		PrintWriter writer=response.getWriter();
		try {
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			List<FileItem> items=upload.parseRequest(request);
			Iterator<FileItem> i=items.iterator();
			//String path="C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\Farm\\img\\other_img";
			String path=request.getSession().getServletContext().getRealPath("/img/other_img");
			while(i.hasNext())
			{
				FileItem fi=(FileItem)i.next();
				String fileName=fi.getName();
				File saveFile=new File(path, fileName);
				fi.write(saveFile);
				obj.put("code", 0);
				obj.put("data", fileName);
				str=obj.toString();
			}
		}catch(Exception e) {
			e.printStackTrace();
			obj.put("code", 1);
			str=obj.toString();
		}finally {
			writer.println(str);
			writer.flush();
			writer.close();
		}
	}

}
