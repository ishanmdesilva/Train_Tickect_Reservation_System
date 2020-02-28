package com.uoc.trainsystem.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoc.trainsystem.core.response.AppResponse;
import com.uoc.trainsystem.core.response.SearchTrainResponseDTO;
import com.uoc.trainsystem.core.service.SearchTrainService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/train-status")
public class TrainStatusController {
	
	@Autowired
	private SearchTrainService searchTrainService;
	
	@ApiOperation("get by train status id")
	@GetMapping("/{id}")
	public AppResponse<SearchTrainResponseDTO> get (@Valid @PathVariable Integer id){
		try {
			SearchTrainResponseDTO response = this.searchTrainService.viewTrainStatus(id);
			return AppResponse.ok(response);
			
		} catch (Exception e) {	
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "get train status fail");
		
		}
		
	}

}
