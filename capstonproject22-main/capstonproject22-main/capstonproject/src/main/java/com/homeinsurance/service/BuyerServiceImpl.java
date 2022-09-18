package com.homeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeinsurance.model.Buyer;
import com.homeinsurance.repository.BuyerRepository;
@Service
public class BuyerServiceImpl implements BuyerService{
	
	BuyerRepository buyerRepository;
	
     @Autowired
	public void setBuyerRepository(BuyerRepository buyerRepository) {
		this.buyerRepository = buyerRepository;
	}

	
	@Override
	public List<Buyer> getBuyerByName(String name) {
		return buyerRepository.findByName(name);
	}


	@Override
	public Buyer getBuyerById(int id) {
		// TODO Auto-generated method stub
		return buyerRepository.findById(id).get();
	}


	@Override
	public List<Buyer> getBuyerByAddressCity(String city) {
		
		return buyerRepository.findByAddressCity(city);
	}


	@Override
	public void addBuyer(Buyer buyer) {
		buyerRepository.save(buyer);
	}

	@Override
	public void deleteBuyerById(int buyerId) {
		buyerRepository.deleteById(buyerId);
	}


	@Override
	public void updateBuyer(Buyer buyer) {
		buyerRepository.save(buyer);
	}


	@Override
	public List<Buyer> getAll() {
		
		return buyerRepository.findAll();
	}


	@Override
	public List<Buyer> getBuyerByPropertiesType(String type) {
		return buyerRepository.findByPropertiesType(type);
	}

}
