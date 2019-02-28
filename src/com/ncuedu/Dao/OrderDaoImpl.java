package com.ncuedu.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ncuedu.entity.Crop;
import com.ncuedu.entity.Order;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int addOrder(Order o) {
		String sql="insert into order_table(order_downdate,crop_id,order_name,order_tel,order_addr) values(?,?,?,?,?)";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setDate(1, new Date(o.getDowndate().getTime()));
			ps.setInt(2, o.getCrop().getId());
			ps.setString(3, o.getName());
			ps.setString(4, o.getTel());
			ps.setString(5, o.getAddr());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, null);
		}
		return result;
	}

	@Override
	public ArrayList<Order> queryAllOrder(int limit,int page) {
		String sql="select order_id,order_downdate,crop_id,order_name,order_tel,order_addr from order_table limit ?,?";
		ArrayList<Order> list=new ArrayList<>();
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		CropDao cd=new CropDaoImpl();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (page-1)*limit);
			ps.setInt(2, limit);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				java.util.Date downdate=new java.util.Date(rs.getDate(2).getTime());
				int crop_id=rs.getInt(3);
				Crop crop=cd.queryCropByCid(crop_id);
				String name=rs.getString(4);
				String tel=rs.getString(5);
				String addr=rs.getString(6);
				Order o=new Order(id, downdate, crop, name, tel, addr);
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
	public static void main(String[] args) {
		OrderDao od=new OrderDaoImpl();
		System.out.println(od.queryDeliveryCount());
	}

	@Override
	public int queryDeliveryCount() {
		String sql="select count(*) from order_table";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return result;
	}

	@Override
	public int deleteDelivery(int id) {
		String sql="delete from order_table where order_id=?";
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
