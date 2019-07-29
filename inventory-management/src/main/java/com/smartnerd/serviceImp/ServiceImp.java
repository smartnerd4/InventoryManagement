package com.smartnerd.serviceImp;

import java.io.IOException;

import java.sql.Date;
import java.text.ParseException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.File;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import com.smartnerd.dao.Dao;
import com.smartnerd.model.EmployeeModel;
import com.smartnerd.model.UserModel;
import com.smartnerd.service.Service;

@Repository
public class ServiceImp implements Service {
	@Autowired
	private Dao dao;

	public boolean isValidUser(String username, String password) {
		UserModel umodel = dao.isValidUser(username, password);
		if (umodel != null) {
			return true;
		}
		return false;
	}

	public boolean generateofferletter(String ename, String doj, int ctc, String role, String file, float basicsalary,
			float hra, float pf, float standarddeduction, float lta,float specialallowance)
			throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		String nctc = NumberConverter.convertNumberToWords(ctc)+" Rupees Only";
		PDF_Generator.ConvertToPDF(ename, doj, ctc, nctc, role, file, basicsalary, hra, pf, standarddeduction, lta,specialallowance);
		return true;
	}

	public EmployeeModel oemodel(String employeeName) {
		EmployeeModel oemodel = dao.oemodel(employeeName);
		return oemodel;
	}

	public boolean addnewemployee(String employeeName, String employeeEmail, String deptID, String doj,
			String panNumber, String aadharNumber, Integer workExperience, String previousOrganisation,
			String relevDate, String reportingID, String managerID, String highestQualification,
			CommonsMultipartFile[] fileUpload, String bloodGroup, String tshirtSize, String emergencyAddress,
			String permanentAddress, String placeofReporting, String gender, String phoneNumber,Integer citycode) throws WriterException, IOException, ParseException {

		if (dao.addnewemployee(employeeName, employeeEmail, deptID, doj, panNumber, aadharNumber, workExperience,
				previousOrganisation, relevDate, reportingID, managerID, highestQualification, fileUpload,
				bloodGroup, tshirtSize, emergencyAddress, permanentAddress, placeofReporting, gender, phoneNumber,citycode)) {
			return true;
		} else
			return false;
	}

	public void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException {
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);

		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);

		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}

	public void IDcreation(File sourceImageFile, byte[] imageFile, File destImageFile, byte[] qrimg, String text,
			String type, String id, String blood, File destImageFileend, String doj, File actudestImageFilefront,File sourceBackImageFile) throws IOException, FontFormatException {
		IDCard_Generator.Image(imageFile, sourceImageFile, destImageFile);
		IDCard_Generator.Name(text, type, destImageFile, destImageFile);

		IDCard_Generator.Id(id, type, destImageFile, destImageFile);
		IDCard_Generator.Blood(blood, type, destImageFile, destImageFile);
		IDCard_Generator.addQr(qrimg, destImageFile, destImageFile);
		IDCard_Generator.Back(doj,type,sourceBackImageFile,destImageFileend);
		IDCard_Generator.joinBufferedImage(destImageFile ,destImageFileend,actudestImageFilefront);
	}

	public EmployeeModel get(String id) {
	EmployeeModel emp = dao.get(id);
		return emp;
	}

}
