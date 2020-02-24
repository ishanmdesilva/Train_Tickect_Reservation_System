package com.uoc.trainsystem.core.response;

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
public class CreateBookingTicketResponseDTO {

	private Integer bookingdetailsId;
	private Date createdAt;
	private Date bookDate;
	private Long userId;
	private Integer trainStatusId;
	private int numberOfTicket;
	private BigDecimal totalTicketPrice;
	
}
