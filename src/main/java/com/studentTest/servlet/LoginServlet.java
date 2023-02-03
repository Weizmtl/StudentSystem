package com.studentTest.servlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;
import com.studentTest.service.LoginService;
import com.studentTest.service.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author wei
 * @description
 * @create 2023-01-16-21:19
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u_id = req.getParameter("u_id");
		String u_pwd = req.getParameter("u_pwd");
		User u =new User();
		u.setU_id(Integer.parseInt(u_id));
		u.setU_pwd(u_pwd);

		LoginService l = new LoginServiceImpl();
		User user = l.loginService(u);

		if(user !=null){
			FileService fs = new FileServiceImpl();
			ArrayList<User> arr = fs. getAllStudent();


			req.setAttribute("User",user);
			req.setAttribute("arr",arr);
			req.getRequestDispatcher("mainPage.jsp").forward(req,resp);

		}else {
			req.setAttribute("error", "Login failed");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
		}

	}
}
