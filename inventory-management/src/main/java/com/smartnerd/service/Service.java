package com.smartnerd.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import com.smartnerd.model.OnboardEmployeeModel;

public interface Service {

	public boolean isValidUser(String user_NAME, String password)throws SQLException;

	public boolean generateofferletter(String ename, String doj, int ctc, String role,String file) throws IOException, InvalidFormatException, InvalidFormatException;

	public OnboardEmployeeModel onboardemployeemodel(String emp_NAME); 

	public boolean addnewemployee(String employee_Name, String employee_Email, String dept_Id, Date doj,
			String pan_Number, String aadhar_Number, Integer work_Experience, String previous_Organisation,
			Date relev_Date, String reporting_Id, String manager_Id, String education_Qualification);
}
