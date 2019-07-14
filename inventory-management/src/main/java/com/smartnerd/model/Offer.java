package com.smartnerd.model;

import java.util.Date;

public class Offer {
private String ename;
private String doj;
private int ctc;
private String role;
private String file;
public String getFile() {
	return file;
}
public void setFile(String file) {
	this.file = file;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}

public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
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
