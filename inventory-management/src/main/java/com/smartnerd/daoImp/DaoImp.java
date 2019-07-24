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
import com.smartnerd.model.Employee;
import com.smartnerd.model.User;
import com.smartnerd.service.Service;

@Repository
@Transactional
public class DaoImp implements Dao {
	@Autowired
	private SessionFactory sessionFactory = null;
	@Autowired 
	private Service Qr;

	public User isValidUser(String username, String password) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("username", username));
		cr.add(Restrictions.eq("password", password));
		User user = (User) cr.uniqueResult();
		return user;
	}

	public Employee EmployeeUsers(String emp_NAME) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.eq("employee_Name", emp_NAME));

		Employee employee = (Employee) cr.uniqueResult();
		return employee;
	}

	public boolean EmployeeInsertion(String employee_Name, String employee_Email, String dept_Id, Date doj,
			String pan_Number, String aadar_Number, Integer work_Experience, String previous_Organisation,
			Date releve_Date, String reporting_Id, String manager_Id, String education_Qualification,CommonsMultipartFile[] fileUpload, String bloodgroup, String tshirtsize, String emeraddr, String permaaddr, String placeofreporting, String gender, String phno) throws WriterException, IOException {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		Employee emp = new Employee();
		emp.setEmployee_Name(employee_Name);
		emp.setEmployee_Email(employee_Email);
		emp.setDept_Id(dept_Id);

		emp.setDoj(doj);
		emp.setPan_Number(pan_Number);
		emp.setAadar_Number(aadar_Number);
		emp.setWork_Experience(work_Experience);
		emp.setPrevious_Organisation(previous_Organisation);

		emp.setReleve_Date(releve_Date);
		emp.setReporting_Id(reporting_Id);
		emp.setManager_Id(manager_Id);
		emp.setEducation_Qualification(education_Qualification);
		emp.setBloodgroup(bloodgroup);
		emp.setTshirtsize(tshirtsize);
		emp.setEmergencyaddr(emeraddr);
		emp.setPermaaddr(permaaddr);
		emp.setPlaceofreporting(placeofreporting);
		emp.setGender(gender);
		emp.setPhno(phno);
		
	    String qrCodeText = "Employee name :"+employee_Name+"\n"+"Company Name : SmartNerds"+"\n"+"Email :"+employee_Email+"\n"+"Phone No :"+phno;
	      String rootPath = System.getProperty("java.io.tmpdir");

	    String filePath = rootPath + File.separator+employee_Name+".png";
			int size = 150;
			String fileType = "png";
			File qrFile = new File(filePath);
			Qr.createQRImage(qrFile, qrCodeText, size, fileType);
			System.out.println("DONE");
		
		File imagePath = new File(filePath);
		 
		byte[] imageInBytes = new byte[(int)imagePath.length()]; 
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(imagePath);
			inputStream.read(imageInBytes); 
			inputStream.close();
			emp.setQr(imageInBytes);
			
		
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}  
		  for (CommonsMultipartFile aFile : fileUpload){
				emp.setImage(aFile.getBytes());
		  }
		
		s.save(emp);
		s.getTransaction().commit();
		return true;
	}
	public Employee get(String id) {
		Session session = sessionFactory.openSession();
		return (Employee)session.get(Employee.class, id);
	}
}