package com.homeinsurance.model;




import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HomeInsurance {
	@Id
	@GeneratedValue(generator = "insure_gen",strategy =GenerationType.AUTO )
	@SequenceGenerator(name = "insure_gen",sequenceName = "insurance_gen",initialValue = 999,allocationSize = 10)
	private Integer insuranceId;
	private String name;
	
	private double sumAssured;
	//content,building+content,building
	
	private String coverage;
	//fire,earthquake,theft
	private int term;
	private double premium ;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "insurances")
	@JsonIgnore
	private Set<Buyer>  buyers;
	
	
	public HomeInsurance() {
		super();
	}
	public HomeInsurance(String name,  double sumAssured,String coverage, int term,
			double premium, Vendor vendor) {
		super();
		this.name = name;
		this.sumAssured = sumAssured;
		this.coverage = coverage;
		this.term = term;
		this.premium = premium;
		this.vendor = vendor;
	
	}
	public Integer getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public Set<Buyer> getBuyers() {
		return buyers;
	}
	public void setBuyers(Set<Buyer> buyers) {
		this.buyers = buyers;
	}
	@Override
	public String toString() {
		return "HomeInsurance [insuranceName=" + name + ", sumAssured=" + sumAssured + ", coverage=" + coverage
				+ ", term=" + term + ", premium=" + premium + ", vendor=" + vendor + ", buyers=" + buyers + "]";
	}
	
	
	
	
	
	
}