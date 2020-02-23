package com.uoc.trainsystem.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.request.SearchTrainRequest;
import com.uoc.trainsystem.core.response.SearchTrainResponseDTO;
import com.uoc.trainsystem.core.service.SearchTrainService;
import com.uoc.trainsystem.repository.dao.SearchTrainDAO;
import com.uoc.trainsystem.repository.wrapper.SearchTrainMapingDTO;
import com.uoc.trainsystem.repository.wrapper.SearchTrainParamDTO;

@Service
public class SearchTrainServiceImpl implements SearchTrainService {

	@Autowired
	private SearchTrainDAO searchTrainDAO;
	
	@MethodLogging
	@Override
	public List<SearchTrainResponseDTO> serch(SearchTrainRequest req) throws Exception {
		List<SearchTrainMapingDTO> resList = this.searchTrainDAO.searchTrain(buidRequest(req));
		List<SearchTrainResponseDTO> newList = new ArrayList<>();
		resList.forEach(item -> newList.add(buildResponse(item)));
		return newList;
	}
	
	private SearchTrainResponseDTO buildResponse(SearchTrainMapingDTO res){
		return SearchTrainResponseDTO.builder()
			.id(res.getId())
			.trainName(res.getTrainName())
			.trainNo(res.getTrainNo())
			.trainType(res.getTrainType())
			.startTime(res.getStartTime())
			.endTime(res.getEndTime())
			.description(res.getDescription())
			.build();
	}
	
	private SearchTrainParamDTO buidRequest(SearchTrainRequest param) {
		return SearchTrainParamDTO.builder()
			.startStationId(param.getStartStationId())
			.endStationId(param.getEndStationId())
			.build();
	}

}
