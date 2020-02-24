package com.uoc.trainsystem.core.request;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingTicketRequest {

	private Long userId;
	private Integer trainStatusId;
	private Integer numberOfTicket;
	private BigDecimal totalTicketPrice;
	private Date bookDate;
	
}
