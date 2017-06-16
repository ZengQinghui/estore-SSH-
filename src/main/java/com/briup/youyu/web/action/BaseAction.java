package com.briup.youyu.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.briup.youyu.bean.Book;
import com.briup.youyu.bean.Customer;
import com.briup.youyu.bean.ShipAddress;
import com.briup.youyu.common.exception.OrderServiceException;
import com.briup.youyu.service.IBookService;
import com.briup.youyu.service.IShipAddressService;

@Controller
public class BaseAction implements ApplicationAware,SessionAware {

	private Map<String, Object> application;
	private Map<String, Object> session;

	@Autowired
	private IBookService bookService;
	
	@Autowired
	private IShipAddressService shipAddressService;

	@Action(value = "toIndex", results = { @Result(name = "success", location = "/WEB-INF/jsp/index.jsp") })
	public String toIndex() {
		try {
			Map<Long, Book> allBooks = bookService.findAllBooks();
			application.put("allBooks", allBooks);
		} catch (OrderServiceException e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Action(value = "toLogin", results = { @Result(name = "success", location = "/WEB-INF/jsp/login.jsp") })
	public String toLogin() {
		return "success";
	}

	@Action(value = "toRegister", results = { @Result(name = "success", location = "/WEB-INF/jsp/register.jsp") })
	public String toRegister() {
		return "success";
	}

	@Action(value = "toViewBook", results = { @Result(name = "success", location = "/WEB-INF/jsp/viewBook.jsp") })
	public String toViewBook() {
		return "success";
	}

	@Action(value = "toConfirmOrder", results = { @Result(name = "success", location = "/WEB-INF/jsp/confirm.jsp") })
	public String toConfirmOrder() {
		Customer cus = (Customer) session.get("customer");
		List<ShipAddress> allAdres = shipAddressService.getAllAdres(cus.getId());
		session.put("allAdres", allAdres);
		return "success";
	}
	
	@Action(value = "toShopCar", results = { @Result(name = "success", location = "/WEB-INF/jsp/shopCar.jsp") })
	public String toShopCar() {
		return "success";
	}
	
	@Action(value = "toUserInfo", results = { @Result(name = "success", location = "/WEB-INF/jsp/userInfo.jsp") })
	public String toUserInfo() {
		return "success";
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

}
