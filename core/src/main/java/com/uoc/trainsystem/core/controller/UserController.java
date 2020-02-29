package com.uoc.trainsystem.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoc.trainsystem.core.request.AppRequest;
import com.uoc.trainsystem.core.request.UserCreateRequest;
import com.uoc.trainsystem.core.request.UserLoginRequest;
import com.uoc.trainsystem.core.request.UserUpdateRequest;
import com.uoc.trainsystem.core.response.AppResponse;
import com.uoc.trainsystem.core.response.UserLoginResponseDTO;
import com.uoc.trainsystem.core.service.UserCreateService;
import com.uoc.trainsystem.core.service.UserLoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private UserCreateService userCreateService;
	
	@PostMapping("/login")
	public AppResponse<UserLoginResponseDTO> userLogin(@RequestBody AppRequest<UserLoginRequest> req) {
		try {
			UserLoginResponseDTO response = this.userLoginService.login(req.getData());
			return AppResponse.ok(response);
			
		} catch (Exception e) {
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "userName or password invalid");
		}
	}
	
	@PostMapping("/create")
	public AppResponse<UserLoginResponseDTO> userCraete(@RequestBody AppRequest<UserCreateRequest> req){
		try {
			UserLoginResponseDTO response = this.userCreateService.create(req.getData());
			return AppResponse.ok(response);
			
		} catch (Exception e) {
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "user create fail");
		}
	}
	
	@PostMapping("/update")
	public AppResponse<UserLoginResponseDTO> userUpdate(@RequestBody AppRequest<UserUpdateRequest> req){
		try {
			UserLoginResponseDTO response = this.userCreateService.update(req.getData());
			return AppResponse.ok(response);
			
		} catch (Exception e) {
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "user create fail");
		}
	}
	
	@ApiOperation("get by user id")
	@GetMapping("/{id}")
	public AppResponse<UserLoginResponseDTO> get(@Valid @PathVariable Long id){
		try {
			UserLoginResponseDTO response = this.userLoginService.get(id);
			return AppResponse.ok(response);
			
		} catch (Exception e) {
			return AppResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getStackTrace()[0].getClassName(), 
					e.getStackTrace()[0].getMethodName(), "get user details fail");
		}
	}
	
}
