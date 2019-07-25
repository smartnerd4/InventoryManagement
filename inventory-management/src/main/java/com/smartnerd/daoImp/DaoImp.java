package com.smartnerd.daoImp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.google.zxing.WriterException;
import com.smartnerd.dao.Dao;
import com.smartnerd.model.AddNewEmployeeModel;
import com.smartnerd.model.OnboardEmployeeModel;
import com.smartnerd.model.UserModel;
import com.smartnerd.service.Service;

@Repository
@Transactional
public class DaoImp implements Dao {
	@Autowired
	private SessionFactory sessionFactory = null;
	@Autowired
	private Service Qr;

	public UserModel isValidUser(String username, String password) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(UserModel.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
		UserModel umodel = (UserModel) cr.uniqueResult();
		return umodel;
	}

	public OnboardEmployeeModel oemodel(String employeeName) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(OnboardEmployeeModel.class);
		cr.add(Restrictions.eq("employeeName", employeeName));
		OnboardEmployeeModel oemodel = (OnboardEmployeeModel) cr.uniqueResult();
		return oemodel;
	}

	public boolean addnewemployee(String employeeName, String employeeEmail, String deptID, Date doj,
			String panNumber, String aadharNumber, Integer workExperience, String previousOrganisation,
			Date relevDate, String reportingID, String managerID, String highestQualification,
			CommonsMultipartFile[] fileUpload, String bloodGroup, String tshirtSize, String emergencyAddress,
			String permanentAddress, String placeofReporting, String gender, String phoneNumber) throws WriterException, IOException {
		
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		AddNewEmployeeModel anemodel = new AddNewEmployeeModel();
		anemodel.setEmployeeName(employeeName);
		anemodel.setEmployeeEmail(employeeEmail);
		anemodel.setDeptID(deptID);
		anemodel.setDoj(doj);
		anemodel.setPanNumber(panNumber);
		anemodel.setAadharNumber(aadharNumber);
		anemodel.setWorkExperience(workExperience);
		anemodel.setPreviousOrganisation(previousOrganisation);
		anemodel.setRelevDate(relevDate);
		anemodel.setReportingID(reportingID);
		anemodel.setManagerID(managerID);
		anemodel.setHighestQualification(highestQualification);
		anemodel.setBloodGroup(bloodGroup);
		anemodel.setTshirtSize(tshirtSize);
		anemodel.setEmergencyAddress(emergencyAddress);
		anemodel.setPermanentAddress(permanentAddress);
		anemodel.setPlaceofReporting(placeofReporting);
		anemodel.setGender(gender);
		anemodel.setPhoneNumber(phoneNumber);

		String qrCodeText = "Employee name :" + employeeName + "\n" + "Company Name : SmartNerds" + "\n" + "Email :"
				+ employeeEmail + "\n" + "Phone No :" + phoneNumber;
		String rootPath = System.getProperty("java.io.tmpdir");

		String filePath = rootPath + File.separator + employeeName + ".png";
		int size = 150;
		String fileType = "png";
		File qrFile = new File(filePath);
		Qr.createQRImage(qrFile, qrCodeText, size, fileType);
		System.out.println("DONE");

		File imagePath = new File(filePath);

		byte[] imageInBytes = new byte[(int) imagePath.length()];
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(imagePath);
			inputStream.read(imageInBytes);
			inputStream.close();
			anemodel.setQr(imageInBytes);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		for (CommonsMultipartFile aFile : fileUpload) {
			anemodel.setImage(aFile.getBytes());
		}

		s.save(anemodel);
		s.getTransaction().commit();
		return true;
	}

	public AddNewEmployeeModel get(String id) {
		Session session = sessionFactory.openSession();
		return (AddNewEmployeeModel) session.get(AddNewEmployeeModel.class, id);
	}
}