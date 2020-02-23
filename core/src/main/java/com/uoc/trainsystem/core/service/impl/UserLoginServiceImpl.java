package com.uoc.trainsystem.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.request.UserLoginRequest;
import com.uoc.trainsystem.core.response.UserLoginResponseDTO;
import com.uoc.trainsystem.core.service.UserLoginService;
import com.uoc.trainsystem.repository.dao.UserLoginDAO;
import com.uoc.trainsystem.repository.wrapper.UserLoginMappingDTO;
import com.uoc.trainsystem.repository.wrapper.UserLoginParamDTO;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginDAO userLoginDAO;
	
	@MethodLogging
	@Override
	public UserLoginResponseDTO login(UserLoginRequest req)  throws Exception {
		return buildresponseDTO(this.userLoginDAO.viewUserLogin(buidRequest(req)));
	}
	
	private UserLoginResponseDTO buildresponseDTO(UserLoginMappingDTO res) {
	  return UserLoginResponseDTO.builder() 
			  .userId(res.getId())
			  .firstName(res.getFirstName()) 
			  .lastName(res.getLastName())
			  .phoneNumnber(res.getPhoneNumber())
			  .email(res.getEmail())
			  .build();  
	}
	
	private UserLoginParamDTO buidRequest(UserLoginRequest req) {
		return UserLoginParamDTO.builder()
				.email(req.getEmail())
				.password(req.getPassword())
				.build();
	}
	 
}
