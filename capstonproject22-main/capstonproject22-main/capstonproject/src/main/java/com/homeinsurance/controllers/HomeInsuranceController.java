package com.homeinsurance.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeinsurance.model.HomeInsurance;
import com.homeinsurance.service.HomeInsuranceService;

@RestController
@RequestMapping("homeinsurance-api")
public class HomeInsuranceController {
	
	@Autowired
	HomeInsuranceService homeInsuranceService;
	
	@PostMapping("/homeinsurance")
	public void addHomeInsurance(@RequestBody HomeInsurance homeInsurance) {
		homeInsuranceService.addInsurance(homeInsurance);
	}
	@GetMapping("/homeinsurance")
	public ResponseEntity<List<HomeInsurance>> getByAll() {
		List<HomeInsurance> homeinsurances=homeInsuranceService.getAll();
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc ", "All Investments");
		headers.add("info", "Getting investmentsfrom db");
		System.out.println();
		ResponseEntity<List<HomeInsurance>>responseEntity=
				new ResponseEntity<>(homeinsurances,headers,HttpStatus.OK);
		return  responseEntity;
	}
	@PutMapping("/homeinsurance")
	public void updateHomeInsurance(@RequestBody HomeInsurance homeInsurance) {
		homeInsuranceService.updateInsurance(homeInsurance);
	}
	@DeleteMapping(("/homeinsurance/{insuranceId}"))
	public void deleteHomeInsurance(@PathVariable("insuranceId") int insuranceId) {
		homeInsuranceService.deleteInsurance(insuranceId);
		
	}

	@GetMapping("/homeinsurance/vendorname/{vendorname}")
	ResponseEntity< List<HomeInsurance>> getByVendorName(@PathVariable("vendorname") String vendorname)
	{

		List<HomeInsurance>homeinsurances=homeInsuranceService.getByVendorName(vendorname);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "All investment by vendor name");
		headers.add("info", "Home insurance rest api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(homeinsurances);
	}

	//https://investments/
	@GetMapping("/homeinsurance/cost/{cost}/squareft/{squareft}")
	ResponseEntity < List<HomeInsurance>> getByCostAndSquarefeet(@PathVariable("cost") double cost, @PathVariable("squareft") double squareft)
	{
		List<HomeInsurance>homeinsurances=homeInsuranceService.getInsuranceByCostOfConstruction(cost, squareft);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "All investment by risk and term");
		headers.add("info", "Investment rest api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(homeinsurances);
	}
	@GetMapping("homeinsurance/id/{id}")
	 ResponseEntity<HomeInsurance>  getByID(@PathVariable("id") int id)
	{
		HomeInsurance homeInsurance=homeInsuranceService.getByInsuranceId(id);
		HttpHeaders headres=new HttpHeaders();
		headres.add("desc","getting one innvestment by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headres).body(homeInsurance);
	}


}
