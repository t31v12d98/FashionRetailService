package com.example.fashionrentalservice.model.response;

import com.example.fashionrentalservice.model.dto.account.AccountDTO;
import com.example.fashionrentalservice.model.dto.account.CustomerDTO;
import com.example.fashionrentalservice.model.dto.account.ProductOwnerDTO;
import com.example.fashionrentalservice.model.dto.account.RoleDTO;
import com.example.fashionrentalservice.model.dto.account.StaffDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseEntity {
	
	@JsonProperty("accountID")
	private int accountID;

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("role")
	private RoleDTO roleDTO;
	
	@JsonProperty("customer")
	private CustomerDTO customerDTO;
	
	@JsonProperty("productowner")
	private ProductOwnerDTO productOwnerDTO;
	
	@JsonProperty("staff")
	private StaffDTO staffDTO;
	
	

	public static AccountResponseEntity fromAccountDto(AccountDTO dto) {
        return AccountResponseEntity.builder()
                .accountID(dto.getAccountID())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .status(dto.getStatus().toString())
                .roleDTO(dto.getRoleDTO())
                .customerDTO(dto.getCustomerDTO())
                .productOwnerDTO(dto.getProductOwnerDTO())
                .staffDTO(dto.getStaffDTO())
                .build();   
	}
}
