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
import com.example.fashionrentalservice.model.request.CustomerRequestEntity;
import com.example.fashionrentalservice.model.request.CustomerUpdateRequestEntity;
import com.example.fashionrentalservice.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService cusService;
	
//================================== Lay tat ca Customer ========================================
	@GetMapping("/get-all-customer")
	private ResponseEntity getAllCus() {
		return ResponseEntity.ok().body(cusService.getAllCustomer());
	}
	
 //================================== Đăng kí========================================
	@PostMapping("/sign-up")
	private ResponseEntity createCustomer(@RequestBody CustomerRequestEntity entity) throws CrudException{
		return ResponseEntity.ok().body(cusService.createCustomer(entity));
	}
	
//================================== Update Customer========================================	
	@PutMapping
	private ResponseEntity updateCustomer(@RequestParam int customerID,@RequestBody CustomerUpdateRequestEntity entity) throws CrudException {
		return ResponseEntity.ok().body(cusService.updateCustomer(customerID,entity));
	}

//================================== Lấy Customer bởi ID========================================
	@GetMapping("/{customerID}")
	private ResponseEntity getCustomerByID(@PathVariable int customerID) throws CrudException{
		return ResponseEntity.ok().body(cusService.getCustomerByID(customerID));
	}
	
//================================== Xóa ProductOwner ========================================	
    @DeleteMapping()
    private ResponseEntity deleteExistedCustomer(@RequestParam int id) throws CrudException {
        return ResponseEntity.ok().body(cusService.deleteExistedCustomer(id));
    }
}
