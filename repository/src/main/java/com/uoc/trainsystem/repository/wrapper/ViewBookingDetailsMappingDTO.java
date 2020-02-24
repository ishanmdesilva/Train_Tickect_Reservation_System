package com.uoc.trainsystem.repository.wrapper;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(name = "ViewBookingDetails" , entities = {
		@EntityResult(entityClass = ViewBookingDetailsMappingDTO.class , fields = {
				@FieldResult(name = "bookingDetailsId" , column = "id"),
				@FieldResult(name = "trainName" , column = "train_name"),
				@FieldResult(name = "startTime" , column = "start_time"),
				@FieldResult(name = "endTime" , column = "end_time"),
				@FieldResult(name = "startStation" , column = "start_station"),
				@FieldResult(name = "endStation" , column = "end_station"),
				@FieldResult(name = "createdAt" , column = "created_at"),
				@FieldResult(name = "bookDate" , column = "book_date"),
				@FieldResult(name = "numberOfTicket" , column = "number_of_tickets"),
				@FieldResult(name = "totalTicketPrice" , column = "total_ticket_price"),
		}),
})

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ViewBookingDetailsMappingDTO {

	@Id
	private Integer bookingDetailsId;
	private String trainName;
	private String startTime;
	private String endTime;
	private String startStation;
	private String endStation;
	private String createdAt;
	private String bookDate;
	private Integer numberOfTicket;
	private BigDecimal totalTicketPrice;
	
}
