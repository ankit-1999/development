package com.nagarro.trainee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainee.model.PinCode;
import com.nagarro.trainee.service.IPinCodeService;

@CrossOrigin
@RestController
public class PinCodeController {

	@Autowired
	IPinCodeService iPinCodeService;

	@GetMapping("/getPinCode/{id}")
	public ResponseEntity<List<PinCode>> getPinCode(@PathVariable("id") String id) {
		List<PinCode> pinCodes = iPinCodeService.getPinCode(id);
		System.out.println("pincodes got succesfully");
		System.out.println(pinCodes);
		return new ResponseEntity<>(pinCodes, HttpStatus.OK);
	}

}
