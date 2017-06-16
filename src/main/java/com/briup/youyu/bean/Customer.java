package com.briup.youyu.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = -1415977267636644567L;
	private Long id;
	private String name;
	private String password;
	private String zip;
	private String address;
	private String telephone;
	private String email;
	private Set<ShipAddress> shipAddress;
	/**
	 * 关联关系 - 一对多，一个顾客对应多个订单
	 */
	private Set<OrderForm> orders = new HashSet<>();

	public Customer() {
	}

	public Customer(Long id, String name, String password, String zip, String address, String telephone, String email,
			Set<OrderForm> orders) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.orders = orders;
	}

	public Customer(String name, String password) {
		this.name = name;
		this.password = password;
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

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "cus")
	public Set<OrderForm> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderForm> orders) {
		this.orders = orders;
	}

	@OneToMany(mappedBy = "cus")
	public Set<ShipAddress> getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(Set<ShipAddress> shipAddress) {
		this.shipAddress = shipAddress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", zip=" + zip + ", address="
				+ address + ", telephone=" + telephone + ", email=" + email + "]";
	}

}
