package com.smartnerd.model;

import java.util.Date;

public class User {
	private String userid;

	private String username;


	private String password;

	private Date syscredate;


	private Date syslastmoditydate;

	private int actin;

	private String comments;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getSyscredate() {
		return syscredate;
	}

	public void setSyscredate(Date syscredate) {
		this.syscredate = syscredate;
	}

	public Date getSyslastmoditydate() {
		return syslastmoditydate;
	}

	public void setSyslastmoditydate(Date syslastmoditydate) {
		this.syslastmoditydate = syslastmoditydate;
	}

	public int getActin() {
		return actin;
	}

	public void setActin(int actin) {
		this.actin = actin;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}




}