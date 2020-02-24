package com.uoc.trainsystem.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.request.CreateBookingTicketRequest;
import com.uoc.trainsystem.core.response.CreateBookingTicketResponseDTO;
import com.uoc.trainsystem.core.service.BookingTicketService;
import com.uoc.trainsystem.repository.BookingDetailsRepository;
import com.uoc.trainsystem.repository.TrainStatusRepository;
import com.uoc.trainsystem.repository.UserRepository;
import com.uoc.trainsystem.repository.entities.BookingDetails;
import com.uoc.trainsystem.repository.entities.TrainStatus;
import com.uoc.trainsystem.repository.entities.User;

@Service
public class BookingTicketServiceImpl implements BookingTicketService {

	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;
	@Autowired
	private TrainStatusRepository trainStatusRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	@MethodLogging
	@Override
	public CreateBookingTicketResponseDTO createBookingDetails(CreateBookingTicketRequest req) throws Exception {
		User user = this.userRepository.findById(req.getUserId()).orElseThrow(() -> new Exception("get user fail.."));
		TrainStatus trainStatus = this.trainStatusRepository.findById(req.getTrainStatusId()).orElseThrow(() -> new Exception("get train status fail.."));
		BookingDetails entity = new BookingDetails();
			entity.setBookDate(req.getBookDate());
			entity.setUserId(user);
			entity.setTrainStatusId(trainStatus);
			entity.setNumberOfTickets(req.getNumberOfTicket());
			entity.setTotalTicketPrice(req.getTotalTicketPrice());
			
		return buildresponse(this.bookingDetailsRepository.save(entity));
	}
	
	private CreateBookingTicketResponseDTO buildresponse(BookingDetails ob) {
		return CreateBookingTicketResponseDTO.builder()
			.bookingdetailsId(ob.getId())
			.createdAt(ob.getCreatedAt())
			.bookDate(ob.getBookDate())
			.userId(ob.getUserId().getId())
			.trainStatusId(ob.getTrainStatusId().getId())
			.numberOfTicket(ob.getNumberOfTickets())
			.totalTicketPrice(ob.getTotalTicketPrice())
			.build();
	}

}
