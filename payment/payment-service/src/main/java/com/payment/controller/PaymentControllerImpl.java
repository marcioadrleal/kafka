package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.model.Payment;
import com.payment.service.PaymentService;


@RestController
@RequestMapping(value = "/payments")
public class PaymentControllerImpl implements PaymentController {

	@Autowired
	private PaymentService service;
	
	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		service.sendPayment(payment);
		return new ResponseEntity<Payment>(HttpStatus.CREATED);
	}

}
