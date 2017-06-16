package com.briup.youyu.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_shipaddress")
public class ShipAddress {
	private Long id;
	private String shipuname;
	private String adres;
	private String phoneNumber;
	private Customer cus;

	public ShipAddress() {
	}

	public ShipAddress(String shipuname, String adres, String phoneNumber) {
		this.shipuname = shipuname;
		this.adres = adres;
		this.phoneNumber = phoneNumber;
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

	@Column(name = "shipuname")
	public String getShipuname() {
		return shipuname;
	}

	public void setShipuname(String shipuname) {
		this.shipuname = shipuname;
	}

	@Column(name = "adres")
	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ShipAddress [id=" + id + ", shipuname=" + shipuname + ", adres=" + adres + ", phoneNumber="
				+ phoneNumber + ", cus=" + cus + "]";
	}

}
