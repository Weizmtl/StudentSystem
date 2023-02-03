package com.studentTest.servlet;
import com.studentTest.bean.Major;
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
 * @create 2023-01-17-23:20
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//check grade for each person

		String studentId = req.getParameter("v");
		FileService fs = new FileServiceImpl();
		ArrayList<Major> studentUser = fs.getPersonFile(studentId);


		req.setAttribute("arr",studentUser);
		req.getRequestDispatcher("scorePage.jsp").forward(req,resp);
	}
}
