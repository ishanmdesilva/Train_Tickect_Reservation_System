package com.uoc.trainsystem.core.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageSenderRequest {
	
	private Integer bookingdetailsId;
	private String phoneNumber;

}
