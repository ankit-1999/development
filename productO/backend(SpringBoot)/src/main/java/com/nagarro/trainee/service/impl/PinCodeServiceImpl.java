package com.nagarro.trainee.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainee.dao.IPinCodeDao;
import com.nagarro.trainee.model.PinCode;
import com.nagarro.trainee.service.IPinCodeService;

@Service
public class PinCodeServiceImpl implements IPinCodeService {

	@Autowired
	IPinCodeDao iPinCodeDao;

	@Override
	public List<PinCode> getPinCode(String productCode) {
		List<PinCode> pinCodes = Collections.EMPTY_LIST;
		try {
			pinCodes = iPinCodeDao.getPinCode(productCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pinCodes;
	}

}
