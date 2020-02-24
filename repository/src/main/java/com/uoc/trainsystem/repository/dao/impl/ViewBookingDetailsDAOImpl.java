package com.uoc.trainsystem.repository.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uoc.trainsystem.repository.dao.ViewBookingDetailsDAO;
import com.uoc.trainsystem.repository.wrapper.ViewBookingDetailsMappingDTO;

@Repository
public class ViewBookingDetailsDAOImpl implements ViewBookingDetailsDAO {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ViewBookingDetailsMappingDTO> viewDetails(Long userId) {
		StringBuilder nativeQuery = new StringBuilder();
			nativeQuery.append("SELECT ");
			nativeQuery.append("bd.id,");
			nativeQuery.append("t.name AS train_name,");
			nativeQuery.append("ts.start_time,");
			nativeQuery.append("ts.end_time,");
			nativeQuery.append("ss.name AS start_station,");
			nativeQuery.append("se.name AS end_station,");
			nativeQuery.append("bd.created_at,");
			nativeQuery.append("bd.book_date,");
			nativeQuery.append("bd.number_of_tickets,");
			nativeQuery.append("bd.total_ticket_price ");
			nativeQuery.append("FROM booking_details AS bd ");
			nativeQuery.append("INNER JOIN user AS u ON bd.user_id = u.id ");
			nativeQuery.append("INNER JOIN train_status AS ts ON bd.train_status_id = ts.id ");
			nativeQuery.append("INNER JOIN train AS t ON ts.train_id = t.id ");
			nativeQuery.append("INNER JOIN location AS l ON ts.location_id = l.id ");
			nativeQuery.append("INNER JOIN station AS ss ON l.start_station_id = ss.id ");
			nativeQuery.append("INNER JOIN station AS se ON l.end_station_id = se.id ");
			nativeQuery.append("WHERE u.id = ");
			nativeQuery.append(userId);
			nativeQuery.append(" ORDER BY bd.created_at DESC");
		
		Query query = this.entityManager.createNativeQuery(nativeQuery.toString(), "ViewBookingDetails");
		return query.getResultList();
	}

}
