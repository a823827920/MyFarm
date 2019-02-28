package com.ncuedu.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ncuedu.entity.RoomItem;
import com.ncuedu.service.PlantService;
import com.ncuedu.service.PlantServiceImpl;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class ToPlantDaoImpl implements ToPlantDao {
	public ArrayList<RoomItem> queryAll(){
		ArrayList<RoomItem> list=new ArrayList<>();
		String sql="select item_id,plant_id,field_id,item_flag,item_date,item_start,user_id from roomitem_table";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		PlantDao pd=new PlantDaoImpl();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				int plant_id=rs.getInt(2);
				int field_id=rs.getInt(3);
				int flag=rs.getInt(4);
				int user_id=rs.getInt(7);
				Date date=rs.getDate(5);
				Date start=rs.getDate(6);
				RoomItem ri=new RoomItem(id, pd.queryPlantById(plant_id), field_id, user_id, flag, date,start);
				list.add(ri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return list;
	}
	public int queryAllPlantNum(int flag) {
		if(flag==-1) {
			return queryAllPlantNum();
		}
		else {
		String sql="select count(*) from roomitem_table where item_flag=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, flag);
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
	}
	public int queryAllPlantNum() {
		String sql="select count(*) from roomitem_table";
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
	public ArrayList<RoomItem> queryAll(int limit,int page){
		ArrayList<RoomItem> list=new ArrayList<>();
		String sql="select item_id,plant_id,field_id,item_flag,item_date,item_start,user_id from roomitem_table limit ?,?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		PlantDao pd=new PlantDaoImpl();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (page-1)*limit);
			ps.setInt(2, limit);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				int plant_id=rs.getInt(2);
				int field_id=rs.getInt(3);
				int flag=rs.getInt(4);
				int user_id=rs.getInt(7);
				java.util.Date d=null;
				java.util.Date s=null;
				try {
					Date date=rs.getDate(5);
					if(date==null) {
						date=new Date(new java.util.Date().getTime());
					}
					d=new java.util.Date(date.getTime());
					Date start=rs.getDate(6);
					if(start==null) {
						start=new Date(new java.util.Date().getTime());
					}
					s=new java.util.Date(start.getTime());
				}catch(Exception e) {
					e.printStackTrace();
				}
				RoomItem ri=new RoomItem(id, pd.queryPlantById(plant_id), field_id, user_id, flag, d,s);
				list.add(ri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return list;
	}
	public ArrayList<RoomItem> queryAll(int limit,int page,int flag){
		ArrayList<RoomItem> list=new ArrayList<>();
		if(flag==-1) {
			return queryAll(limit, page);
		}
		else {
		String sql="select item_id,plant_id,field_id,item_flag,item_date,item_start,user_id from roomitem_table where item_flag=? limit ?,?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		PlantDao pd=new PlantDaoImpl();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, flag);
			ps.setInt(2, (page-1)*limit);
			ps.setInt(3, limit);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				int plant_id=rs.getInt(2);
				int field_id=rs.getInt(3);
				flag=rs.getInt(4);
				int user_id=rs.getInt(7);
				Date date=rs.getDate(5);
				if(date==null) date=new Date(new java.util.Date().getTime());
				java.util.Date d=new java.util.Date(date.getTime());
				Date start=rs.getDate(6);
				if(start==null) start=new Date(new java.util.Date().getTime());
				java.util.Date s=new java.util.Date(start.getTime());
				RoomItem ri=new RoomItem(id, pd.queryPlantById(plant_id), field_id, user_id, flag, d,s);
				list.add(ri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return list;
		}
	}
	public int upDownShelf(int id) {
		int field_id=this.toShareId();
		String sql="UPDATE roomitem_table SET item_flag=1,field_id=?,item_date=?,item_start=? where item_id=?";
		Date date=new Date(new java.util.Date().getTime());
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, field_id);
			ps.setDate(2, date);
			ps.setDate(3, date);
			ps.setInt(4, id);
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, null);
		}
		return result;
	}
	public ArrayList<RoomItem> queryByFlag(int flag){
		ArrayList<RoomItem> list=new ArrayList<>();
		String sql="select item_id,plant_id,field_id,item_flag,item_date,item_start,user_id from roomitem_table where item_flag=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		PlantDao pd=new PlantDaoImpl();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, flag);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				int plant_id=rs.getInt(2);
				int field_id=rs.getInt(3);
				int user_id=rs.getInt(7);
				Date date=rs.getDate(5);
				java.util.Date d=new java.util.Date(date.getTime());
				Date start=rs.getDate(6);
				java.util.Date s=new java.util.Date(start.getTime());
				RoomItem ri=new RoomItem(id, pd.queryPlantById(plant_id), field_id, user_id, flag, d,s);
				list.add(ri);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return list;
	}
	public int toAddPlant(int user_id,int plant_id) {
		String sql="insert into roomitem_table(plant_id,field_id,user_id,item_flag,item_date,item_start) values (?,?,?,?,?,?)";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, plant_id);
			ps.setInt(2, toShareId());
			ps.setInt(3, user_id);
			ps.setInt(4, 0);
			ps.setDate(5,new Date(new java.util.Date().getTime()));
			ps.setDate(6,new Date(new java.util.Date().getTime()));
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, null);
		}
		return result;
	}
	public static void main(String[] args) {
		ToPlantDao tp=new ToPlantDaoImpl();
		for(int i=1,j=101;i<=10;i++,j++) {
				System.out.println(tp.toAddPlant(i, j));
		}
		
	}
	public int toShareId() {
		String sql="select id from field_table where flag=0 LIMIT 1";
		String sql1="UPDATE field_table SET flag=1 where flag=0 LIMIT 1";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int id=-1;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) id=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps=con.prepareStatement(sql1);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, null);
		}
		
		return id;
	}
}
