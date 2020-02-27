package com.uoc.trainsystem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitiazer {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitiazer.class);
	@SuppressWarnings("unused")
	private final TwilioConfig twilioConfig;
	
	@Autowired
	public TwilioInitiazer(TwilioConfig twilioConfig) {
		this.twilioConfig = twilioConfig;
		Twilio.init(twilioConfig.getAccountId(), twilioConfig.getAuthSid());
		LOGGER.info("Twilio initilializer......with account sid {}",twilioConfig.getAccountId());
	}

}
