package com.smartnerd.daoImp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.smartnerd.model.EmployeeModel;
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

	public EmployeeModel oemodel(String employeeName) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(EmployeeModel.class);
		cr.add(Restrictions.eq("employeeName", employeeName));
		EmployeeModel oemodel = (EmployeeModel) cr.uniqueResult();
		return oemodel;
	}

	public boolean addnewemployee(String employeeName, String employeeEmail, String deptID, String doj, String panNumber,
			String aadharNumber, Integer workExperience, String previousOrganisation, String relevDate,
			String reportingID, String managerID, String highestQualification, CommonsMultipartFile[] fileUpload,
			String bloodGroup, String tshirtSize, String emergencyAddress, String permanentAddress,
			String placeofReporting, String gender, String phoneNumber, Integer citycode)
			throws WriterException, IOException, ParseException { 
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		EmployeeModel anemodel = new EmployeeModel();
		anemodel.setEmployeeName(employeeName);
		anemodel.setEmployeeEmail(employeeEmail);
		anemodel.setDeptID(deptID);
//		DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//		java.sql.Date date = (java.sql.Date) simpleDateFormat.parse(doj);
		anemodel.setDoj(Date.valueOf(doj));
		anemodel.setPanNumber(panNumber);
		anemodel.setAadharNumber(aadharNumber);
		anemodel.setWorkExperience(workExperience);
		anemodel.setPreviousOrganisation(previousOrganisation);
		anemodel.setRelevDate(Date.valueOf(relevDate));
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
		anemodel.setCity(citycode);
		String qrCodeText = "Employee name :" + employeeName + "\n" + "Company Name : Smartnerd" + "\n" + "Email :"
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

	public EmployeeModel get(String id) {
		Session session = sessionFactory.openSession();
		return (EmployeeModel) session.get(EmployeeModel.class, id);
	}
}