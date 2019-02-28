package com.ncuedu.Dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ncuedu.entity.Plant;
import com.ncuedu.entity.RoomItem;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class RoomItemDaoImpl implements RoomItemDao {

	@Override
	public int addItem(RoomItem ri) {
		String sql="insert into roomitem_table(plant_id,field_id,user_id,item_flag) values (?,?,?,?)";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, ri.getPlant().getId());
			ps.setInt(2, ri.getField_id());
			ps.setInt(3, ri.getUser_id());
			ps.setInt(4, ri.getFlag());
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
		//RoomItem ri=new RoomItem(1, 1, 1, 1, new Date(0));
		RoomItemDao rid=new RoomItemDaoImpl();
	}

	@Override
	public ArrayList<RoomItem> queryItemByUid(int user_id) {
		ArrayList<RoomItem> list=new ArrayList<>();
		String sql="select item_id,plant_id,field_id,item_flag,item_date,item_start from roomitem_table where user_id=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		PlantDao pd=new PlantDaoImpl();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				int plant_id=rs.getInt(2);
				int field_id=rs.getInt(3);
				int flag=rs.getInt(4);
				Date date=null;
				Date start=null;
				try {
					date=new Date(rs.getDate(5).getTime());
					start=new Date(rs.getDate(6).getTime());
				}catch(Exception e) {
					
				}
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

	@Override
	public RoomItem queryRoomItemByFid(int field_id) {
		String sql="select item_id,user_id,item_flag,item_date,item_start,plant_id from roomitem_table where field_id=?";
		Connection con=GetConnection.getOneCon();
		PlantDao pd=new PlantDaoImpl();
		PreparedStatement ps=null;
		ResultSet rs=null;
		RoomItem ri=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, field_id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				int user_id=rs.getInt(2);
				int flag=rs.getInt(3);
				java.util.Date date=new java.util.Date(rs.getDate(4).getTime());
				java.util.Date start=new java.util.Date(rs.getDate(5).getTime());
				int plant_id=rs.getInt(6);
				Plant plant=pd.queryPlantById(plant_id);
				ri=new RoomItem(id, plant, field_id, user_id, flag, date, start);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return ri;
	}
	

	
}
