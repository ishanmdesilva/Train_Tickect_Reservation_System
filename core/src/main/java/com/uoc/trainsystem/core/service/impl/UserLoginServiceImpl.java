package com.uoc.trainsystem.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.request.UserLoginRequest;
import com.uoc.trainsystem.core.response.UserLoginResponseDTO;
import com.uoc.trainsystem.core.service.UserLoginService;
import com.uoc.trainsystem.repository.UserRepository;
import com.uoc.trainsystem.repository.dao.UserLoginDAO;
import com.uoc.trainsystem.repository.entities.User;
import com.uoc.trainsystem.repository.wrapper.UserLoginMappingDTO;
import com.uoc.trainsystem.repository.wrapper.UserLoginParamDTO;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginDAO userLoginDAO;
	@Autowired
	private UserRepository userRepository;
	
	@MethodLogging
	@Override
	public UserLoginResponseDTO login(UserLoginRequest req)  throws Exception {
		return buildresponseDTO(this.userLoginDAO.viewUserLogin(buidRequest(req)));
	}
	
	@MethodLogging
	@Override
	public UserLoginResponseDTO get(Long id) throws Exception {
		Optional<User> optUser = this.userRepository.findById(id);
		if(optUser.isPresent()) {
			return buildEntityResposne(optUser.get());
		}
	    throw new Exception();
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
	
	private UserLoginResponseDTO buildEntityResposne(User user) {
		return UserLoginResponseDTO.builder()
			.userId(user.getId())
			.firstName(user.getFristName())
			.lastName(user.getLastName())
			.email(user.getEmail())
			.phoneNumnber(user.getPhoneNumber())
			.build();
	}
	 
}
