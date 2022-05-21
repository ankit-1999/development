package com.nagarro.trainee.advancejava.output;

import java.util.ArrayList;

import com.nagarro.trainee.advancejava.model.Tshirt;
import com.nagarro.trainee.advancejava.services.impl.TshirtServiceImpl;


public class Output {
	
	public void view()
	{
		ArrayList<Tshirt> result=TshirtServiceImpl.result;
		if(result.size()==0)
		{
			System.out.println("    ** Sorry no Tshirts available ** ");
			return ;
		}
		printFormat();
		for(int i=0;i<result.size();i++)
		{
			System.out.printf("%-20s",result.get(i).getId());
			System.out.printf("%-47s",result.get(i).getName());
			System.out.printf("%-9s",result.get(i).getColour());
			System.out.printf("%-24s",result.get(i).getGenderRecommendation());
			System.out.printf("%-7s",result.get(i).getSize());
			System.out.printf("%-8s",result.get(i).getPrice());
			System.out.printf("%-9s",result.get(i).getRating());
			System.out.print(result.get(i).getAvailability());
			System.out.println();
		}
		TshirtServiceImpl.result.clear(); // to clear result array 
		
		
	}
	
	private void printFormat()
	{
		System.out.printf("%-20s","ID");
		System.out.printf("%-47s","NAME");
		System.out.printf("%-9s","COLOUR");
		System.out.printf("%-24s","GENDER-RECOMMENDATION");
		System.out.printf("%-7s","SIZE");
	    System.out.printf("%-8s","PRICE");
	    System.out.printf("%-9s","RATING");
	    System.out.print("AVAILABILITY");
	    System.out.println();
	}

}
