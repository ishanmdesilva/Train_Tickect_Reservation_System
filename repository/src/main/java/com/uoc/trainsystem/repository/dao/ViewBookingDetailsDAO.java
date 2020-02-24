package com.uoc.trainsystem.repository.dao;

import java.util.List;

import com.uoc.trainsystem.repository.wrapper.ViewBookingDetailsMappingDTO;

public interface ViewBookingDetailsDAO {

	List<ViewBookingDetailsMappingDTO> viewDetails(Long UserId);
	
}
