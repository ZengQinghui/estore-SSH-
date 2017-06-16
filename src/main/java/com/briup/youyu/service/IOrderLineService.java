package com.briup.youyu.service;

import com.briup.youyu.bean.OrderForm;
import com.briup.youyu.bean.OrderLine;

public interface IOrderLineService {
	public void saveOrderLine(OrderLine line,OrderForm orderForm);

	public void delOrderLine(Long orderId);
}
