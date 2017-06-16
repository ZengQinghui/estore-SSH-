package com.briup.youyu.dao;

import java.util.List;

import com.briup.youyu.bean.ShipAddress;

public interface IShipAddress {
	public void saveShipAddress(ShipAddress sadres);

	public ShipAddress getAddressById(Long id);

	public List<ShipAddress> getAllAdres(Long cid);
}
