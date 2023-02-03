package com.studentTest.dao;

import com.studentTest.bean.User;
import com.studentTest.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author wei
 * @description
 * @create 2023-01-16-21:37
 */
public class LoginDaoImpl implements LoginDao{
	@Override
	public User logindao(User u) {
		int id = u.getU_id();
		String pwd = u.getU_pwd();

		//access DB
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		ResultSet res = null;
		//prep SQL statement
		String sql = "SELECT * FROM u_user WHERE u_id="+id+" AND u_pwd='"+pwd+"'";
		try {

			pre = connection.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()) {
				User user = new User();
				user.setU_id(res.getInt("u_id"));
				user.setU_name(res.getString("u_name"));
				user.setU_pwd(res.getString("u_pwd"));
				user.setU_phone(res.getString("u_phone"));
				user.setRole(res.getInt("u_role"));
				user.setIsdelete(res.getInt("u_isdelete"));
				return user;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
