package com.uoc.trainsystem.core.service;

import com.uoc.trainsystem.core.request.CreateBookingTicketRequest;
import com.uoc.trainsystem.core.response.CreateBookingTicketResponseDTO;

public interface BookingTicketService {

	CreateBookingTicketResponseDTO createBookingDetails(CreateBookingTicketRequest req) throws Exception;
	
}
