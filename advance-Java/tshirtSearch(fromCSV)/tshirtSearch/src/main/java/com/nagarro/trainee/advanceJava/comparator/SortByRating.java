package com.nagarro.trainee.advanceJava.comparator;

import java.util.Comparator;

import com.nagarro.trainee.advanceJava.model.Tshirt;

public class SortByRating implements Comparator<Tshirt> {

	public int compare(Tshirt o1, Tshirt o2) {
		// TODO Auto-generated method stub
		if (o1.rating < o2.rating) {
			return 1;
		} else {
			return -1;
		}
	}

}
