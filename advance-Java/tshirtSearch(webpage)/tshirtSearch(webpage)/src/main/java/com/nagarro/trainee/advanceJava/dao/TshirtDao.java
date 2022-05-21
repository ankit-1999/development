package com.nagarro.trainee.advanceJava.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.trainee.advanceJava.model.Tshirt;

@Repository
public class TshirtDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void createTshirt(Tshirt tshirt) {
		this.hibernateTemplate.save(tshirt);
	}

	// get all products
	@SuppressWarnings("unchecked")
	public List<Tshirt> getTshirts(String colour, String size, String genderRecommendation) {
		System.out.println(this.hibernateTemplate);
		List<Tshirt> tshirts = (List<Tshirt>) this.hibernateTemplate.find(
				"from Tshirt where colour=?0 and size=?1 and genderRecommendation=?2 and availability=?3 ", colour,size,genderRecommendation,"Y");
		return tshirts;
	}

	// get the single product
	public Tshirt getTshirt(String pid) {
		return this.hibernateTemplate.get(Tshirt.class, pid);
	}

	@Transactional
	public void truncateTable()
	{
		hibernateTemplate.delete("from Tshirt");
		System.out.println("delete done");
		
	}
	
}
