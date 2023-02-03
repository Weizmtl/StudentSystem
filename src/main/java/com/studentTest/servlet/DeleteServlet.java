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
 * @create 2023-01-18-14:55
 */
@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
	//"del?v="+v+"&id=${User.getU_id()}";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//admin account
		String adm = req.getParameter("id");
		//deleted account
		String stu = req.getParameter("v");

		FileService fs = new FileServiceImpl();
		fs.del(stu);

		User admUser =fs.getAdmin(adm);
		ArrayList<User> arr = fs.getAllStudent();
		req.setAttribute("User",admUser);
		req.setAttribute("arr",arr);
		req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
	}
}
