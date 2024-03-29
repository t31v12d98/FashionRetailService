package com.example.fashionrentalservice.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fashionrentalservice.exception.PendingMoneyNegative;
import com.example.fashionrentalservice.exception.handlers.CrudException;
import com.example.fashionrentalservice.model.dto.product.RequestComplainingOrderDTO;
import com.example.fashionrentalservice.model.dto.product.StaffRequestedDTO;
import com.example.fashionrentalservice.model.response.StaffRequestedResponseEntity;
import com.example.fashionrentalservice.repositories.RequestAddingProductRepository;
import com.example.fashionrentalservice.repositories.RequestComplainingOrderRepository;
import com.example.fashionrentalservice.repositories.StaffRepository;
import com.example.fashionrentalservice.repositories.StaffRequestedRepository;
@Service
public class StaffRequestedService {
	@Autowired
	private StaffRequestedRepository staffRequestedRepo;
	
	@Autowired
	private RequestAddingProductRepository addRequestedRepo;
	
	@Autowired
	private RequestComplainingOrderRepository requestComRepo;
	
	@Autowired
	private StaffRepository staffRepository;
	
	
	//================================== Lay tat ca yêu cầu mà Staff đã duyệt ========================================
	public List<StaffRequestedDTO> getAllStaffRequested() {
		List<StaffRequestedDTO> list = staffRequestedRepo.findAll();
		return  list;
		
	}
	//================================== Tao Request========================================
    public StaffRequestedDTO create(int requestAddingProductID, int staffID) {
    	StaffRequestedDTO dto = StaffRequestedDTO.builder()
    			.createdDate(LocalDate.now())
    			.requestAddingProductDTO(addRequestedRepo.findById(requestAddingProductID).orElseThrow())
    			.staffDTO(staffRepository.findById(staffID).orElseThrow())
                .build();
        return staffRequestedRepo.save(dto);

}
    
    public StaffRequestedDTO createComplaining(int requestComplainingOrderID, int staffID) throws CrudException {
    	RequestComplainingOrderDTO check = requestComRepo.findById(requestComplainingOrderID).orElse(null);
    	if(check == null)
    		throw new PendingMoneyNegative("Request Complaining Not Found!");
    	StaffRequestedDTO dto = StaffRequestedDTO.builder()
    			.createdDate(LocalDate.now())
    			.requestComplainingOrderDTO(check)
    			.staffDTO(staffRepository.findById(staffID).orElseThrow())
                .build();
        return staffRequestedRepo.save(dto);

}
    

	public List<StaffRequestedResponseEntity> getAllApprovedStaffRequestedByStaffID(int staffID) {
		List<StaffRequestedDTO> list = staffRequestedRepo.findAllApprovedRequestedByStaffID(staffID);
		return  StaffRequestedResponseEntity.fromStaffRequestedDTO(list);
	}
	public List<StaffRequestedResponseEntity> getAllNotApprovedStaffRequestedByStaffID(int staffID) {
		List<StaffRequestedDTO> list = staffRequestedRepo.findAllNotApprovedRequestedByStaffID(staffID);
	    return  StaffRequestedResponseEntity.fromStaffRequestedDTO(list);
	}
	
}
