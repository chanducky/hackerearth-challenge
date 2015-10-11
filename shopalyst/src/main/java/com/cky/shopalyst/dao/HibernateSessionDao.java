package com.cky.shopalyst.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class HibernateSessionDao {
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * @return Session
	 */
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
