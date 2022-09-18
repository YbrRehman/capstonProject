package com.homeinsurance.service;

import java.util.List;

import com.homeinsurance.model.HomeInsurance;

public interface HomeInsuranceService {
	// CRUD
	public void addInsurance(HomeInsurance homeinsurance);

	public void updateInsurance(HomeInsurance homeinsurance);

	public void deleteInsurance(int insuranceId);

	public List<HomeInsurance> getAll();
	//Derived Query
	public HomeInsurance getByInsuranceId(int insuranceId);
	public List<HomeInsurance> getByVendorName(String vendor);
	//Custom Query
	public List<HomeInsurance> getInsuranceByCostOfConstruction(double homeCost, double squareFt);
}
