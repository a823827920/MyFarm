package com.ncuedu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ncuedu.entity.Admin;
import com.ncuedu.utils.GetConnection;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean checkAdmin(Admin admin) {
		String sql="select * from admin_table where admin_id=? and admin_password=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, admin.getId());
			ps.setString(2, admin.getPassword());
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		AdminDao ad=new AdminDaoImpl();
		Admin admin=new Admin(1, "2");
		System.out.println(ad.checkAdmin(admin));
	}
}
