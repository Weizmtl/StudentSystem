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
 * @create 2023-01-17-14:24
 */
@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String v = req.getParameter("v");

		FileService fs = new FileServiceImpl();
		User u = fs.getFileBYNameOrId(v);
		ArrayList<User> arr = new ArrayList<>();
		arr.add(u);

		String id = req.getParameter("id");
//		System.out.println(id);
		FileService fs2 = new FileServiceImpl();
		User adminU = fs2.getAdmin(id);
//		System.out.println(adminU);
		req.setAttribute("User", adminU);

		if(u != null){
			req.setAttribute("arr",arr);
			req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
		}else{
			FileService f = new FileServiceImpl();
			ArrayList<User> arr2 = f.getAllStudent();
			req.setAttribute("arr",arr2);
			req.getRequestDispatcher("mainPage.jsp").forward(req,resp);
		}

	}
}
