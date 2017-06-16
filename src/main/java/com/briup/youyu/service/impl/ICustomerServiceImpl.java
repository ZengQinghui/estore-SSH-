package com.briup.youyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.youyu.bean.Customer;
import com.briup.youyu.common.exception.CustomerServiceException;
import com.briup.youyu.dao.ICustomerDao;
import com.briup.youyu.service.ICustomerService;

@Service("customerService")
@Transactional
public class ICustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public void register(Customer customer) throws CustomerServiceException {
		Customer cus = customerDao.findCusByName(customer.getName());
		if(cus!=null){
			throw new CustomerServiceException("用户名已存在!!!");
		}
		if(customer.getName().trim().equals("")){
			throw new CustomerServiceException("用户名不能为空!!!");
		}
		customerDao.saveCustomer(customer);
	}

	@Override
	public Customer login(String name, String password) throws CustomerServiceException {
		Customer cus = customerDao.findCusByName(name);
		if(name.trim().equals("") || password.trim().equals("")){
			throw new CustomerServiceException("请输入用户名和密码!!!");
		}
		if(cus==null){
			throw new CustomerServiceException("用户名不存在!!!");
		}
		if(!password.equals(cus.getPassword())){
			throw new CustomerServiceException("密码错误!!!");
		}
		return cus;
	}

	@Override
	public void update(Customer customer) throws CustomerServiceException {

	}

}
