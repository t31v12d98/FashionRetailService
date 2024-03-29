package com.example.fashionrentalservice.model.dto.order;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.example.fashionrentalservice.model.dto.account.CustomerDTO;
import com.example.fashionrentalservice.model.dto.account.ProductOwnerDTO;
import com.example.fashionrentalservice.model.dto.product.VoucherDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_orderbuy")
public class OrderBuyDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderbuy_id", columnDefinition = "INT")
	private int orderBuyID;
	
	private double totalBuyPriceProduct;
	
	private double shippingfee;

	private double total;
	
	private String customerAddress;
	
	private LocalDateTime dateOrder;
	
	
	@Nullable
	private String orderCode;
	
	@Enumerated(EnumType.STRING)
	private OrderBuyStatus status;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
	private CustomerDTO customerDTO;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "productowner_id")
	@JsonIgnoreProperties(value = { "applications", "hibernateLazyInitializer" })
	private ProductOwnerDTO productownerDTO;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "voucher_id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private VoucherDTO voucherDTO;
	
	public enum OrderBuyStatus {
		PENDING, PREPARE, DELIVERY, CONFIRMING, REJECTING, REJECTING_COMPLETED, CANCELED, COMPLETED
	}
}
