package com.uoc.trainsystem.core.service;

import com.uoc.trainsystem.core.request.UserCreateRequest;
import com.uoc.trainsystem.core.response.UserLoginResponseDTO;

public interface UserCreateService {

	UserLoginResponseDTO create (UserCreateRequest req) throws Exception;
	
}
