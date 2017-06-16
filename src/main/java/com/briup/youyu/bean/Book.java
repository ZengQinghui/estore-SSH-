package com.briup.youyu.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class Book implements Serializable {
	private static final long serialVersionUID = -368818489154570669L;
	private Long id; // 唯一标识符,主键
	private String name; // 书本名称
	private double price; // 单价
	private Collection<OrderLine> orderLines;

	public Book() {

	}

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
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

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@OneToMany(mappedBy = "book")
	public Collection<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Collection<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
