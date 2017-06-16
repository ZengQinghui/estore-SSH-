package com.briup.youyu.service;

import java.util.List;

import com.briup.youyu.bean.Customer;
import com.briup.youyu.bean.ShipAddress;

public interface IShipAddressService {
	public void saveShipAddress(ShipAddress sadres, Customer cus);

	public ShipAddress getAddressById(Long id);

	public List<ShipAddress> getAllAdres(Long cid);
}
