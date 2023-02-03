package com.studentTest.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author wei
 * @description
 * @create 2023-01-19-14:41
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admId = req.getParameter("admId");
		String stuId = req.getParameter("stuId");

		req.setAttribute("admId", admId);
		req.setAttribute("stuId", stuId);
		req.getRequestDispatcher("update.jsp").forward(req,resp);

	}
}
