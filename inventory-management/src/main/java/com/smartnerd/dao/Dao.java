package com.smartnerd.dao;

import org.hibernate.SessionFactory;

public interface Dao {
	public  SessionFactory getSessionFactory();
	public  SessionFactory getSessionFactoryemp();
}
