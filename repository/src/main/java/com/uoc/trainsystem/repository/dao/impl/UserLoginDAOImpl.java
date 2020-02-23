package com.uoc.trainsystem.repository.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uoc.trainsystem.repository.dao.UserLoginDAO;
import com.uoc.trainsystem.repository.wrapper.UserLoginMappingDTO;
import com.uoc.trainsystem.repository.wrapper.UserLoginParamDTO;

@Repository
public class UserLoginDAOImpl implements UserLoginDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserLoginMappingDTO viewUserLogin(UserLoginParamDTO param) {
		StringBuilder nativeQuesry = new StringBuilder();
			nativeQuesry.append("SELECT ");
			nativeQuesry.append("u.id,");
			nativeQuesry.append("u.frist_name,");
			nativeQuesry.append("u.last_name,");
			nativeQuesry.append("u.phone_number,");
			nativeQuesry.append("u.email ");
			nativeQuesry.append("FROM user AS u ");
			nativeQuesry.append("WHERE u.email = '");
			nativeQuesry.append(param.getEmail());
			nativeQuesry.append("' AND u.password = '");
			nativeQuesry.append(param.getPassword());
			nativeQuesry.append("'");
			
		Query query = this.entityManager.createNativeQuery(nativeQuesry.toString(), "UserLoginDetails");	
		return (UserLoginMappingDTO) query.getSingleResult();
	}

}
