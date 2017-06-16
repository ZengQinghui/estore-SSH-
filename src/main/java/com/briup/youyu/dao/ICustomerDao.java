package com.briup.youyu.dao;

import com.briup.youyu.bean.Customer;

public interface ICustomerDao {
	public void saveCustomer(Customer cus);

	public Customer findCusByName(String name);
}
