package com.studentTest.servlet;

import com.studentTest.bean.User;
import com.studentTest.service.FileService;
import com.studentTest.service.FileServiceImpl;
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
 * @create 2023-01-19-15:16
 */
@WebServlet("/backMainPage")
public class BackMainPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admId = req.getParameter("admId");
		FileService fs = new FileServiceImpl();
		User user = fs.getAdmin(admId);
		ArrayList<User> arr = fs.getAllStudent();
		req.setAttribute("User", user);
		req.setAttribute("arr", arr);
		req.getRequestDispatcher("mainPage.jsp").forward(req,resp);

	}
}
