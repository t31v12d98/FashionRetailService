package com.example.fashionrentalservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashionrentalservice.exception.handlers.CrudException;
import com.example.fashionrentalservice.model.dto.account.AccountDTO.AccountStatus;
import com.example.fashionrentalservice.model.request.PORequestEntity;
import com.example.fashionrentalservice.model.request.POUpdateRequestEntity;
import com.example.fashionrentalservice.model.request.POUpdateTokenAndShopIDResquestEntity;
import com.example.fashionrentalservice.service.ProductOwnerService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/po")
public class ProductOwnerController {
	@Autowired
	private ProductOwnerService poService;
	
	
	@GetMapping("/get-all-po")
	private ResponseEntity getAllProductOwner() {
		return ResponseEntity.ok().body(poService.getAllProductOwner());
	}
	
	@PostMapping("/sign-up")
	private ResponseEntity createProductOwner(@RequestBody PORequestEntity entity) throws CrudException {
		return ResponseEntity.ok().body(poService.createProductOwner(entity));
	}
	
	@PutMapping
	private ResponseEntity updateProductOwner(@RequestParam int productownerID,@RequestBody POUpdateRequestEntity entity) throws CrudException {
		return ResponseEntity.ok().body(poService.updateProductOwner(productownerID,entity));
	}
	
	@PutMapping("/updatetoken")
	private ResponseEntity updatePOTokenAndShopID(@RequestParam int productownerID,@RequestBody POUpdateTokenAndShopIDResquestEntity entity) throws CrudException {
		return ResponseEntity.ok().body(poService.updateProductOwnerTokenAndShopID(productownerID,entity));
	}
	
	@PutMapping("/votereputation")
	private ResponseEntity votePOReputation(@RequestParam int productownerID) throws CrudException {		
		return ResponseEntity.ok().body(poService.votePOReputationPoint(productownerID));
	}
	
	@PutMapping("/unvotereputation")
	private ResponseEntity unVotePOReputation(@RequestParam int productownerID) throws CrudException {		
		return ResponseEntity.ok().body(poService.unVotePOReputationPoint(productownerID));
	}
	
	@GetMapping("/{productownerID}")
	private ResponseEntity getProductOwnerByID(@PathVariable int productownerID) throws CrudException {
		return ResponseEntity.ok().body(poService.getPOByID(productownerID));
	}
	
    @DeleteMapping()
    private ResponseEntity deleteExistedProductOwner(@RequestParam int id) throws CrudException {
        return ResponseEntity.ok().body(poService.deleteExistedProductOwner(id));
    }
}
