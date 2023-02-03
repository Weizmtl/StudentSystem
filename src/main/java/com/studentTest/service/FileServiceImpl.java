package com.studentTest.service;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;
import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

import java.util.ArrayList;

/**
 * @author wei
 * @description
 * @create 2023-01-17-13:50
 */
public class FileServiceImpl implements FileService {
	FileDao fs = new FileDaoImpl();
	@Override
	public ArrayList<User> getAllStudent() {
		return fs.getAllStudent();
	}
	@Override
	public User getFileBYNameOrId(String v) {
		return fs.getFileByNameOrId(v);
	}

	@Override
	public User getAdmin(String id) {
		return fs.getAdmin(id);
	}

	@Override
	public ArrayList getPersonFile(String studentId) {
		return fs.getPersonFile(studentId);
	}

	@Override
	public void del(String stu) {
		fs.del(stu);
	}
}
