package com.nagarro.trainee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.trainee.model.PinCode;

@Service
public interface IPinCodeService {

	public List<PinCode> getPinCode(String productCode);

}
