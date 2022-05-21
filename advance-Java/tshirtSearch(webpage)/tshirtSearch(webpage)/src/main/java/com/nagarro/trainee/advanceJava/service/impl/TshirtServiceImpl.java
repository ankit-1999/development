package com.nagarro.trainee.advanceJava.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nagarro.trainee.advanceJava.comparator.*;
import com.nagarro.trainee.advanceJava.constant.Constant;
import com.nagarro.trainee.advanceJava.dao.TshirtDao;
import com.nagarro.trainee.advanceJava.model.Tshirt;
import com.nagarro.trainee.advanceJava.service.ITshirtService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class TshirtServiceImpl implements ITshirtService {

	@Autowired
	private TshirtDao tshirtDao;

	public List<Tshirt> searchTshirt(String colour, String size, String gender, String outputPreference) {
		List<Tshirt> list = tshirtDao.getTshirts(colour, size, gender);
		return sortByPreference(list, outputPreference);
	}

	public void praseFromCsv() throws CsvException, Exception, IOException {
		File file = new File(Constant.FILEPATH);
		File[] fileList = file.listFiles();

		for (File f : fileList) {

			CSVReader reader = new CSVReader(new FileReader(f));
			String[] nextLine;
			String[] arr;
			int tmp = 0;
			while ((nextLine = reader.readNext()) != null) {
				if (tmp == 0) {
					tmp++;
					continue;
				}
				Tshirt tshirt = new Tshirt();
				for (int i = 0; i < nextLine.length; i++) {
					arr = nextLine[i].split("\\|");
					tshirt.setId(arr[0]);
					tshirt.setName(arr[1]);
					tshirt.setColour(arr[2]);
					tshirt.setGenderRecommendation(arr[3]);
					tshirt.setSize(arr[4]);
					tshirt.setPrice(Double.parseDouble(arr[5]));
					tshirt.setRating(Double.parseDouble(arr[6]));
					tshirt.setAvailability(arr[7]);
				}
				tshirtDao.createTshirt(tshirt);
			}
			reader.close();
		}
	}

	public List<Tshirt> sortByPreference(List<Tshirt> list, String outputPreference) {

		System.out.println("in sort by preference");
		if (outputPreference.equalsIgnoreCase("price")) {
			Collections.sort(list, new SortByPrice());
		} else if (outputPreference.equalsIgnoreCase("rating")) {
			Collections.sort(list, new SortByRating());
		} else {
			Collections.sort(list, new SortByBoth());
		}
		return list;
	}

	public void truncateTable() {
		// TODO Auto-generated method stub
		tshirtDao.truncateTable();
	}

	
	
}
