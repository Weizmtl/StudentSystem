package com.studentTest.dao;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wei
 * @description
 * @create 2023-01-17-13:53
 */
public class FileDaoImpl implements FileDao {
	@Override
	public ArrayList<User> getAllStudent() {
		//access DB
		ArrayList<User> arr = new ArrayList<>();
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		//prep SQL statement
		String sql = " SELECT * FROM u_user WHERE u_role=1 AND u_isdelete=0";
		try {
			pre = connection.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				User user = new User();
				user.setU_id(res.getInt("u_id"));
				user.setU_name(res.getString("u_name"));
				user.setU_pwd(res.getString("u_pwd"));
				user.setU_phone(res.getString("u_phone"));
				user.setRole(res.getInt("u_role"));
				user.setIsdelete(res.getInt("u_isdelete"));
				arr.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public User getFileByNameOrId(String v) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		//prep SQL statement
		String sql = "SELECT * FROM u_user WHERE u_name='" +v+"'";
		try {
			pre = connection.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				User user = new User();
				user.setU_id(res.getInt("u_id"));
				user.setU_name(res.getString("u_name"));
				user.setU_pwd(res.getString("u_pwd"));
				user.setU_phone(res.getString("u_phone"));
				user.setRole(res.getInt("u_role"));
				user.setIsdelete(res.getInt("u_isdelete"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getAdmin(String id) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;

		//prep SQL statement
		String sql = "SELECT * FROM u_user WHERE u_id=" +id;
		System.out.println(sql);

		try {
			pre = connection.prepareStatement(sql);
			res = pre.executeQuery();

			while (res.next()) {
				User user = new User();
				user.setU_name(res.getString("u_name"));
				user.setU_id(res.getInt("u_id"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList getPersonFile(String studentId) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		//prep SQL statement
		String sql = "SELECT c_name courseName, c_score score " +
					 "FROM" + " course a, userchoose b " +
					 "WHERE a.c_id=b.c_id AND b.u_id=" + studentId;
		System.out.println(sql);
		ArrayList<Major> arr = new ArrayList<>();
		try {
			pre = connection.prepareStatement(sql);
			res = pre.executeQuery();


			while (res.next()) {
				Major major = new Major();
				major.setMajor1(res.getString("courseName"));
				major.setMajor2(res.getString("score"));
				arr.add(major);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public void del(String stu) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		//prep SQL statement
		String sql1 = "DELETE FROM u_user WHERE u_id=" + stu;
		String sql2 = "DELETE FROM userchoose WHERE u_id=" + stu;
		try {
			pre = connection.prepareStatement(sql1);
			pre.executeUpdate();
			pre = connection.prepareStatement(sql2);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insDb(String sql) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;

		try {
			pre = connection.prepareStatement(sql);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
