package com.ncuedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public static Connection getOneCon()
	{
		String DriverName=ReadProperties.getProperInfo("DriverName");
		String url=ReadProperties.getProperInfo("url");
		String name=ReadProperties.getProperInfo("name");
		String password=ReadProperties.getProperInfo("password");
		Connection con=null;
		try {
			Class.forName(DriverName);
			con=DriverManager.getConnection(url,name,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
