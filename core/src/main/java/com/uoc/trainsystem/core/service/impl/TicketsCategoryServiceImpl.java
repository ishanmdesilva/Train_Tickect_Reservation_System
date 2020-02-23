package com.uoc.trainsystem.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.uoc.trainsystem.core.response.TicketsCategoryResponseDTO;
import com.uoc.trainsystem.core.service.TicketsCategoryService;
import com.uoc.trainsystem.repository.TicketsCategoryRepository;
import com.uoc.trainsystem.repository.entities.TicketsCategory;

@Service
public class TicketsCategoryServiceImpl implements TicketsCategoryService {

	@Autowired
	private TicketsCategoryRepository mstTicketsCategoryRepository;
	
	TicketsCategory mstTicketsCategory = null;
	
	@MethodLogging
	@Override
	public TicketsCategoryResponseDTO getById(int id) throws Exception {
		Optional<TicketsCategory> optMstTicketsCategory = this.mstTicketsCategoryRepository.findById(id);
		if(optMstTicketsCategory.isPresent()) {
			mstTicketsCategory = optMstTicketsCategory.get();
		}
		return buildResponseDTO(mstTicketsCategory);
	}
	
	@MethodLogging
	@Override
	public List<TicketsCategoryResponseDTO> getALL() throws Exception {
		List<TicketsCategory> allTickectCategory = this.mstTicketsCategoryRepository.findAll();
		List<TicketsCategoryResponseDTO> resList = new ArrayList<>();
		allTickectCategory.forEach(item -> resList.add(buildResponseDTO(item)));
		return resList;
	}

	private TicketsCategoryResponseDTO buildResponseDTO(TicketsCategory res) {
		return TicketsCategoryResponseDTO.builder()
				.id(res != null ? res.getId() : null)
				.name(res != null ? res.getName() : null)
				.code(res != null ? res.getCode() : null)
				.build();
		
	}

}
