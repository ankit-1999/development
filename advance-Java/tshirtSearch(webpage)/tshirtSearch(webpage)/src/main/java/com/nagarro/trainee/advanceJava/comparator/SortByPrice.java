package com.nagarro.trainee.advanceJava.comparator;

import java.util.Comparator;

import com.nagarro.trainee.advanceJava.model.Tshirt;

public class SortByPrice implements Comparator<Tshirt> {

	public int compare(Tshirt o1, Tshirt o2) {
		// TODO Auto-generated method stub
		if (o1.price > o2.price) {
			return 1;
		} else {
			return -1;
		}
	}
}
