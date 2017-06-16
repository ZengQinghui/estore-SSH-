package com.briup.youyu.web.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.briup.youyu.bean.Book;
import com.briup.youyu.bean.OrderLine;
import com.briup.youyu.bean.ShoppingCart;

@Controller
public class BookAction implements SessionAware, ApplicationAware {

	private Long id;
	private Integer num;
	private Map<String, Object> session;
	private Map<String, Object> application;
	private Long lineId;
	private Integer bookNum;

	@Action(value = "addToCart", results = { @Result(name = "success", location = "/WEB-INF/jsp/index.jsp"),
			@Result(name = "login", type = "chain", location = "toLogin") })
	public String addToCart() {
		if (session.get("customer") == null) {
			return "login";
		}
		@SuppressWarnings("unchecked")
		Map<Long, Book> allBooks = (Map<Long, Book>) application.get("allBooks");
		OrderLine line = new OrderLine();
		line.setBook(allBooks.get(id));
		line.setNum(num);

		ShoppingCart cart = (ShoppingCart) session.get("cart");
		if (cart == null) {
			cart = new ShoppingCart();
			session.put("cart", cart);
		}
		cart.addLine(line);

		return "success";
	}

	@Action(value = "delOrderLine", results = { @Result(name = "success", location = "/WEB-INF/jsp/shopCar.jsp") })
	public String delOrderLine() {
		ShoppingCart cart = (ShoppingCart) session.get("cart");
		cart.dropLine(lineId);
		return "success";
	}

	@Action(value = "EditOrderLine", results = { @Result(name = "success", location = "/WEB-INF/jsp/shopCar.jsp") })
	public String EditOrderLine() {
		ShoppingCart cart = (ShoppingCart) session.get("cart");
		cart.getOrderline(lineId).setNum(bookNum);
		return "success";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public Integer getBookNum() {
		return bookNum;
	}

	public void setBookNum(Integer bookNum) {
		this.bookNum = bookNum;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

}
