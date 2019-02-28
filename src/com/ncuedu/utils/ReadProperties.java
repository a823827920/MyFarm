package com.ncuedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	public static String getProperInfo(String key) {
		Properties prop=new Properties();
		InputStream in=ReadProperties.class.getResourceAsStream("/mysql.properties");
		try {
			prop.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String info=prop.getProperty(key);
		return info;
	}
	public static void main(String[] args) {
		System.out.println(ReadProperties.getProperInfo("url"));
	}
}	
