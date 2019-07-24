package com.smartnerd.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.zxing.WriterException;
import com.smartnerd.model.Employee;

public interface Service {

	public boolean isValidUser(String user_NAME, String password)throws SQLException;

	public boolean generateofferletter(String ename, String doj, int ctc, String role,String file,float basicsalary,float hra,float pf,float standarddeduction,float lta ) throws IOException, InvalidFormatException, InvalidFormatException;




	public Employee EmployeeUsers(String emp_NAME);


	public boolean insertion(String employee_Name, String employee_Email, String dept_Id, Date doj, String pan_Number,
			String aadar_Number, Integer work_Experience, String previous_Organisation, Date releve_Date,
			String reporting_Id, String manager_Id, String education_Qualification,CommonsMultipartFile[] fileUpload, String bloodgroup, String tshirtsize, String emeraddr, String permaaddr, String placeofreporting, String gender, String phno)throws WriterException, IOException;

	public void createQRImage(File qrFile, String qrCodeText, int size, String fileType)throws WriterException, IOException;

	public void IDcreation(File sourceImageFile, byte[] imageFile, File destImageFile, byte[] qrimg, String text, String type,
			String id, String blood) throws IOException; 
	public Employee get(String id);
	
}
