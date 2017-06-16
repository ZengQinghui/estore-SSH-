package com.briup.youyu.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//订单
@Entity
@Table(name = "tbl_orderform")
public class OrderForm implements Serializable {
	private static final long serialVersionUID = -8863320089820635760L;
	private Long id;
	private double cost; // 订单总额
	private Date orderdate; // 下单日期
	private ShipAddress sadres;
	private Customer cus;
	// 一对多，一个订单对应多个订单项
	private Collection<OrderLine> lines = new HashSet<OrderLine>();

	public OrderForm() {

	}

	public OrderForm(double cost, Date orderdate, ShipAddress sadres, Customer cus, Collection<OrderLine> lines) {
		this.cost = cost;
		this.orderdate = orderdate;
		this.sadres = sadres;
		this.cus = cus;
		this.lines = lines;
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

	@Column(name = "cost")
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Column(name = "orderDate")
	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "shipAddress_id")
	public ShipAddress getSadres() {
		return sadres;
	}

	public void setSadres(ShipAddress sadres) {
		this.sadres = sadres;
	}

	@ManyToOne
	@JoinColumn(name = "customer_id")
	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	@OneToMany(fetch=FetchType.EAGER,targetEntity=OrderLine.class,mappedBy = "order",orphanRemoval=true)
	public Collection<OrderLine> getLines() {
		return lines;
	}

	public void setLines(Collection<OrderLine> lines) {
		this.lines = lines;
	}

}
