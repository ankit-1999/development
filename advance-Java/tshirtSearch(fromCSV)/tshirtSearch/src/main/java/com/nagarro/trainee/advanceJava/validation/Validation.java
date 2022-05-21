package com.nagarro.trainee.advanceJava.validation;

import com.nagarro.trainee.advanceJava.input.Input;

public class Validation extends Input{

	
	// valid gender is M=male and F=female
	public static boolean validateGender(String g)
	{
		if(g.equals("F") || g.equals("M"))
		{
			return true;
		}
	    else
		{
	        System.out.println(" Please enter valid gender i.e M=Male and F=Female");
			return false;
		}
	}
	
	// valid size are   S, M, L, XL, XXL
	public static boolean validateSize(String s)
	{
		if(s.equals("S") || s.equals("M") || s.equals("L") || s.equals("XL") || s.equals("XXL"))
		{
			return true;
		}
		else
		{
			System.out.println(" Please Enter valid T-shirt size i.e { S, M, L, XL, XXL } ");
			return false;
		}
	}
	
	//
	public static boolean validateOutputPreference(int i)
	{
		if(i==1)
		{
			Input.outputPreference="Price";
			return true;
		}
		else if(i==2)
		{
			Input.outputPreference="Rating";
			return true;
		}
		else if(i==3)
		{
			Input.outputPreference="Price And Rating";
			return true;
		}
		else
		{
			return false;
		}
	}
}
