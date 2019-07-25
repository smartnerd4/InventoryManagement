package com.smartnerd.dao;

import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.zxing.WriterException;
import com.smartnerd.model.AddNewEmployeeModel;
import com.smartnerd.model.OnboardEmployeeModel;
import com.smartnerd.model.UserModel;

public interface Dao {
	public UserModel isValidUser(String username, String password);

	public OnboardEmployeeModel oemodel(String employeeName);

	public boolean addnewemployee(String employeeName, String employeeEmail, String deptID, Date doj,
			String panNumber, String aadharNumber, Integer workExperience, String previousOrganisation,
			Date relevDate, String reportingID, String managerID, String highestQualification,
			CommonsMultipartFile[] fileUpload, String bloodGroup, String tshirtSize, String emergencyAddress,
			String permanentAddress, String placeofReporting, String gender, String phoneNumber) throws WriterException, IOException;

	public AddNewEmployeeModel get(String id);

}
