package com.briup.youyu.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.youyu.bean.OrderForm;
import com.briup.youyu.common.exception.OrderServiceException;
import com.briup.youyu.dao.IOrderFormDao;
import com.briup.youyu.dao.IOrderLineDao;
import com.briup.youyu.service.IOrderFormService;

@Service("orderFormService")
@Transactional
public class IOrderFormServiceImpl implements IOrderFormService {

	@Autowired
	private IOrderFormDao orderFormDao;
	
	@Autowired
	private IOrderLineDao orderLineDao;
	
	@Override
	public void saveOrder(OrderForm order) throws OrderServiceException {
		orderFormDao.saveOrderForm(order);
	}

	@Override
	public void delOrder(Long orderid) throws OrderServiceException {
		orderLineDao.delOrderLine(orderid);
		orderFormDao.delOrderById(orderid);
	}

	@Override
	public Map<Long, OrderForm> listAllOrder(Long customerid) throws OrderServiceException {
		Map<Long, OrderForm> allOrders = orderFormDao.listAllOrder(customerid);
		return allOrders;
	}

	@Override
	public OrderForm findOrderById(Long orderid) throws OrderServiceException {
		return null;
	}

}
