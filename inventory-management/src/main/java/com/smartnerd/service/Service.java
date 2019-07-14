package com.smartnerd.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import com.smartnerd.model.Employee;

public interface Service {

	public boolean isValidUser(String user_NAME, String password)throws SQLException;

	public boolean generateofferletter(String ename, String doj, int ctc, String role,String file) throws IOException, InvalidFormatException, InvalidFormatException;


	public boolean valid(String name);

	public Employee EmployeeUsers(String emp_NAME); 

}
