package com.homeinsurance.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.homeinsurance.model.HomeInsurance;
import com.homeinsurance.repository.HomeInsuranceRepository;
@Service
public class HomeInsuranceServiceImpl implements HomeInsuranceService{
	HomeInsuranceRepository homeInsuranceRepository;
	
    @Autowired
	public void setHomeInsuranceRepository(HomeInsuranceRepository homeInsuranceRepository) {
		this.homeInsuranceRepository = homeInsuranceRepository;
	}

	@Override
	public void addInsurance(HomeInsurance homeinsurance) {
		homeInsuranceRepository.save(homeinsurance);
	}

	@Override
	public void updateInsurance(HomeInsurance homeinsurance) {
		homeInsuranceRepository.save(homeinsurance);
	}

	@Override
	public void deleteInsurance(int insuranceId) {
		homeInsuranceRepository.deleteById(insuranceId);
	}

	@Override
	public List<HomeInsurance> getAll() {
	  return homeInsuranceRepository.findAll();
	}

	



	@Override
	public List<HomeInsurance> getByVendorName(String vendor) {
		return homeInsuranceRepository.findByVendorName(vendor);
	}

	
	@Override
	public HomeInsurance getByInsuranceId(int insuranceId) {
		return homeInsuranceRepository.findById(insuranceId).get();
	}

	@Override
	public List<HomeInsurance> getInsuranceByCostOfConstruction(double homeCost, double squareFt) {
		 double costOfConst=homeCost/squareFt;
		return homeInsuranceRepository.findByCostOfConstruction(costOfConst);
	}

	
	

}
