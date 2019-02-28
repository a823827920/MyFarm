package com.ncuedu.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ncuedu.entity.Diary;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class DiaryDaoImpl implements DiaryDao {

	@Override
	public int addDiary(Diary d) {
		String sql="insert into diary_table(diary_time,field_id,plant_height,field_state,insect_state,grass_state,plant_growday,diary_img1,diary_img2,diary_img3) values(?,?,?,?,?,?,?,?,?,?)";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result=0;
		try {
			System.out.println(d.getField_id());
			String sql3="select item_start from roomitem_table where field_id=?";
			ps=con.prepareStatement(sql3);
			ps.setInt(1, d.getField_id());
			rs=ps.executeQuery();
			Date start=null;
			if(rs.next())
			{
				start=rs.getDate(1);
			}
			ps=con.prepareStatement(sql);
			ps.setDate(1, new Date(d.getTime().getTime()));
			ps.setInt(2, d.getField_id());
			ps.setString(3, d.getPlant_height());
			ps.setString(4, d.getField_state());
			ps.setString(5, d.getInsect_state());
			ps.setString(6, d.getGrass_state());
			ps.setInt(7, d.getPlant_growday());
			ps.setString(8, d.getImg1());
			ps.setString(9, d.getImg2());
			ps.setString(10, d.getImg3());
			ps.executeUpdate();
			String sql2="update roomitem_table set item_date =? where field_id=?";
			ps=con.prepareStatement(sql2);
			ps.setDate(1,new Date(d.getTime().getTime()));
			ps.setInt(2, d.getField_id());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return result;
	}
	public static void main(String[] args) {
		Diary d=new Diary(new Date(new java.util.Date().getTime()), 1, "", "", "", "", 0, "", "", "");
		DiaryDao dd=new DiaryDaoImpl();
		dd.addDiary(d);
		//System.out.println(dd.queryDiaryByField(1));
	}
	@Override
	public ArrayList<Diary> queryDiaryByField(int field_id) {
		String sql="select diary_id,diary_time,plant_height,field_state,insect_state,grass_state,plant_growday,diary_img1,diary_img2,diary_img3 from diary_table where field_id=? order by diary_time desc";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Diary> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, field_id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				java.util.Date time=new java.util.Date(rs.getDate(2).getTime());
				String plant_height=rs.getString(3);
				String field_state=rs.getString(4);
				String insect_state=rs.getString(5);
				String grass_state=rs.getString(6);
				int plant_growday=rs.getInt(7);
				String img1=rs.getString(8);
				String img2=rs.getString(9);
				String img3=rs.getString(10);
				Diary d=new Diary(id, time, field_id, plant_height, field_state, insect_state, grass_state, plant_growday, img1, img2, img3);
				list.add(d);
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
	public Diary queryLatestDiaryByField(int field_id) {
		String sql="select  diary_id,diary_time,plant_height,field_state,insect_state,grass_state,plant_growday,diary_img1,diary_img2,diary_img3 from diary_table where field_id =? order by diary_time desc ";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Diary d=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, field_id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				int id=rs.getInt(1);
				Date time=rs.getDate(2);
				String plant_height=rs.getString(3);
				String field_state=rs.getString(4);
				String insect_state=rs.getString(5);
				String grass_state=rs.getString(6);
				int plant_growday=rs.getInt(7);
				String img1=rs.getString(8);
				String img2=rs.getString(9);
				String img3=rs.getString(10);
				d=new Diary(id, new java.util.Date(time.getTime()), field_id, plant_height, field_state, insect_state, grass_state, plant_growday, img1, img2, img3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return d;
	}
}
