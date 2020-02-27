package com.uoc.trainsystem.core.service;

import com.uoc.trainsystem.core.request.MessageSenderRequest;

public interface MessageSenderService {

	String sendMessage(MessageSenderRequest req) throws Exception;
	
}
