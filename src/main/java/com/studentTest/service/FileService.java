package com.studentTest.service;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;

import java.util.ArrayList;

/**
 * @author wei
 * @description
 * @create 2023-01-17-13:49
 */
public interface FileService {
	ArrayList<User> getAllStudent();

	User getFileBYNameOrId(String v);

	User getAdmin(String id);

	ArrayList getPersonFile(String studentId);

	void del(String stu);
}
