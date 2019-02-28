package com.ncuedu.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ncuedu.entity.Operation;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class OperationDaoImpl implements OperationDao {

	@Override
	public int addOperation(Operation o) {
		String sql1="select * from operation_table where user_id=? and operation_type=? and operation_date=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql1);
			ps.setInt(1, o.getUser_id());
			ps.setInt(2, o.getType());
			ps.setDate(3, new Date(o.getDate().getTime()));
			rs=ps.executeQuery();
			if(!rs.next())
			{
				String sql2="insert into operation_table(user_id,operation_type,operation_date,field_id) values(?,?,?,?)";
				ps=con.prepareStatement(sql2);
				ps.setInt(1, o.getUser_id());
				ps.setInt(2, o.getType());
				ps.setDate(3, new Date(o.getDate().getTime()));
				ps.setInt(4, o.getField_id());
				result=ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return result;
	}
	public static void main(String[] args) {
		java.util.Date d=new java.util.Date();
		Date date=new Date(d.getTime());
		Operation o=new Operation(1, 1, date, 100);
		OperationDao od=new OperationDaoImpl();
	}
	@Override
	public ArrayList<Operation> queryOperation(int limit,int page) {
		String sql="select operation_id,user_id,operation_type,operation_date,field_id from operation_table limit ?,?";
		ArrayList<Operation> list=new ArrayList<>();
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (page-1)*limit);
			ps.setInt(2, limit);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				int user_id=rs.getInt(2);
				int type=rs.getInt(3);
				java.util.Date date=new java.util.Date(rs.getDate(4).getTime());
				int field_id=rs.getInt(5);
				Operation o=new Operation(id, user_id, type, date, field_id);
				list.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return list;
	}
	@Override
	public int queryOperationNum() {
		String sql="select count(*) from Operation_table";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int amount=0;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				amount=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return amount;
	}
	@Override
	public int deleteOperation(int id) {
		String sql="delete from operation_table where operation_id = ?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, null);
		}
		return result;
	}
}
