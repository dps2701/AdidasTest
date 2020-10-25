package com.adidas.test;


import java.util.ArrayList;
import java.util.List;

public class AdidasAddPetRequest {
	public  long id;

	public AdidasPetTestCategory category;

	public String name;

	public List<String> photoUrls = new ArrayList<String>();

	public List<AdidasPetTestTag> tags = new ArrayList<AdidasPetTestTag>();

	public String status;
	//This currently adds a single pet
	public AdidasAddPetRequest(long id, String name, List<String>photoUrls,
			AdidasPetTestCategory category,List<AdidasPetTestTag> tags,String status)
	{
		this.id=id;
		this.name=name;
		this.category=category;
		this.photoUrls=photoUrls;
		this.tags=tags;
		this.status=status;

	}
}
