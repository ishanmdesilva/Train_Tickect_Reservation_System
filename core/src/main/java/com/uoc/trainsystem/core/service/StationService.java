package com.uoc.trainsystem.core.service;

import java.util.List;

import com.uoc.trainsystem.core.response.StationResponseDTO;

public interface StationService {

	StationResponseDTO getById(int id) throws Exception;
	List<StationResponseDTO> getByAll() throws Exception;
	
	
}
