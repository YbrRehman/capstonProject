package com.homeinsurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
	@Id
	@GeneratedValue(generator = "",strategy = GenerationType.AUTO)
	@SequenceGenerator(name ="add_seq",sequenceName = "add_seq" ,initialValue = 100,allocationSize = 1)
	private Integer addressId;
	private String city;
	private String state;
	private long zipcode;
	public Address() {
		super();
	}
	public Address(String city, String state, long zipcode) {
		super();
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public Integer getId() {
		return addressId;
	}
	public void setId(Integer id) {
		this.addressId = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [id=" + addressId + ", City=" + city + ", State=" + state + ", zipcode=" + zipcode + "]";
	}
	

}
