package com.briup.youyu.dao;

import java.util.Map;

import com.briup.youyu.bean.OrderForm;

public interface IOrderFormDao {
	public void saveOrderForm(OrderForm orderform);

	public void delOrderById(Long id);
	
	public Map<Long, OrderForm> listAllOrder(Long customerid);
}
