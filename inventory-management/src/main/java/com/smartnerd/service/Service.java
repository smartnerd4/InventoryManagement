package com.smartnerd.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.zxing.WriterException;
import com.smartnerd.model.AddNewEmployeeModel;
import com.smartnerd.model.OnboardEmployeeModel;

public interface Service {

	public boolean isValidUser(String user_NAME, String password) throws SQLException;

	public boolean generateofferletter(String ename, String doj, int ctc, String role, String file, float basicsalary,
			float hra, float pf, float standarddeduction, float lta)
			throws IOException, InvalidFormatException, InvalidFormatException;

	public OnboardEmployeeModel oemodel(String employeeName);

	public boolean addnewemployee(String employeeName, String employeeEmail, String deptID, Date doj,
			String panNumber, String aadharNumber, Integer workExperience, String previousOrganisation,
			Date relevDate, String reportingID, String managerID, String highestQualification,
			CommonsMultipartFile[] fileUpload, String bloodGroup, String tshirtSize, String emergencyAddress,
			String permanentAddress, String placeofReporting, String gender, String phoneNumber) throws WriterException, IOException;

	public void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException;

	public void IDcreation(File sourceImageFile, byte[] imageFile, File destImageFile, byte[] qrimg, String text,
			String type, String id, String blood) throws IOException;

	public AddNewEmployeeModel get(String id);

}
