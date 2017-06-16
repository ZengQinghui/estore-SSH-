package com.briup.youyu.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.briup.youyu.bean.Customer;
import com.briup.youyu.dao.ICustomerDao;

@Repository("customerDao")
public class ICustomerDaoImpl implements ICustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCustomer(Customer cus) {
		sessionFactory.getCurrentSession().save(cus);
	}

	@Override
	public Customer findCusByName(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("name", name));
		return (Customer) criteria.uniqueResult();
	}

}
