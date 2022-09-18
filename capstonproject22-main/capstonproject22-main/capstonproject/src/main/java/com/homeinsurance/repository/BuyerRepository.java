package com.homeinsurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.homeinsurance.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
	   //Derived Query
		public List<Buyer> findByName(String name);
		public List<Buyer> findByInsurancesName(String name);
	    
	    @Query("from Buyer b inner join b.address a where a.city=?1 ")
		public List<Buyer> findByAddressCity(String city);
		public List<Buyer> findByPropertiesType(String type);
		@Query(value="select * from buyer b inner join home_insurance h on b.insurance_id=h.insurance_id inner join property p on p.buyer_id=b.buyer_id and h.name=?1 and p.type=?2",nativeQuery = true)
	    public List<Buyer>findByNameProperytype(String insuranceName, String type);
     
}