package com.nagarro.trainee.advancejava.services.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.trainee.advancejava.comparator.*;
import com.nagarro.trainee.advancejava.constants.Constant;
import com.nagarro.trainee.advancejava.input.Input;
import com.nagarro.trainee.advancejava.model.Tshirt;
import com.nagarro.trainee.advancejava.services.ITshirtService;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TshirtServiceImpl implements ITshirtService, Runnable {
	
	public TshirtServiceImpl()
	{
		try {
			// first it will parse data from csv to database
			parseDataFromCSV();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	// to store matching tshirt from searchFromDatabase()
	public static ArrayList<Tshirt> result = new ArrayList<Tshirt>();

	public void run() {
		// TODO Auto-generated method stub

		try {
			
			// watch service to check if any modification is done in folder.if it is then it
			// will return an event i.e what type of event is fired
			WatchService watchservice = FileSystems.getDefault().newWatchService();
			Path path = Paths.get(Constant.FILEPATH); // path of file on which we will use watch services
			WatchKey key = path.register(watchservice, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

			while (true) {
				// key.pollEvents() will return list of all events accourred in registered path
				if (key.pollEvents().size() != 0) {
					
					truncateTable();
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

	// searchTshirt will search for all tshirts matching with user input preferences
	public void searchTshirt() {
		// TODO Auto-generated method stub
		searchFromDatabase();
		sortByPreference();

	}

	// searchFromDatabase will search for matching tshirt form database
	private void searchFromDatabase() {
		String gender = Input.gender;
		String size = Input.size;
		String colour = Input.colour;
		String availability = "Y";
	ss(Tshirt.class);
		SessionFactory sf = con.buildSessionFactory(	Configuration con = new Configuration().configure().addAnnotatedCla);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(
				"from Tshirt where genderRecommendation= :a and size= :b and colour= :c and availability= :d ");
		q.setParameter("a", gender);
		q.setParameter("b", size);
		q.setParameter("c", colour);
		q.setParameter("d", availability);
		List<Tshirt> list = q.list();
		for (Tshirt s : list) {
			result.add(s);
		}
		tx.commit();
		session.close();
	}

	// parseDataFromCSV will parse all data from CSV file to database
	private void parseDataFromCSV() throws CsvValidationException, NumberFormatException, IOException {

		Configuration con = new Configuration().configure().addAnnotatedClass(Tshirt.class);
		SessionFactory factory = con.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// all file inside this path folder wil get store in file
		File file = new File(Constant.FILEPATH);
		File[] fileList = file.listFiles();

		// now we will traverse inside each file in this folder
		for (File f : fileList) {
			// CSVreader to read CSV files
			CSVReader reader = new CSVReader(new FileReader(f));
			String[] nextLine; // to store current line in csv file
			String[] arr; // to store current line of csv file in array format
			boolean tmp = true; // to avoid first line i.e header line
			while ((nextLine = reader.readNext()) != null) // this will return null if there is no next line in file
			{
				if (tmp == true) // will check if current line is header or not
				{
					tmp = false;
					continue;
				}
				Tshirt tshirt = new Tshirt();
				for (int i = 0; i < nextLine.length; i++) {
					arr = nextLine[i].split("\\|"); // nextLine converted to string using split function
					tshirt.setId(arr[0]);
					tshirt.setName(arr[1]);
					tshirt.setColour(arr[2]);
					tshirt.setGenderRecommendation(arr[3]);
					tshirt.setSize(arr[4]);
					tshirt.setPrice(Double.parseDouble(arr[5]));
					tshirt.setRating(Double.parseDouble(arr[6]));
					tshirt.setAvailability(arr[7]);
				}
				session.save(tshirt); // tshirt saved to database inside tshirts table
			}
			reader.close(); // to close CSV reader

		}
		tx.commit(); // to save all changes
		session.close();
		// session closed
	}

	// will sort result array to user output preference using comparator functions
	private void sortByPreference() {
		if (Input.outputPreference.equalsIgnoreCase("Price")) {
			Collections.sort(result, new SortByPrice());
		} else if (Input.outputPreference.equalsIgnoreCase("Rating")) {
			Collections.sort(result, new SortByRating());
		} else {
			Collections.sort(result, new SortByBothPriceAndRating());
		}
	}

	// trucate table will clear all datainside Tshirt table in database. 
	private void truncateTable()
	{
		Configuration configure=new Configuration().configure().addAnnotatedClass(Tshirt.class);
		SessionFactory factory=configure.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		 session.createSQLQuery("Truncate TABLE Tshirt").executeUpdate();
	     tx.commit();
	     session.close();
		
		
	}
	
}
