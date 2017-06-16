package com.briup.youyu.web.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.briup.youyu.bean.Customer;
import com.briup.youyu.common.exception.CustomerServiceException;
import com.briup.youyu.service.ICustomerService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class CustomerAction implements SessionAware, ModelDriven<Customer>, RequestAware {

	@Autowired
	private ICustomerService customerService;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Customer customer;

	@Action(value = "login", results = { @Result(name = "success", location = "/WEB-INF/jsp/index.jsp"),
			@Result(name = "fail", location = "/WEB-INF/jsp/login.jsp") })
	public String login() {
		try {
			Customer cus = customerService.login(customer.getName(), customer.getPassword());
			session.put("customer", cus);
		} catch (CustomerServiceException e) {
			request.put("loginMsg", e.getMessage());
			return "fail";
		}
		return "success";
	}

	@Action(value = "register", results = { @Result(name = "success", location = "/WEB-INF/jsp/login.jsp"),
			@Result(name = "fail", location = "/WEB-INF/jsp/register.jsp") })
	public String register() {
		try {
			customerService.register(customer);
		} catch (CustomerServiceException e) {
			request.put("registerMsg", e.getMessage());
			return "fail";
		}
		return "success";
	}

	@Action(value = "logout", results = { @Result(name = "success", type = "chain", location = "toIndex") })
	public String logout() {
		session.remove("customer");
		session.remove("cart");
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public Customer getModel() {
		customer = new Customer();
		return customer;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
