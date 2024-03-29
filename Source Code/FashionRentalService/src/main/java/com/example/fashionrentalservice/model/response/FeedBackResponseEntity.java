package com.example.fashionrentalservice.model.response;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.example.fashionrentalservice.model.dto.account.CustomerDTO;
import com.example.fashionrentalservice.model.dto.product.FavoriteProductDTO;
import com.example.fashionrentalservice.model.dto.product.FeedBackDTO;
import com.example.fashionrentalservice.model.dto.product.FeedBackImgDTO;
import com.example.fashionrentalservice.model.dto.product.ProductDTO;
import com.example.fashionrentalservice.model.request.FeedBackRequestEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedBackResponseEntity {
	
	private int feedBackID;
	private int productID;
	private CustomerDTO customerDTO;
	private int ratingPoint;
	private String description;
	private LocalDate createdtDate;
	private List<FeedBackImgDTO> imgDTOs;
	
	public static FeedBackResponseEntity fromFeedBackDTO(FeedBackDTO dto) {
		return  FeedBackResponseEntity.builder()
				.feedBackID(dto.getFeedbackID())	
				.productID(dto.getProductDTO().getProductID())
				.customerDTO(dto.getCustomerDTO())
				.description(dto.getDescription())
				.createdtDate(dto.getCreatedtDate())
				.ratingPoint(dto.getRatingPoint())
				.imgDTOs(dto.getFeedBackImgDTOs())
				.build();
	}
	
	public static List<FeedBackResponseEntity> fromListFeedBackDTO(List<FeedBackDTO> dtos){
		return dtos.stream()
	            .map(dto -> FeedBackResponseEntity.builder()
	            		.feedBackID(dto.getFeedbackID())
	            		.productID(dto.getProductDTO().getProductID())
	            		.customerDTO(dto.getCustomerDTO())
	    				.description(dto.getDescription())
	    				.createdtDate(dto.getCreatedtDate())
	    				.ratingPoint(dto.getRatingPoint())
	    				.imgDTOs(dto.getFeedBackImgDTOs())
						.build())
	            .collect(Collectors.toList());
	}
	
}
