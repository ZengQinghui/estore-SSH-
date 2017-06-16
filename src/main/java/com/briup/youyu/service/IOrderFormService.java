package com.briup.youyu.service;

import java.util.Map;

import com.briup.youyu.bean.OrderForm;
import com.briup.youyu.common.exception.OrderServiceException;

public interface IOrderFormService {
	//保存订单
		void saveOrder(OrderForm order) throws OrderServiceException;
		//删除订单
		void delOrder(Long orderid) throws OrderServiceException;
		//查找用户所有订单
		Map<Long,OrderForm> listAllOrder(Long customerid) throws OrderServiceException;
		//查找单个订单
		OrderForm findOrderById(Long orderid) throws OrderServiceException;
}
