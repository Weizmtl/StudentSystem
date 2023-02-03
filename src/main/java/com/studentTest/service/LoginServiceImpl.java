package com.studentTest.service;

import com.studentTest.bean.User;
import com.studentTest.dao.LoginDao;
import com.studentTest.dao.LoginDaoImpl;

/**
 * @author wei
 * @description
 * @create 2023-01-16-21:35
 */
public class LoginServiceImpl implements LoginService{
	@Override
	public User loginService(User u) {
		LoginDao ld = new LoginDaoImpl();
		return ld.logindao(u);
	}
}
