package com.uoc.trainsystem.repository.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uoc.trainsystem.repository.dao.DisplayTicketPriceDAO;
import com.uoc.trainsystem.repository.wrapper.DisplayTicketPriceMappingDTO;
import com.uoc.trainsystem.repository.wrapper.DisplayTicketPriceParamDTO;

@Repository
public class DisplayTicketPriceDAOImpl implements DisplayTicketPriceDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public DisplayTicketPriceMappingDTO displayPrice(DisplayTicketPriceParamDTO param) {
		StringBuilder nativeQuery = new StringBuilder();
			nativeQuery.append("SELECT ");
			nativeQuery.append("tp.id,");
			nativeQuery.append("tp.price ");
			nativeQuery.append("FROM ticket_price AS tp ");
			nativeQuery.append("INNER JOIN tickets_category AS tc ON tp.tickets_category_id = tc.id ");
			nativeQuery.append("INNER JOIN location AS l ON tp.location_id = l.id ");
			nativeQuery.append("INNER JOIN station AS ss ON l.start_station_id = ss.id ");
			nativeQuery.append("INNER JOIN station AS es ON l.end_station_id = es.id ");
			nativeQuery.append("WHERE ");
			nativeQuery.append("ss.id = ");
			nativeQuery.append(param.getStartStationId());
			nativeQuery.append(" AND ");
			nativeQuery.append("es.id = ");
			nativeQuery.append(param.getEndStationId());
			nativeQuery.append(" AND ");
			nativeQuery.append("tc.id = ");
			nativeQuery.append(param.getTicketCategoryId());
			
		Query query = this.entityManager.createNativeQuery(nativeQuery.toString(), "DisplayTicketPrice");	
		return (DisplayTicketPriceMappingDTO) query.getSingleResult();
	}
	
}
