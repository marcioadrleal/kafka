package com.payment.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.payment.model.Payment;


@Service
public class PaymentServiceImpl implements PaymentService {
	
	static final Logger logger = LogManager.getLogger(PaymentServiceImpl.class.getName());

	@Override
	public void sendPayment(Payment payment) {
	  logger.info("Message: " , payment);
		
	}

}
