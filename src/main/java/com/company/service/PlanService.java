package com.company.service;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.exception.ResourceNotFoundException;
import com.company.model.PlanProduct;
import com.company.repository.PlanProductRepository;

@RestController
@RequestMapping("/productplan")
public class PlanService {

	@Autowired
	PlanProductRepository planProductRepository;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> createPlanProduct(@Valid @RequestBody PlanProduct planProduct) {
		

		// Save the Quote
		PlanProduct rPlanProduct = planProductRepository.save(planProduct);

		// Set the location header for the newly created resource
/*		HttpHeaders responseHeaders = new HttpHeaders();
		URI newQuoteUri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{contractCode}/{productCode}/{planCode}").buildAndExpand(rPlanProduct.getContractCode(),rPlanProduct.getProductCode(),rPlanProduct.getPlanCode());
				.toUri();
		responseHeaders.setLocation(newQuoteUri);
*/
		return new ResponseEntity<>(null,  HttpStatus.CREATED);

	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<PlanProduct>> getAllPlanProducts() {

		List<PlanProduct> planProductList = planProductRepository.findAll();//.findAll(pageable);

		if (planProductList == null || planProductList.size()<= 0) {
			throw new ResourceNotFoundException(
					"No PlanProducts found in the System ");
		}

		return new ResponseEntity<>(planProductList, HttpStatus.OK);
	}


	@RequestMapping(value = "/{contractCode}/{productCode}/{planCode}", method = RequestMethod.GET)
	public ResponseEntity<List<PlanProduct>> getPlanProductsByCriteria(@PathVariable String contractCode,@PathVariable String productCode,@PathVariable String planCode) {
		List<PlanProduct> planProduct = planProductRepository.getProductsByCriteria(contractCode,productCode,planCode);

		if (planProduct == null) {
			throw new ResourceNotFoundException(
					"Plan with provided criteria(contractCode/productCode/planCode) :" + contractCode + "/" + productCode + "/" + planCode +" not found");
		}
		
		//Pass Product/Plan/Contract Codes as required to Plan Service and fetch Plan and Benefit Details
		//Add the response from Plan Service to Quote Object and send the response
		
		
		
		return new ResponseEntity<>(planProduct, HttpStatus.OK);
	}



	

}