package com.smartnerd.serviceImp;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smartnerd.dao.Dao;
import com.smartnerd.model.User;
import com.smartnerd.service.Service;
@Repository
public class ServiceImp implements Service{
	@Autowired
	private Dao dao;
	
	
	public boolean isValidUser(String username, String password)throws SQLException
	{
		SessionFactory sf=dao.getSessionFactory();
		Session s=sf.openSession();
		Criteria cr = s.createCriteria(User.class);
		cr.add(Restrictions.eq("USER_NAME",username));
		cr.add(Restrictions.eq("PASSWORD",password));
		List results = cr.list();
		if(results.size()>0)
		{
			return true;
		}
return false;
    }

}
