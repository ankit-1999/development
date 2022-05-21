package com.nagarro.trainee.advanceJava.services.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collections;


import com.nagarro.trainee.advanceJava.comparator.SortByBoth;
import com.nagarro.trainee.advanceJava.comparator.SortByPrice;
import com.nagarro.trainee.advanceJava.comparator.SortByRating;
import com.nagarro.trainee.advanceJava.constants.Constants;
import com.nagarro.trainee.advanceJava.input.Input;
import com.nagarro.trainee.advanceJava.model.Tshirt;
import com.nagarro.trainee.advanceJava.services.ITshirtService;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class TshirtServiceImpl implements ITshirtService, Runnable {

	public static ArrayList<Tshirt> Tshirts = new ArrayList<Tshirt>();
	public static ArrayList<Tshirt> result = new ArrayList<Tshirt>();

	public TshirtServiceImpl(){
		try {
			parseDataFromCSV();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// watchservice
	

	public void run() {

		try {

			// watch service to check if any modification is done in folder.if it is then it
			// will return an event i.e what type of event is fired
			WatchService watchservice = FileSystems.getDefault().newWatchService();
			Path path = Paths.get(Constants.FILEPATH); // path of file on which we will use watch services
			WatchKey key = path.register(watchservice, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

			while (true) {
				// key.pollEvents() will return list of all events accourred in registered path
				if (key.pollEvents().size() != 0) {
					Tshirts.clear();
					parseDataFromCSV();
				}
				/*
				 * for(WatchEvent<?> event: key.pollEvents()) {
				 * System.out.println("event type "+event.kind()+
				 * "file effected"+event.context()); break; }
				 */
				try {
					Thread.sleep(20000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void searchTshirt() {

		for (int i = 0; i < Tshirts.size(); i++) {
			if (Tshirts.get(i).getColour().equalsIgnoreCase(Input.colour)
					&& Tshirts.get(i).getSize().equalsIgnoreCase(Input.size)
					&& Tshirts.get(i).getGenderRecommendation().equalsIgnoreCase(Input.gender)
					&& Tshirts.get(i).getAvailability().equalsIgnoreCase("Y")) {
				result.add(Tshirts.get(i));
			}
		}
		sortByPreference();

	}

	private void parseDataFromCSV() throws CsvException, Exception, IOException {
		File file = new File(Constants.FILEPATH);
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
				Tshirts.add(tshirt);
			}
			reader.close();

		}
	
	}

	private void sortByPreference() {
		if (Input.outputPreference.equalsIgnoreCase("Price")) {
			Collections.sort(result, new SortByPrice());
		} else if (Input.outputPreference.equalsIgnoreCase("Rating")) {
			Collections.sort(result, new SortByRating());
		} else {
			Collections.sort(result, new SortByBoth());
		}
	}

	

}
