package com.uoc.trainsystem.core.service;

import java.util.List;

import com.uoc.trainsystem.core.response.TicketsCategoryResponseDTO;

public interface TicketsCategoryService {

	TicketsCategoryResponseDTO getById(int id) throws Exception;
	List<TicketsCategoryResponseDTO> getALL() throws Exception;
	
}
