package com.uoc.trainsystem.repository.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uoc.trainsystem.repository.dao.SearchTrainDAO;
import com.uoc.trainsystem.repository.wrapper.SearchTrainMapingDTO;
import com.uoc.trainsystem.repository.wrapper.SearchTrainParamDTO;

@Repository
public class SearchTrainDAOImpl implements SearchTrainDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SearchTrainMapingDTO> searchTrain(SearchTrainParamDTO param) {
		StringBuilder nativeQuery = new StringBuilder();
			nativeQuery.append("SELECT ");
			nativeQuery.append("ts.id,");
			nativeQuery.append("t.name AS train_name,");
			nativeQuery.append("t.train_no,");
			nativeQuery.append("tt.name AS t_type,");
			nativeQuery.append("ts.start_time,");
			nativeQuery.append("ts.end_time,");
			nativeQuery.append("t.description ");
			nativeQuery.append("FROM train_status AS ts ");
			nativeQuery.append("INNER JOIN location AS l ON ts.location_id = l.id ");
			nativeQuery.append("INNER JOIN train AS t ON ts.train_id = t.id ");
			nativeQuery.append("INNER JOIN train_type AS tt ON t.train_type_id = tt.id ");
			nativeQuery.append("INNER JOIN station AS ss ON l.start_station_id = ss.id ");
			nativeQuery.append("INNER JOIN station AS es ON l.end_station_id = es.id ");
			nativeQuery.append("WHERE ");
			nativeQuery.append("ss.id = ");
			nativeQuery.append(param.getStartStationId());
			nativeQuery.append(" AND ");
			nativeQuery.append("es.id = ");
			nativeQuery.append(param.getEndStationId());
			nativeQuery.append(" ORDER BY ts.start_time");
			
		Query query = this.entityManager.createNativeQuery(nativeQuery.toString(), "SearchTrainMapping");
		return query.getResultList();
	}

}
