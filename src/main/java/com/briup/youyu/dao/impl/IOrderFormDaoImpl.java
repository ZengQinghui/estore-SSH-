package com.briup.youyu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.briup.youyu.bean.OrderForm;
import com.briup.youyu.dao.IOrderFormDao;

@Repository("orderFormDao")
public class IOrderFormDaoImpl implements IOrderFormDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrderForm(OrderForm orderform) {
		sessionFactory.getCurrentSession().save(orderform);
	}

	@Override
	public void delOrderById(Long id) {
		String hql = "Delete FROM OrderForm Where id=?" ; 
		sessionFactory.getCurrentSession().createQuery(hql).setLong(0, id).executeUpdate();
	}

	@Override
	public Map<Long, OrderForm> listAllOrder(Long customerid) {
		@SuppressWarnings("unchecked")
		List<OrderForm> list = sessionFactory.getCurrentSession().createQuery("FROM OrderForm").list();
		Map<Long, OrderForm> map = new HashMap<Long, OrderForm>();
		for (OrderForm order : list) {
			map.put(order.getId(), order);
		}
		return map;
	}

}
