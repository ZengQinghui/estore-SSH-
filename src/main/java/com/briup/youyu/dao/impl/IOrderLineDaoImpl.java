package com.briup.youyu.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.briup.youyu.bean.OrderLine;
import com.briup.youyu.dao.IOrderLineDao;

@Repository("orderLineDao")
public class IOrderLineDaoImpl implements IOrderLineDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrderLine(OrderLine line) {
		sessionFactory.getCurrentSession().save(line);
	}

	@Override
	public void delOrderLine(Long orderId) {
		String hql = "Delete FROM OrderLine Where orderform_id=?" ; 
		sessionFactory.getCurrentSession().createQuery(hql).setLong(0, orderId).executeUpdate();
	}

}
