package com.smartnerd.service;

import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.zxing.WriterException;
import com.smartnerd.model.BusinessCardModel;
import com.smartnerd.model.EmployeeModel;

public interface Service {

	public boolean isValidUser(String user_NAME, String password) throws SQLException;
	
	

	public boolean generateofferletter(String ename, String doj, int ctc, String role, String file, float basicsalary,
			float hra, float pf, float standarddeduction, float lta, float specialallowance)
			throws IOException, InvalidFormatException, InvalidFormatException;

	public EmployeeModel oemodel(String employeeName);

	public boolean addnewemployee(String employeeName, String employeeEmail, String deptID, String doj,
			String panNumber, String aadharNumber, Integer workExperience, String previousOrganisation,
			String string, String reportingID, String managerID, String highestQualification,
			CommonsMultipartFile[] fileUpload, String bloodGroup, String tshirtSize, String emergencyAddress,
			String permanentAddress, String placeofReporting, String gender, String phoneNumber, Integer citycode) throws WriterException, IOException, ParseException;

	public void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException;

	public void IDcreation(File sourceImageFile, byte[] imageFile, File destImageFile, byte[] qrimg, String text,
			String type, String id, String blood, File destImageFileend, String doj, File actudestImageFilefront, File sourceBackImageFile) throws IOException, FontFormatException;

	public EmployeeModel get(String id);
	
	public boolean addnewbc(String name, String phno, String designation, String email) throws WriterException, IOException;
	
	public BusinessCardModel getbcimage(String name);

	public boolean BCcreation(File sourceImageFile, File destImageFilefront, File sourceBackImageFile,
			File destImageFileend, File actudestImageFilefront, String name, String email, String phno,
			String designation, File qrimg) throws IOException, FontFormatException;
}
