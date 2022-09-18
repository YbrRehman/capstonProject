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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homeinsurance.model.Buyer;

import com.homeinsurance.service.BuyerService;

@RestController
@RequestMapping("buyer-api")
public class BuyerController {

	@Autowired
	BuyerService buyerService;


	@PostMapping("/buyers")
	public void addBuyer(@RequestBody Buyer buyer) {
		buyerService.addBuyer(buyer);
	}

	@GetMapping("/buyers")
	public ResponseEntity<List<Buyer>> getByAll() {
		List<Buyer> buyers = buyerService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc ", "All Investments");
		headers.add("info", "Getting investmentsfrom db");
		System.out.println();
		ResponseEntity<List<Buyer>> responseEntity = new ResponseEntity<>(buyers, headers, HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/buyers")
	public void updateBuyer(@RequestBody Buyer buyer) {
		buyerService.updateBuyer(buyer);
	}

	@DeleteMapping(("/buyers/{buyerId}"))
	public void deleteHomeInsurance(@PathVariable("buyerId") int buyerId) {
		buyerService.deleteBuyerById(buyerId);

	}
	@GetMapping("/buyers/type")
	ResponseEntity< List<Buyer>> getByBuyerPropertyType(@RequestParam ("type") String type)
	{
		List<Buyer>buyres=buyerService.getBuyerByPropertiesType(type);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Buyer details by property type");
		headers.add("info", "buyer rest api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(buyres);
	}
	@GetMapping("/buyers/name/{name}")
	ResponseEntity< List<Buyer>> getByBuyerName(@PathVariable String name)
	{

		List<Buyer>buyer=buyerService.getBuyerByName(name);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Buyer details by name ");
		headers.add("info", "buyer api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(buyer);
	}
	@GetMapping("/buyers/city/{city}")
	ResponseEntity< List<Buyer>> getByBuyerCity(@PathVariable String city)
	{

		List<Buyer>buyer=buyerService.getBuyerByAddressCity(city);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Buyer details by Address city");
		headers.add("info", "buyer api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(buyer);
	}
	
	@GetMapping("/buyers/buyerId/{buyerId}")
	 ResponseEntity<Buyer>  getById(@PathVariable int buyerId)
	{
		Buyer buyer=buyerService.getBuyerById(buyerId);
		HttpHeaders headres=new HttpHeaders();
		headres.add("desc","getting one buyer by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headres).body(buyer);



}
}