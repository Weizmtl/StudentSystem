package com.studentTest.bean;

/**
 * @author wei
 * @description
 * @create 2023-01-18-11:39
 */
public class Major {
	private String major1;
	private String major2;


	public Major(String major1, String major2) {
		this.major1 = major1;
		this.major2 = major2;

	}

	public Major() {
	}

	public String getMajor1() {
		return major1;
	}

	public void setMajor1(String major1) {
		this.major1 = major1;
	}

	public String getMajor2() {
		return major2;
	}

	public void setMajor2(String major2) {
		this.major2 = major2;
	}
}
