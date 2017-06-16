package com.briup.youyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.youyu.bean.OrderForm;
import com.briup.youyu.bean.OrderLine;
import com.briup.youyu.dao.IOrderLineDao;
import com.briup.youyu.service.IOrderLineService;

@Service("orderLineService")
@Transactional
public class IOrderLineServiceImpl implements IOrderLineService{

	@Autowired
	private IOrderLineDao orderLineDao;
	
	@Override
	public void saveOrderLine(OrderLine line, OrderForm orderForm) {
		line.setOrder(orderForm);
		orderLineDao.saveOrderLine(line);
	}

	@Override
	public void delOrderLine(Long orderId) {
		
	}

}
