package com.uoc.trainsystem.core.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

	private Long userId;
	private String firstName;
	private String lastName;
	private String phoneNumnber;
	
}
