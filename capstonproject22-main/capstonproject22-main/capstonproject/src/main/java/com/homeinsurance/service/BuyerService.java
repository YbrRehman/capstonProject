package com.homeinsurance.service;

import java.util.List;


import com.homeinsurance.model.Buyer;

public interface BuyerService {
	//CRUD Opertions
	public void addBuyer(Buyer buyer);
	void deleteBuyerById(int buyerId);
	void updateBuyer(Buyer buyer);
	List<Buyer> getAll();
	
	//Derived Query
	public List<Buyer> getBuyerByName(String name);
    public Buyer getBuyerById(int id);
	public List<Buyer> getBuyerByAddressCity(String city);
	public List<Buyer> getBuyerByPropertiesType(String type);
}
