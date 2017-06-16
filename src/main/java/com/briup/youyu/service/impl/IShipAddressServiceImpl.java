package com.briup.youyu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.youyu.bean.Customer;
import com.briup.youyu.bean.ShipAddress;
import com.briup.youyu.dao.IShipAddress;
import com.briup.youyu.service.IShipAddressService;

@Service("shipAddressService")
@Transactional
public class IShipAddressServiceImpl implements IShipAddressService {

	@Autowired
	private IShipAddress shipAddressDao;

	@Override
	public void saveShipAddress(ShipAddress sadres, Customer cus) {
		sadres.setCus(cus);
		shipAddressDao.saveShipAddress(sadres);
	}

	@Override
	public ShipAddress getAddressById(Long id) {
		return shipAddressDao.getAddressById(id);
	}

	@Override
	public List<ShipAddress> getAllAdres(Long cid) {
		List<ShipAddress> allAdres = shipAddressDao.getAllAdres(cid);
		return allAdres;
	}

}
