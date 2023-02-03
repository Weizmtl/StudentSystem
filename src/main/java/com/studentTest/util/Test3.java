package com.studentTest.util;

import com.studentTest.dao.FileDao;
import com.studentTest.dao.FileDaoImpl;

/**
 * @author wei
 * @description
 * @create 2023-01-18-10:43
 */
public class Test3 {
	public static void main(String[] args) {
		for (int i = 1002; i <= 1027;i++) {
			int[] score = new int[4];

			for (int j = 0; j<4;j++) {
				score[j]=(int)(Math.random() *100);
			}
			String sql= "INSERT INTO userchoose(u_id, c_id, c_score)\n" +
					"VALUES ("+i+",4001,"+score[0]+"),("+i+",4002,"+score[1]+"),("+i+",4003,"+score[2]+"),("+i+",4004,"+score[3]+")";
			FileDaoImpl fd = new FileDaoImpl();
			fd.insDb(sql);
		}

	}

}
