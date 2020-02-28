package com.uoc.trainsystem.repository.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uoc.trainsystem.repository.dao.GetTrainStatusDAO;
import com.uoc.trainsystem.repository.wrapper.SearchTrainMapingDTO;

@Repository
public class GetTrainStatusDAOImpl implements GetTrainStatusDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public SearchTrainMapingDTO getTrainStatus(Integer id) throws NoResultException {
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
			nativeQuery.append("WHERE ts.id = ");
			nativeQuery.append(id);
			
			Query query = this.entityManager.createNativeQuery(nativeQuery.toString(), "SearchTrainMapping");
			return (SearchTrainMapingDTO) query.getSingleResult();
	}

}
