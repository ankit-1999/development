package com.nagarro.trainee.advanceJava.model;

public class Tshirt {
	// T-shirt format ID|NAME|COLOUR|GENDER_RECOMMENDATION|SIZE|PRICE|RATING|AVAILABILITY

	String id;
	String name;
	String colour;
	String genderRecommendation;
	String size;
	public double price;
	public double rating;
	String availability;

	// set T-shirt id
	public void setId(String id)
	{
		this.id=id;
	}
	
	// set T-shirt name
	public void setName(String name)
	{
		this.name=name;
	}
	
	// set T-shirt colour
	public void setColour(String colour)
	{
		this.colour=colour;
	}
	
	// set T-shirt gender recommendation
	public void setGenderRecommendation(String g)
	{
		this.genderRecommendation=g;
	}
	
	// set T-shirt size
	public void setSize(String s)
	{
		this.size=s;
	}
	
	// set T-shirt price
	public void setPrice(double p)
	{
		this.price=p;
	}
	
	// set T-shirt rating
	public void setRating(double r)
	{
		this.rating=r;
	}
	
	// set T-shirt availability
	public void setAvailability(String a)
	{
		this.availability=a;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getColour()
	{
		return this.colour;
	}
	
	public String getGenderRecommendation()
	{
		return this.genderRecommendation;
	}
	
	public String getSize()
	{
		return this.size;
	}
	
	public String getAvailability()
	{
		return this.availability;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public double getRating()
	{
		return this.rating;
	}
}
