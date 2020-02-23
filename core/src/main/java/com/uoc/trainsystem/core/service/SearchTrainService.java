package com.uoc.trainsystem.core.service;

import java.util.List;

import com.uoc.trainsystem.core.request.SearchTrainRequest;
import com.uoc.trainsystem.core.response.SearchTrainResponseDTO;

public interface SearchTrainService {

	List<SearchTrainResponseDTO> serch(SearchTrainRequest req) throws Exception;
	
}
