package com.example.fashionrentalservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashionrentalservice.exception.handlers.CrudException;
import com.example.fashionrentalservice.model.dto.account.AccountDTO;
import com.example.fashionrentalservice.model.dto.account.CustomerDTO;
import com.example.fashionrentalservice.model.dto.product.FavoriteProductDTO;
import com.example.fashionrentalservice.model.dto.product.FeedBackDTO;
import com.example.fashionrentalservice.model.dto.product.ProductDTO;
import com.example.fashionrentalservice.model.dto.product.FavoriteProductDTO.FavoriteStatus;
import com.example.fashionrentalservice.model.request.FavoriteProductRequestEntity;
import com.example.fashionrentalservice.model.request.FeedBackRequestEntity;
import com.example.fashionrentalservice.model.response.AccountResponseEntity;
import com.example.fashionrentalservice.model.response.FavoriteProductResponseEntity;
import com.example.fashionrentalservice.model.response.FeedBackResponseEntity;
import com.example.fashionrentalservice.repositories.CustomerRepository;

import com.example.fashionrentalservice.repositories.FeedBackRepository;
import com.example.fashionrentalservice.repositories.ProductRepository;
import com.example.fashionrentalservice.exception.PendingMoneyNegative;



@Service
public class FeedBackService {
	@Autowired
	private FeedBackRepository fbRepo;
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CustomerRepository cusRepo;
	
	@Autowired
	private FeedBackImgService fbImgService;
	
	public List<FeedBackResponseEntity> getFeedBackByProductID(int productID) throws  CrudException {
		List<FeedBackDTO> dto = fbRepo.findFeedBackByProductID(productID);
		
		if(dto==null) {
			throw new PendingMoneyNegative("Can't find CustomerID to add Favorite");
		}	
		return FeedBackResponseEntity.fromListFeedBackDTO(dto);
	}
	

	public FeedBackResponseEntity createFeedBackProduct(FeedBackRequestEntity entity) throws CrudException {
		CustomerDTO cusCheck=cusRepo.findById(entity.getCustomerID()).orElse(null);
		ProductDTO productCheck=productRepo.findById(entity.getProductID()).orElse(null);
		if(cusCheck==null) {
		throw new PendingMoneyNegative("Can't find CustomerID to create FeedBack");
	}else if(productCheck==null) {
			throw new PendingMoneyNegative("Can't find CustomerID to add Favorite");
		}
		FeedBackDTO checked= fbRepo.findFeedBackByCustomerAndProductID(entity.getCustomerID(), entity.getProductID());
		if(checked!=null) {
			throw new PendingMoneyNegative("This customer already feedback this product");
		}
		int checkRating =entity.getRatingPoint();
		if(checkRating>5 ||checkRating<0) {
			throw new PendingMoneyNegative("This rating must be smaller than 5 and greater than 0");
		}
		FeedBackDTO dto = FeedBackDTO.builder()
				.createdtDate(LocalDate.now())
				.customerDTO(cusRepo.findById(entity.getCustomerID()).orElse(null))
				.productDTO(productRepo.findById(entity.getProductID()).orElse(null))
				.description(entity.getDescription())
				.ratingPoint(checkRating)
				.build();
		 return FeedBackResponseEntity.fromFeedBackDTO(fbRepo.save(dto));
	}
	 public FeedBackResponseEntity deleteExistedFeedBack(int id) {
	        FeedBackDTO dto = fbRepo.findById(id).orElse(null);
	        fbRepo.deleteById(id);

	        return FeedBackResponseEntity.fromFeedBackDTO(dto);
	    }
	
}
