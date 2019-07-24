package com.smartnerd.dao;

import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.zxing.WriterException;
import com.smartnerd.model.Employee;
import com.smartnerd.model.User;

public interface Dao {
	public User isValidUser(String username, String password);

	public Employee EmployeeUsers(String emp_NAME);



	public boolean EmployeeInsertion(String employee_Name, String employee_Email, String dept_Id, Date doj,
			String pan_Number, String aadar_Number, Integer work_Experience, String previous_Organisation,
			Date releve_Date, String reporting_Id, String manager_Id, String education_Qualification,CommonsMultipartFile[] fileUpload, String bloodgroup, String tshirtsize, String emeraddr, String permaaddr, String placeofreporting, String gender,String phno)throws WriterException, IOException;
	public Employee get(String id);
	
}
