package com.smartnerd.daoImp;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smartnerd.dao.Dao;
import com.smartnerd.model.OnboardEmployeeModel;
import com.smartnerd.model.UserModel;

@Repository
@Transactional
public class DaoImp implements Dao {
	@Autowired
	private  SessionFactory sessionFactory = null;
	
	public UserModel isValidUser(String username, String password)
	{
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(UserModel.class);
		cr.add(Restrictions.eq("USER_NAME", username));
		cr.add(Restrictions.eq("PASSWORD", password));
		UserModel  umodel = (UserModel) cr.uniqueResult();
		return umodel;
}
	public OnboardEmployeeModel onboardemployeemodel(String emp_NAME)
	{
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(OnboardEmployeeModel.class);
		cr.add(Restrictions.eq("employee_Name", emp_NAME));
		
		OnboardEmployeeModel  oemodel = (OnboardEmployeeModel) cr.uniqueResult();
		return oemodel;
	}
	
	public boolean addnewemployee(String employee_Name, String employee_Email, String dept_Id, Date doj,
            String pan_Number, String aadhar_Number, Integer work_Experience, String previous_Organisation,
            Date relev_Date, String reporting_Id, String manager_Id, String education_Qualification) {
        Session s = sessionFactory.openSession();
        s.beginTransaction();
        OnboardEmployeeModel oemodel = new OnboardEmployeeModel();
        oemodel.setEmployee_Name(employee_Name);
        oemodel.setEmployee_Email(employee_Email);
        oemodel.setDept_Id(dept_Id);
        oemodel.setDoj(doj);
        oemodel.setPan_Number(pan_Number);
        oemodel.setAadhar_Number(aadhar_Number);
        oemodel.setWork_Experience(work_Experience);
        oemodel.setPrevious_Organisation(previous_Organisation);
        oemodel.setRelev_Date(relev_Date);
        oemodel.setReporting_Id(reporting_Id);
        oemodel.setManager_Id(manager_Id);
        oemodel.setEducation_Qualification(education_Qualification);

        s.save(oemodel);

        s.getTransaction().commit();
        return true;
	}
}
