package com.nagarro.trainee.advanceJava.service;

import java.io.IOException;
import java.util.List;

import com.nagarro.trainee.advanceJava.model.Tshirt;
import com.opencsv.exceptions.CsvException;

public interface ITshirtService {

	public List<Tshirt> searchTshirt(String colour, String size, String gender, String outputPreference);

	public void praseFromCsv() throws CsvException, Exception, IOException;

	public List<Tshirt> sortByPreference(List<Tshirt> list, String outputPreference);
	
	public void truncateTable();

}
