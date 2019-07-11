package com.smartnerd.model;

import java.util.Date;

public class Offer {
private String ename;
private Date doj;
private int ctc;
private String role;
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public Date getDoj() {
	return doj;
}
public void setDoj(Date doj) {
	this.doj = doj;
}
public int getCtc() {
	return ctc;
}
public void setCtc(int ctc) {
	this.ctc = ctc;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
}
