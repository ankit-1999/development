package com.nagarro.trainee.advancejava.application;

import com.nagarro.trainee.advancejava.input.Input;
import com.nagarro.trainee.advancejava.output.Output;
import com.nagarro.trainee.advancejava.services.impl.TshirtServiceImpl;

public class Main {

	public static void main(String[] args) {

		TshirtServiceImpl st = new TshirtServiceImpl();
		Thread t = new Thread(st);
		t.start();
		while (true) {
			Input io = new Input();
			io.input();
			st.searchTshirt();
			Output ot = new Output();
			System.out.println();
			ot.view();
			System.out.println();
			System.out.println();
		}

	}
}
