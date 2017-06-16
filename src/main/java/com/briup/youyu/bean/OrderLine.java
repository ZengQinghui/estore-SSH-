package com.briup.youyu.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//订单项，用来记录订单明细
@Entity
@Table(name="tbl_orderline")
public class OrderLine implements Serializable {
	private static final long serialVersionUID = -7460852488675734125L;
	private Long id; // 唯一标识符
	private int num; // 购买数量
	private Book book; // 订单项上的书籍信息
	//多对一，多个订单项对应一个订单
	private OrderForm order;

	public OrderLine() {
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="num")
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="book_id")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	@ManyToOne
	@JoinColumn(name="orderform_id")
	public OrderForm getOrder() {
		return order;
	}

	public void setOrder(OrderForm order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", num=" + num + ", book=" + book + ", order=" + order + "]";
	}

}
