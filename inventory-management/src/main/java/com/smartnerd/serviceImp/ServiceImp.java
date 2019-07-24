package com.smartnerd.serviceImp;

import java.io.IOException;

import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.awt.Color;
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
import com.smartnerd.model.Employee;
import com.smartnerd.model.User;
import com.smartnerd.service.Service;

@Repository
public class ServiceImp implements Service {
	@Autowired
	private Dao dao;

	public boolean isValidUser(String username, String password) {
		User user = dao.isValidUser(username, password);
		if (user != null) {
			return true;
		}
		return false;
	}

	public boolean generateofferletter(String ename, String doj, int ctc, String role, String file, float basicsalary,
			float hra, float pf, float standarddeduction, float lta)
			throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		String nctc = NumberConverter.convertNumberToWords(ctc);
		PDF_Generator.ConvertToPDF(ename, doj, ctc, nctc, role, file, basicsalary, hra, pf, standarddeduction, lta);
		return true;
	}

	public Employee EmployeeUsers(String emp_NAME) {
		dao.EmployeeUsers(emp_NAME);
		Employee employee = dao.EmployeeUsers(emp_NAME);
		return employee;
	}

	public boolean insertion(String employee_Name, String employee_Email, String dept_Id, Date doj, String pan_Number,
			String aadar_Number, Integer work_Experience, String previous_Organisation, Date releve_Date,
			String reporting_Id, String manager_Id, String education_Qualification, CommonsMultipartFile[] fileUpload,
			String bloodgroup, String tshirtsize, String emeraddr, String permaaddr, String placeofreporting,
			String gender, String phno) throws WriterException, IOException {
		if (dao.EmployeeInsertion(employee_Name, employee_Email, dept_Id, doj, pan_Number, aadar_Number,
				work_Experience, previous_Organisation, releve_Date, reporting_Id, manager_Id, education_Qualification,
				fileUpload, bloodgroup, tshirtsize, emeraddr, permaaddr, placeofreporting, gender, phno)) {
			return true;
		}
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
			String type, String id, String blood) throws IOException {
		IDCard_Generator.Image(imageFile, sourceImageFile, destImageFile);
		IDCard_Generator.Name(text, type, destImageFile, destImageFile);

		IDCard_Generator.Id(id, type, destImageFile, destImageFile);
		IDCard_Generator.Blood(blood, type, destImageFile, destImageFile);
		IDCard_Generator.addQr(qrimg, destImageFile, destImageFile);
	}

	public Employee get(String id) {
		Employee emp = dao.get(id);
		return emp;
	}

}
