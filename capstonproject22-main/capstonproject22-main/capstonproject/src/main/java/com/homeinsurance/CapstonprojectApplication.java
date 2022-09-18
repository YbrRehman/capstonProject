package com.homeinsurance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.homeinsurance.model.Address;
import com.homeinsurance.model.Buyer;
import com.homeinsurance.model.HomeInsurance;
import com.homeinsurance.model.Property;
import com.homeinsurance.model.Vendor;
import com.homeinsurance.repository.HomeInsuranceRepository;
import com.homeinsurance.service.BuyerService;
import com.homeinsurance.service.HomeInsuranceService;

@SpringBootApplication
public class CapstonprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CapstonprojectApplication.class, args);
	}

	@Autowired
	BuyerService buyerService;
	@Autowired
	HomeInsuranceService homeInsuranceService;

	@Override
	public void run(String... args) throws Exception {

		Address addressForBuyer1 = new Address("Tumkur", "Karnataka", 560076);
		Address addressForBuyer2 = new Address("vikarabad", "Karnataka", 560075);
		Address addresForVendor = new Address("Husumanahalli", "Karnataka", 560077);
		Property property1 = new Property("Bulding", "Residential", 21000000, 3000);
		Property property2 = new Property("FarmHouse", "Industrial", 75000000, 50000);

		// Property property3=new Property("Building","Residential",25000000,1500);
		 Set<Property> propertyListforBuyer1 = new HashSet<>(Arrays.asList(property1));
		 Set<Property> propertyListforbyuer2 = new HashSet<>(Arrays.asList(property2));

	//	Vendor vendor1 = new Vendor("VFISLK", addresForVendor);

		//HomeInsurance homeInsurance2 = new HomeInsurance("USAA", 800000, "Fire,Earthquake,Flood", 4, 70000, vendor1);
	
		//homeInsuranceService.addInsurance(homeInsurance2);

		//Buyer buyer1 = new Buyer("MahaLaxmi", 956565865, addressForBuyer1, "owner", "Manager",
				//homeInsuranceService.getByInsuranceId(999),propertyListforBuyer1);
	//	Buyer buyer2 = new Buyer("nagsss", 345678567, addressForBuyer2, "rent", "Software trainee",
				//homeInsuranceService.getByInsuranceId(999),propertyListforbyuer2);
		//buyerService.addBuyer(buyer2);
		 //buyerService.addBuyer(buyer1);

		System.out.println("#####################");
		// homeInsuranceService.getInsuranceByCostOfConstruction(1000000,
		// 200).forEach(System.out::println);
		 homeInsuranceService.getAll().forEach(System.out::println);

		// System.out.println("#####################");

	}

}
