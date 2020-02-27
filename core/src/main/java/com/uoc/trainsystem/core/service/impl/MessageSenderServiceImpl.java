package com.uoc.trainsystem.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inova.applogger.util.MethodLogging;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import com.uoc.trainsystem.config.TwilioConfig;
import com.uoc.trainsystem.core.request.MessageSenderRequest;
import com.uoc.trainsystem.core.service.MessageSenderService;

@Service
public class MessageSenderServiceImpl implements MessageSenderService {

	@Autowired
	private TwilioConfig twilioConfig;
	
	@MethodLogging
	@Override
	public String sendMessage(MessageSenderRequest req) throws Exception{
		if(req.getBookingdetailsId() != null) {
			MessageCreator creator = Message.creator(new PhoneNumber(req.getPhoneNumber()),
							new PhoneNumber(twilioConfig.getTrailNumber()),
							"Your tickets has been successfully booked with reference number QR00"+req.getBookingdetailsId()+".please come and collect your tickets..");
			creator.create();
			
			return "sms success";
		} else {
			return "sms fail";	
		}
		
	}

}
