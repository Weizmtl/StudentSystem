package com.studentTest.util;

import com.studentTest.bean.User;
import com.studentTest.dao.LoginDaoImpl;

/**
 * @author wei
 * @description
 * @create 2023-01-16-22:25
 */
public class Test {
	public static void main(String[] args) {
		int id =1001;
		String pwd = "a1001";
		User u = new User();
		u.setU_id(id);
		u.setU_pwd(pwd);
		LoginDaoImpl l = new LoginDaoImpl();
		User retUser=l.logindao(u);
		if(retUser!=null){
			System.out.println(retUser.toString());
			System.out.println("correct password and username");
		}else{
			System.out.println("failed");
		}
	}
}
