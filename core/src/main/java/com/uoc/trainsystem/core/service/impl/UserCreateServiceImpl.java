package com.uoc.trainsystem.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.request.UserCreateRequest;
import com.uoc.trainsystem.core.request.UserUpdateRequest;
import com.uoc.trainsystem.core.response.UserLoginResponseDTO;
import com.uoc.trainsystem.core.service.UserCreateService;
import com.uoc.trainsystem.repository.UserRepository;
import com.uoc.trainsystem.repository.entities.User;

@Service
public class UserCreateServiceImpl implements UserCreateService {

	@Autowired
	private UserRepository userRepository;
	
	@MethodLogging
	@Override
	public UserLoginResponseDTO create(UserCreateRequest req) throws Exception {
		User entity = new User();
			entity.setFristName(req.getFirstName());
			entity.setLastName(req.getLastName());
			entity.setPhoneNumber("+94"+req.getPhoneNumnber());
			entity.setEmail(req.getEmail());
			entity.setPassword(req.getPassword());
		return buildResponse(this.userRepository.save(entity));
	}
	
	@MethodLogging
	@Override
	public UserLoginResponseDTO update(UserUpdateRequest req) throws Exception {
		
		Optional<User> optUser = this.userRepository.findById(req.getUserId());
		if(optUser.isPresent()) {
			User updateuser = optUser.get();
				updateuser.setFristName(req.getFirstName());
				updateuser.setPhoneNumber("+94"+req.getPhoneNumnber());
			return buildResponse(this.userRepository.save(updateuser));	
		}
		throw new Exception();
	}
	
	private UserLoginResponseDTO buildResponse(User user) {
		return UserLoginResponseDTO.builder()
			.userId(user.getId())
			.firstName(user.getFristName())
			.lastName(user.getLastName())
			.email(user.getEmail())
			.phoneNumnber(user.getPhoneNumber())
			.build();
	}

}
