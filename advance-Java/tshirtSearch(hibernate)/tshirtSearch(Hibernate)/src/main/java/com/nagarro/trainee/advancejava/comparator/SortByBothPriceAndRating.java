package com.nagarro.trainee.advancejava.comparator;

import java.util.Comparator;

import com.nagarro.trainee.advancejava.model.Tshirt;

public class SortByBothPriceAndRating implements Comparator<Tshirt> {

	public int compare(Tshirt o1, Tshirt o2) {
		// TODO Auto-generated method stub
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
