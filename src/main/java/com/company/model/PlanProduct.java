package com.company.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PlanProduct {

	
	@Id
	private String planProductId;

	private String planCode;
	private String productCode;
	private String contractCode;
	private String planName;
	private String productName;
	public String getPlanName() {
		return planName;
	}
	public String getPlanProductId() {
		return planProductId;
	}
	public void setPlanProductId(String planProductId) {
		this.planProductId = planProductId;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	
	public List<PlanBenefits> getPlanBenefit() {
		return planBenefit;
	}
	public void setPlanBenefit(List<PlanBenefits> planBenefit) {
		this.planBenefit = planBenefit;
	}

	private List<PlanBenefits> planBenefit;
}
