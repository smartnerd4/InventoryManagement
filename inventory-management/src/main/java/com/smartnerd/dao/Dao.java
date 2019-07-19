package com.smartnerd.dao;

import java.util.Date;

import org.hibernate.SessionFactory;

import com.smartnerd.model.OnboardEmployeeModel;
import com.smartnerd.model.UserModel;

public interface Dao {
	public UserModel isValidUser(String username, String password);

	public OnboardEmployeeModel onboardemployeemodel(String emp_NAME);
	
	public boolean addnewemployee(String employee_Name, String employee_Email, String dept_Id, Date doj,
            String pan_Number, String aadhar_Number, Integer work_Experience, String previous_Organisation,
            Date relev_Date, String reporting_Id, String manager_Id, String education_Qualification);
}
