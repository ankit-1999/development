package com.nagarro.trainee.advancejava.services;

import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;

public interface ITshirtService {
	
	// will search and return all Tshirts matching with user input preferences
	public void searchTshirt() throws CsvValidationException, NumberFormatException, IOException;

}
