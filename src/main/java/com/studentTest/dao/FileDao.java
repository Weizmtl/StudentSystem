package com.studentTest.dao;

import com.studentTest.bean.Major;
import com.studentTest.bean.User;

import java.util.ArrayList;

/**
 * @author wei
 * @description
 * @create 2023-01-17-13:52
 */
public interface FileDao {
	ArrayList<User> getAllStudent();

	User getFileByNameOrId(String v);

	User getAdmin(String id);

	ArrayList getPersonFile(String studentId);

	void del(String stu);
}
