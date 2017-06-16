package com.briup.youyu.dao;

import com.briup.youyu.bean.OrderLine;

public interface IOrderLineDao {
	public void saveOrderLine(OrderLine line);

	public void delOrderLine(Long orderId);
}
