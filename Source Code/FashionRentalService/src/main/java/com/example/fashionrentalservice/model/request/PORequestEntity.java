package com.example.fashionrentalservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PORequestEntity {
	private String fullName;

	private String phone;

	private String avatarUrl;

	private String address;
	
    private String POToken;
	
	private int POShopID;
	
	private int accountID;
}
