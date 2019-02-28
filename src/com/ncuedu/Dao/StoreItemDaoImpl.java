package com.ncuedu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ncuedu.entity.Plant;
import com.ncuedu.entity.StoreItem;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class StoreItemDaoImpl implements StoreItemDao {

	@Override
	public int addStoreItem(StoreItem si) {
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		String sql="select plant_num from storeitem_table where plant_id =? and user_id =?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, si.getPlant().getId());
			ps.setInt(2, si.getUser_id());
			rs=ps.executeQuery();
			if(rs.next())
			{
				int num=rs.getInt(1);
				String sql1="update storeitem_table set plant_num=? where plant_id=? and user_id =?";
				ps=con.prepareStatement(sql1);
				ps.setInt(1, num+si.getPlant_num());
				ps.setInt(2, si.getPlant().getId());
				ps.setInt(3, si.getUser_id());
				result=ps.executeUpdate();
			}else {
				String sql1="insert into storeitem_table(plant_id,plant_num,user_id) values(?,?,?)";
				ps=con.prepareStatement(sql1);
				ps.setInt(1, si.getPlant().getId());
				ps.setInt(2, si.getPlant_num());
				ps.setInt(3, si.getUser_id());
				result=ps.executeUpdate();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return result;
	}

	@Override
	public ArrayList<StoreItem> queryStockById(int id) {
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<StoreItem> list=new ArrayList<>();
		PlantDao pd=new PlantDaoImpl();
		String sql="select item_id,plant_id,plant_num from storeitem_table where user_id =?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int item_id=rs.getInt(1);
				int plant_id=rs.getInt(2);
				Plant plant=pd.queryPlantById(plant_id);
				int plant_num=rs.getInt(3);
				StoreItem si=new StoreItem(item_id, plant, plant_num, id);
				list.add(si);
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
		StoreItemDao sid=new StoreItemDaoImpl();
		Plant plant=new Plant(10000, null, 100, null, null, null, 2, null, 2);
		StoreItem si=new StoreItem(plant, 10, 2);
		sid.addStoreItem(si);
		//System.out.println(sid.queryStockById(1));
	}

	@Override
	public int updateStoreItem(StoreItem si) {
		String sql="update storeitem_table set plant_num=plant_num-? where plant_id=? and user_id=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, si.getPlant_num());
			ps.setInt(2, si.getPlant().getId());
			ps.setInt(3, si.getUser_id());
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
