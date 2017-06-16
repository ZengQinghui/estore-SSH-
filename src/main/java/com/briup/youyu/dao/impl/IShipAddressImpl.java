package com.briup.youyu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.briup.youyu.bean.ShipAddress;
import com.briup.youyu.dao.IShipAddress;

@Repository("shipAddressDao")
public class IShipAddressImpl implements IShipAddress {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveShipAddress(ShipAddress sadres) {
		sessionFactory.getCurrentSession().save(sadres);
	}

	@Override
	public ShipAddress getAddressById(Long id) {
		
		return (ShipAddress) sessionFactory.getCurrentSession().get(ShipAddress.class, id);
	}

	@Override
	public List<ShipAddress> getAllAdres(Long cid) {
		@SuppressWarnings("unchecked")
		List<ShipAddress> list = sessionFactory.getCurrentSession()
				.createQuery("FROM ShipAddress where customer_id=" + cid).list();
		return list;
	}

}
