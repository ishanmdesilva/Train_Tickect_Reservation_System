package com.uoc.trainsystem.repository.dao;

import java.util.List;

import com.uoc.trainsystem.repository.wrapper.SearchTrainMapingDTO;
import com.uoc.trainsystem.repository.wrapper.SearchTrainParamDTO;

public interface SearchTrainDAO {

	List<SearchTrainMapingDTO> searchTrain(SearchTrainParamDTO param);
	
}
