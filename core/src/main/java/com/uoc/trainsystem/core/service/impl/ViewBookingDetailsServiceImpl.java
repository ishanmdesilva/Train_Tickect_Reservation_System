package com.uoc.trainsystem.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.service.ViewBookingDetailsService;
import com.uoc.trainsystem.repository.dao.ViewBookingDetailsDAO;
import com.uoc.trainsystem.repository.wrapper.ViewBookingDetailsMappingDTO;

@Service
public class ViewBookingDetailsServiceImpl implements ViewBookingDetailsService {

	@Autowired
	private ViewBookingDetailsDAO viewBookingDetailsDAO;
	
	@MethodLogging
	@Override
	public List<ViewBookingDetailsMappingDTO> getDetails(Long userId) throws Exception{
		return this.viewBookingDetailsDAO.viewDetails(userId);
	}

}
