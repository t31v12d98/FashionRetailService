package com.example.fashionrentalservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
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
import com.example.fashionrentalservice.model.dto.product.ProductDTO.ProductStatus;
import com.example.fashionrentalservice.model.request.ProductRequestEntity;
import com.example.fashionrentalservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
 //================================== Đăng kí========================================
	@PostMapping("/create")
	private ResponseEntity createProduct(@RequestBody ProductRequestEntity entity) throws CrudException{
		return ResponseEntity.ok().body(productService.createProduct(entity));
	}
	
	@GetMapping("/{productID}")
	private ResponseEntity getProductByID(@PathVariable int productID) throws CrudException {
		return ResponseEntity.ok().body(productService.getProductbyID(productID));
	}
	
	@GetMapping("/getall")
	private ResponseEntity getAllProduct() throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProduct());
	}
	@GetMapping("/onsale")
	private ResponseEntity getAllProductOnSale() throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductsOnSale());
	}
	@GetMapping("/onrent")
	private ResponseEntity getAllProductOnRent() throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductsOnRent());
	}
	
	@GetMapping("/onavailable")
	private ResponseEntity getAllProductOnAvailable() throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductsOnAvailable());
	}
	@GetMapping("/onsoldout")
	private ResponseEntity getAllProductOnSoldOut() throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductsOnSoldOut());
	}
	
	@GetMapping("/getallbycategory/{categoryName}")
	private ResponseEntity getAllProductBycategoryName(@PathVariable String categoryName) throws CrudException {
		return ResponseEntity.ok().body(productService.getProductbyCategory(categoryName));
	}
	
	@GetMapping("/getallbybrandname/{brandName}")
	private ResponseEntity getAllProductByBrandName(@PathVariable String brandName) throws CrudException {
		return ResponseEntity.ok().body(productService.getProductBrandName(brandName));
	}
	
	@GetMapping("/getproducts/{productownerID}")
	private ResponseEntity getProductByProductOwnerID(@PathVariable int productownerID) throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductByProductOwnerID(productownerID));
	}
	
	@GetMapping("/getproductsforcus/{productownerID}")
	private ResponseEntity getProductByProductOwnerIDForCus(@PathVariable int productownerID) throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductByProductOwnerIDForCus(productownerID));
	}
	@GetMapping("/getproductsonrent/{productownerID}")
	private ResponseEntity getProductOnRentByProductOwnerIDForCus(@PathVariable int productownerID) throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductOnRentByProductOwnerIDForCus(productownerID));
	}
	
	@GetMapping("/getproductsonsale/{productownerID}")
	private ResponseEntity getProductOnSaleByProductOwnerIDForCus(@PathVariable int productownerID) throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductOnSaleByProductOwnerIDForCus(productownerID));
	}
	
	@GetMapping("/getallbyproductname/{productName}")
	private ResponseEntity getAllProductByProName(@PathVariable String productName) throws CrudException {
		return ResponseEntity.ok().body(productService.getAllProductByProductName(productName));
	}
	
	
//	@GetMapping("/onrllllll")
//	private ResponseEntity getAllBrandNames(@Param(value = "categoryName") String category) throws CrudException {
//		return ResponseEntity.ok().body(productService.getAllBrandName(category));
//	}
	
	
	@PutMapping
	private ResponseEntity updateProduct(@RequestParam int productID) throws CrudException {
		return ResponseEntity.ok().body(productService.updateStatusProductByID(productID));
	}
	
	@PutMapping("/updatebystaff")
	private ResponseEntity updateProductByStaff(@RequestParam int productID, ProductStatus status) throws CrudException {
		return ResponseEntity.ok().body(productService.updateStatusProductByIDStaff(productID, status));
	}
	
	
//================================== Xóa Product ========================================	
    @DeleteMapping
    private ResponseEntity deleteExistedProduct(@RequestParam int id) throws CrudException {
        return ResponseEntity.ok().body(productService.deleteProductbyProductID(id));
    }
}
