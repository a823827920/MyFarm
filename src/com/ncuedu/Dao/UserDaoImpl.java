package com.ncuedu.Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import com.ncuedu.entity.User;
import com.ncuedu.utils.CloseRecours;
import com.ncuedu.utils.GetConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(User user) {
		String sql="insert into user_table(user_password,user_name,user_sex,user_tel,user_email,user_money,user_exp,user_img) values(?,?,?,?,?,?,?,?)";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getName());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getEmail());
			ps.setBigDecimal(6, user.getMoney());
			ps.setInt(7, user.getExp());
			ps.setString(8, user.getImg());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CloseRecours.close(con, ps, null);
		}
		return result;
	}
	public static void main(String[] args) {
		//BigDecimal money=new BigDecimal(100);
		User user=new User(1,"111111");
		UserDao ud=new UserDaoImpl();
		user=ud.checkUser(user);
		//System.out.println(user.getTel());
		//ud.addUser(user);
	}
	@Override
	public User checkUser(User user) {
		int id=user.getId();
		String password=user.getPassword();
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from user_table where user_id =? and user_password=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				user.setName(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setTel(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setMoney(rs.getBigDecimal(7));
				user.setExp(rs.getInt(8));
				user.setImg(rs.getString(9));
				user.setDes(rs.getString(10));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}finally {
			CloseRecours.close(con, ps, rs);
		}
		return null;
	}
	@Override
	public int getID() {
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select max(user_id) from user_table";
		int id=0;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public String queryImgById(int id) {
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select user_img from user_table where user_id =?";
		String img=null;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next())
			{
				img=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	@Override
	public int updateUser(User user) {
		String sql="update user_table set user_password=?,user_name=?,user_sex=?,user_tel=?,user_email=?,user_money=?,user_exp=?,user_img=?,user_des=? where user_id=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getName());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getEmail());
			ps.setBigDecimal(6, user.getMoney());
			ps.setInt(7, user.getExp());
			ps.setString(8, user.getImg());
			ps.setString(9, user.getDes());
			ps.setInt(10, user.getId());
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
	public ArrayList<User> queryAllUser(int limit,int page) {
		String sql="select user_id,user_name,user_sex,user_tel,user_email,user_money,user_img,user_des from user_table limit ?,?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<User> list=new ArrayList<>();
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, (page-1)*limit);
			ps.setInt(2, limit);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String sex=rs.getString(3);
				String tel=rs.getString(4);
				String email=rs.getString(5);
				BigDecimal money=rs.getBigDecimal(6);
				String img=rs.getString(7);
				String des=rs.getString(8);
				User user=new User(id, null, name, sex, tel, email, money, 0, img, des);
				list.add(user);
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
	public int getAllUserNum() {
		String sql="select count(*) from user_table";
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
	public int updateUserInfo(User user) {
		String sql="update user_table set user_name=?,user_tel=?,user_email=?,user_sex=?,user_des=? where user_id=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getTel());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getDes());
			ps.setInt(6, user.getId());
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
	public int updateUserImg(User user) {
		String sql="update user_table set user_img =? where user_id=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getImg());
			ps.setInt(2, user.getId());
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
	public int updateUserPassword(User user) {
		String sql="update user_table set user_password=? where user_id=?";
		Connection con=GetConnection.getOneCon();
		PreparedStatement ps=null;
		int result=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setInt(2, user.getId());
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
