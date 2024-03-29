package com.example.fashionrentalservice.model.request;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestEntity {

	private String productName;
	
	private String productReceiptUrl;
	
	private String productCondition;

	private String description;
	
	private String term;
	
	private String serialNumber;
	
	private String checkType;

	private double price;
	
	private String productAvt;
	
	private String status;

	private int categoryID;
	
	private int productownerID;
	
	private String productSpecificationData;
	

	
}
