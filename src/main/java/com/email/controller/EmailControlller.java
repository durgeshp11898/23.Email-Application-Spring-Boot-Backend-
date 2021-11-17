package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.payloads.EmailResponse;
import com.email.service.EmailService;

@RestController
public class EmailControlller {

	@Autowired
	private EmailService emailService;

	@GetMapping("/welcome")
	public String welcomeController() {
		return "Hey, this is Welcome Controller";
	}

	//to send email
	@RequestMapping(value = "/sendEmail" ,method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){
		try {
			System.out.println(emailRequest);
			boolean result = this.emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage());
			if(result) {
				return ResponseEntity.ok(new EmailResponse("Email is sent Successfuly"));
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email is Not sended due to some technical probelm"));
			}

		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok("Data Not Accepting from Postman");

		}

	}
}
