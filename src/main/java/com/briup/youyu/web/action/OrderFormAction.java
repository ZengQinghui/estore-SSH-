package com.briup.youyu.web.action;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.briup.youyu.bean.Customer;
import com.briup.youyu.bean.OrderForm;
import com.briup.youyu.bean.OrderLine;
import com.briup.youyu.bean.ShipAddress;
import com.briup.youyu.bean.ShoppingCart;
import com.briup.youyu.common.exception.OrderServiceException;
import com.briup.youyu.service.IOrderFormService;
import com.briup.youyu.service.IOrderLineService;
import com.briup.youyu.service.IShipAddressService;

@Controller
public class OrderFormAction implements SessionAware, RequestAware {

	private String aid;
	private String name;
	private String address;
	private String tel;
	private Long orderid;

	private Map<String, Object> session;
	private Map<String, Object> request;

	@Autowired
	private IShipAddressService shipAddressService;

	@Autowired
	private IOrderFormService orderFormService;

	@Autowired
	private IOrderLineService orderLineService;

	@Action(value = "confirmOrder", results = { @Result(name = "success", location = "/WEB-INF/jsp/confirmSuc.jsp") })
	public String confirmOrder() {
		try {
			ShipAddress shipAddress = null;
			Customer cus = (Customer) session.get("customer");
			ShoppingCart cart = (ShoppingCart) session.get("cart");
			if (aid != null && !"".equals(aid)) {
				shipAddress = shipAddressService.getAddressById(Long.parseLong(aid));
			} else {
				shipAddress = new ShipAddress(name, address, tel);
				shipAddressService.saveShipAddress(shipAddress, cus);
			}
			OrderForm order = new OrderForm(cart.getCost(), new Date(), shipAddress, cus, cart.getOrderLines());
			orderFormService.saveOrder(order);
			Collection<OrderLine> lines = cart.getOrderLines();
			for (OrderLine line : lines) {
				orderLineService.saveOrderLine(line, order);
			}
			request.put("orderId", order.getId());
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Action(value = "toMyOrders", results = { @Result(name = "success", location = "/WEB-INF/jsp/myOrders.jsp") })
	public String toMyOrders() {
		try {
			Customer cus = (Customer) session.get("customer");
			Map<Long, OrderForm> allOrders = orderFormService.listAllOrder(cus.getId());
			request.put("allOrders", allOrders);
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Action(value = "delOrder", results = { @Result(name = "success", type = "chain", location = "toMyOrders") })
	public String delOrder() {
		try {
			orderFormService.delOrder(orderid);
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
