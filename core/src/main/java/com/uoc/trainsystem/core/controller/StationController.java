package com.uoc.trainsystem.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inova.applogger.util.AllowLogging;
import com.uoc.trainsystem.core.response.AppResponse;
import com.uoc.trainsystem.core.response.StationResponseDTO;
import com.uoc.trainsystem.core.service.StationService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/station")
public class StationController {
								
	@Autowired
	private StationService stationService;
	
	@AllowLogging
	@GetMapping("/{id}")
	public AppResponse<StationResponseDTO> getStationById(
			@ApiParam(required = true , name = "id") @PathVariable int id){
		try {
			StationResponseDTO response = this.stationService.getById(id);
			return AppResponse.ok(response);
			
		} catch (Exception e) {	
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "not existing value");
			
		}	
	}
	
	@AllowLogging
	@GetMapping("/all")
	public AppResponse<List<StationResponseDTO>> getStationAll(){
		try {
			List<StationResponseDTO> byAll = this.stationService.getByAll();
			return AppResponse.ok(byAll);
		} catch (Exception e) {
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "get all station fails");
		}
	}
}
