package com.uoc.trainsystem.repository.dao;

import javax.persistence.NoResultException;

import com.uoc.trainsystem.repository.wrapper.SearchTrainMapingDTO;

public interface GetTrainStatusDAO {
	SearchTrainMapingDTO getTrainStatus(Integer id) throws NoResultException;
}
