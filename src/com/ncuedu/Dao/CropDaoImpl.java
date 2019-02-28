package com.ncuedu.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ncuedu.entity.Crop;
import com.ncuedu.entity.Plant;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class CropDaoImpl implements CropDao {

	@Override
	public ArrayList<Crop> queryCropByUid(int uid) {
		String sql="select crop_id,plant_id,crop_weight from crop_table where user_id=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Crop> list=new ArrayList<>();
		PlantDao pd=new PlantDaoImpl();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, uid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				int pid=rs.getInt(2);
				Plant plant=pd.queryPlantById(pid);
				double weight=rs.getDouble(3);
				Crop crop=new Crop(id, plant, weight, uid);
				list.add(crop);
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
		CropDao cd=new CropDaoImpl();
		System.out.println(cd.queryCropByCid(1));
	}
	@Override
	public Crop queryCropByCid(int id) {
		String sql="select plant_id,crop_weight,user_id from crop_table where crop_id=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		PlantDao pd=new PlantDaoImpl();
		Crop crop=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				int pid=rs.getInt(1);
				Plant plant=pd.queryPlantById(pid);
				double weight=rs.getDouble(2);
				int uid=rs.getInt(3);
				crop=new Crop(id, plant, weight, uid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return crop;
	}
	@Override
	public int deleteCrop(int id) {
		String sql="delete from crop_table where crop_id=?";
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
	@Override
	public int addCrop(Crop crop) {
		String sql="insert into crop_table(plant_id,crop_weight,user_id) values(?,?,?)";
		int result=0;
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, crop.getPlant().getId());
			ps.setDouble(2, crop.getWeight());
			ps.setInt(3, crop.getUser_id());
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
