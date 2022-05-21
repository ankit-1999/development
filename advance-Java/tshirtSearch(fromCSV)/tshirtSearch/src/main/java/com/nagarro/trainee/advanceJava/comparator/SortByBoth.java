package com.nagarro.trainee.advanceJava.comparator;

import java.util.Comparator;

import com.nagarro.trainee.advanceJava.model.Tshirt;

public class SortByBoth implements Comparator<Tshirt> {

	public int compare(Tshirt o1, Tshirt o2) {
		if (o1.price > o2.price) {
			return 1;
		} else if (o1.price < o2.price) {
			return -1;
		} else {
			if (o1.rating < o2.rating) {
				return 1;
			} else {
				return -1;
			}
		}
	}

}