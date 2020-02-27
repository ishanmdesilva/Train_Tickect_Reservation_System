package com.uoc.trainsystem.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoc.trainsystem.core.request.AppRequest;
import com.uoc.trainsystem.core.request.MessageSenderRequest;
import com.uoc.trainsystem.core.service.MessageSenderService;

@RestController
@RequestMapping("/messege-sender")
public class MessageSenderController {

	@Autowired
	private MessageSenderService messageSenderService;
	
	@PostMapping
	public String sendMessage(@Valid @RequestBody AppRequest<MessageSenderRequest> req) {
		try {
			return this.messageSenderService.sendMessage(req.getData());
			
		} catch (Exception e) {	
			return "sms service error..";
		
		}	
	}
	
}
