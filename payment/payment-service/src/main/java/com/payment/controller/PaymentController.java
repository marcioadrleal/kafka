package com.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.model.Payment;

public interface PaymentController {

	
	@PostMapping
	ResponseEntity<Payment> payment(@RequestBody Payment payment);
	
}
