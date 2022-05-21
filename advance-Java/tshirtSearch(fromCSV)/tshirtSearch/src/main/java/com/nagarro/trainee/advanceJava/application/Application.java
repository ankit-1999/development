package com.nagarro.trainee.advanceJava.application;

import com.nagarro.trainee.advanceJava.input.Input;
import com.nagarro.trainee.advanceJava.output.Output;
import com.nagarro.trainee.advanceJava.services.impl.TshirtServiceImpl;

public class Application {

	public static void main(String[] args) {
		TshirtServiceImpl st = new TshirtServiceImpl();
		Thread t = new Thread(st);
		t.start();
		while (true) {

			Input io = new Input();
			io.input();
			st.searchTshirt();
			Output ot = new Output();
			ot.view();
			System.out.println();
			System.out.println();
		}

	}
}
