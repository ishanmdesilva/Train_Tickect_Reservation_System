package com.uoc.trainsystem.core.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String password;
	
}
