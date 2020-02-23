package com.uoc.trainsystem.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoc.trainsystem.core.request.AppRequest;
import com.uoc.trainsystem.core.request.SearchTrainRequest;
import com.uoc.trainsystem.core.response.AppResponse;
import com.uoc.trainsystem.core.response.SearchTrainResponseDTO;
import com.uoc.trainsystem.core.service.SearchTrainService;

@RequestMapping("/search-train")
@RestController
public class SearchTrainController {

	@Autowired
	private SearchTrainService searchTrainService;
	
	@PostMapping
	public AppResponse<List<SearchTrainResponseDTO>> searchTrain(@Valid @RequestBody AppRequest<SearchTrainRequest> request){
		try {
			List<SearchTrainResponseDTO> response = this.searchTrainService.serch(request.getData());
			return AppResponse.ok(response);
			
		} catch (Exception e) {	
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "not existing train");
			
		}
		
	}
	
}
