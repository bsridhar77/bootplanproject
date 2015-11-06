package com.company.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.company.model.PlanProduct;

public interface PlanProductRepository extends MongoRepository<PlanProduct, String> {

	
	
	@Query("{ 'contractCode' : ?0 ,'productCode' : ?1,'planCode':?2}")
	List<PlanProduct> getProductsByCriteria(String contractCode,String productCode,String planCode);
	
}
