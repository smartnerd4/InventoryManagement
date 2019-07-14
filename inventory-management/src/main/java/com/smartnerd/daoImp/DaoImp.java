package com.smartnerd.daoImp;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.smartnerd.dao.Dao;
@Repository
@Transactional
public class DaoImp implements Dao {
	
	private  SessionFactory sessionFactory = null;
	public  SessionFactory getSessionFactory(){
		SessionFactory temp=null;
	      Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	                configuration.getProperties()). build();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	      
	       temp=sessionFactory;
	        return temp;
	}

	public  SessionFactory getSessionFactoryemp(){
		SessionFactory temp=null;
	      Configuration configuration = new Configuration();
	        configuration.configure("employee.cfg.xml");
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	                configuration.getProperties()). build();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	      
	       temp=sessionFactory;
	        return temp;
	}
}
