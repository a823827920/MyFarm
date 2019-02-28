package com.ncuedu.Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.jni.User;

import com.ncuedu.entity.Plant;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class PlantDaoImpl implements PlantDao {

	@Override
	public Plant queryPlantById(int id) {
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Plant plant=null;
		String sql="select plant_name,plant_stock,plant_saleprice,plant_des,plant_orderprice,cate_id,plant_img,plant_flag from plant_table where plant_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			plant=new Plant();
			plant.setId(id);
			if(rs.next())
			{
				plant.setName(rs.getString(1));
				plant.setStock(rs.getInt(2));
				plant.setSalePrice(rs.getBigDecimal(3));
				plant.setDes(rs.getString(4));
				plant.setOrderPrice(rs.getBigDecimal(5));
				plant.setCate_id(rs.getInt(6));
				plant.setImg(rs.getString(7));
				plant.setFlag(rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return plant;
	}

	@Override
	public ArrayList<Plant> queryAllOnlinePlants() {
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Plant> list=new ArrayList<>();
		String sql="select plant_id,plant_name,plant_stock,plant_saleprice,plant_des,plant_orderprice,cate_id,plant_img from plant_table where plant_flag =1";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int stock=rs.getInt(3);
				BigDecimal salePrice=rs.getBigDecimal(4);
				String des=rs.getString(5);
				BigDecimal orderPrice=rs.getBigDecimal(6);
				int cate_id=rs.getInt(7);
				String img=rs.getString(8);
				Plant plant=new Plant(id, name, stock, salePrice, des, orderPrice, cate_id, img, 1);
				list.add(plant);
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
	public int updatePlant(Plant plant) {
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		String sql="update plant_table set plant_name=?,plant_stock=?,plant_saleprice=?,plant_des=?,plant_orderprice=?,cate_id=?,plant_img=?,plant_flag=? where plant_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, plant.getName());
			ps.setInt(2, plant.getStock());
			ps.setBigDecimal(3, plant.getSalePrice());
			ps.setString(4, plant.getDes());
			ps.setBigDecimal(5, plant.getOrderPrice());
			ps.setInt(6, plant.getCate_id());
			ps.setString(7, plant.getImg());
			ps.setInt(8, plant.getFlag());
			ps.setInt(9, plant.getId());
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
		Plant p=new Plant(10000, "植物植物", 100, new BigDecimal(100), "测试", new BigDecimal(100), 0, "w1.jpg", 1);
		PlantDao pd=new PlantDaoImpl();
	}

	@Override
	public ArrayList<Plant> queryPlantByName(String namelike) {
		String sql="select plant_id,plant_name,plant_stock,plant_saleprice,plant_des,plant_orderprice,cate_id,plant_img,plant_flag from plant_table where plant_name like ? and plant_flag=1";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Plant> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+namelike+"%");
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int stock=rs.getInt(3);
				BigDecimal salePrice=rs.getBigDecimal(4);
				String des=rs.getString(5);
				BigDecimal orderPrice=rs.getBigDecimal(6);
				int cate_id=rs.getInt(7);
				String img=rs.getString(8);
				int flag=rs.getInt(9);
				Plant plant=new Plant(id, name, stock, salePrice, des, orderPrice, cate_id, img, flag);
				list.add(plant);
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
	public ArrayList<Plant> queryPlantByPrice(BigDecimal begin, BigDecimal end) {
		String sql="select plant_id,plant_name,plant_stock,plant_saleprice,plant_des,plant_orderprice,cate_id,plant_img,plant_flag from plant_table where plant_saleprice >= ? and plant_saleprice <= ? and plant_flag=1";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Plant> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			ps.setBigDecimal(1, begin);
			ps.setBigDecimal(2, end);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int stock=rs.getInt(3);
				BigDecimal salePrice=rs.getBigDecimal(4);
				String des=rs.getString(5);
				BigDecimal orderPrice=rs.getBigDecimal(6);
				int cate_id=rs.getInt(7);
				String img=rs.getString(8);
				int flag=rs.getInt(9);
				Plant plant=new Plant(id, name, stock, salePrice, des, orderPrice, cate_id, img, flag);
				list.add(plant);
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
	public ArrayList<Plant> queryAllPlant(int limit,int page) {
		ArrayList<Plant> list=new ArrayList<>();
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select plant_id,plant_name,plant_stock,plant_saleprice,plant_des,plant_orderprice,cate_id,plant_img,plant_flag from plant_table limit ?,?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (page-1)*limit);
			ps.setInt(2, limit);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int stock=rs.getInt(3);
				BigDecimal salePrice=rs.getBigDecimal(4);
				String des=rs.getString(5);
				BigDecimal orderPrice=rs.getBigDecimal(6);
				int cate_id=rs.getInt(7);
				String img=rs.getString(8);
				int flag=rs.getInt(9);
				Plant plant=new Plant(id, name, stock, salePrice, des, orderPrice, cate_id, img, flag);
				list.add(plant);
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
	public int queryAllPlantNum() {
		String sql="select count(*) from plant_table";
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
	public int delAddPlant(int id,int flag) {
		String sql="update plant_table set plant_flag=? where plant_id =?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, flag);
			ps.setInt(2, id);
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
	public int addPlant(Plant plant) {
		String sql="insert into plant_table(plant_name,plant_stock,plant_saleprice,plant_des,plant_orderprice,cate_id,plant_img,plant_flag) values(?,?,?,?,?,?,?,?)";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, plant.getName());
			ps.setInt(2, plant.getStock());
			ps.setBigDecimal(3, plant.getSalePrice());
			ps.setString(4, plant.getDes());
			ps.setBigDecimal(5, plant.getOrderPrice());
			ps.setInt(6, plant.getCate_id());
			ps.setString(7, plant.getImg());
			ps.setInt(8, plant.getFlag());
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
