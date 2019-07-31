package com.smartnerd.dao;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.zxing.WriterException;
import com.smartnerd.model.BusinessCardModel;
import com.smartnerd.model.EmployeeModel;
import com.smartnerd.model.UserModel;

public interface Dao {
	public UserModel isValidUser(String username, String password);

	public EmployeeModel oemodel(String employeeName);

	public boolean addnewemployee(String employeeName, String employeeEmail, String deptID, String doj,
			String panNumber, String aadharNumber, Integer workExperience, String previousOrganisation,
			String relevDate, String reportingID, String managerID, String highestQualification,
			CommonsMultipartFile[] fileUpload, String bloodGroup, String tshirtSize, String emergencyAddress,
			String permanentAddress, String placeofReporting, String gender, String phoneNumber, Integer citycode) throws WriterException, IOException, ParseException;

	public EmployeeModel get(String id);

	public boolean addnewbc(String name, String phno, String designation, String email) throws WriterException, IOException;
	public BusinessCardModel getbc(String name);
}
