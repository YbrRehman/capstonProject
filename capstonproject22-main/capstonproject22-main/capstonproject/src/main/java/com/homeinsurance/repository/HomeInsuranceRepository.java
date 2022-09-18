package com.homeinsurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.homeinsurance.model.HomeInsurance;

@Repository
public interface HomeInsuranceRepository extends JpaRepository<HomeInsurance, Integer> {
	// derived Query
	public List<HomeInsurance> findByVendorName(String name);
	// Custom Query
	@Query("from HomeInsurance h where h.premium>=?1")
	public List<HomeInsurance> findByCostOfConstruction(double costSquareFeet);
     
    @Query(value="select * from home_insurance h inner join buyer b on b.insurance_id=h.insurance_id inner join property p on p.buyer_id=b.buyer_id and b.name=?1 and p.type=?2",nativeQuery = true)
    public List<HomeInsurance>findByNameAndPropertyType(String name,String type);

}
