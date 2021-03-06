package com.briup.youyu.service;

import com.briup.youyu.bean.Customer;
import com.briup.youyu.common.exception.CustomerServiceException;

public interface ICustomerService {
	//用户注册
	void register(Customer customer) throws CustomerServiceException; 
	//用户登陆
	Customer login(String name,String password) throws CustomerServiceException;
	//用户更新
	void update(Customer customer) throws CustomerServiceException; 
}
