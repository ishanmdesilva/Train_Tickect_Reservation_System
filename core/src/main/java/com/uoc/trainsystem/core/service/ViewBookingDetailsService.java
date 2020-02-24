package com.uoc.trainsystem.core.service;

import java.util.List;

import com.uoc.trainsystem.repository.wrapper.ViewBookingDetailsMappingDTO;

public interface ViewBookingDetailsService {

	List<ViewBookingDetailsMappingDTO> getDetails(Long userId) throws Exception;
	
}
