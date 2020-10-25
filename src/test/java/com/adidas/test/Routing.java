package com.adidas.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.adidas.javautil.GenericJavaMethods;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Routing {
     Response response;
     private static RequestSpecification httpRequest;
     public static long id;
     private String name;
     private AdidasPetTestCategory category;
     private List<String> photoUrls = new ArrayList<String>();
     private AdidasPetTestTag petTag;
 	private List<AdidasPetTestTag> tags = new ArrayList<AdidasPetTestTag>();
 	public static String status;
 	AdidasAddPetRequest addPetRequest;
 	
 	public Routing(String baseUrl) {
 		RestAssured.baseURI = baseUrl;
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
 	}
	public Response getPetsByAvailableStatus() {
		
		return response = httpRequest.request(Method.GET, "/v2/pet/findByStatus?status=available");
	}
	public Response getPetsBySoldStatus() {
		
		return response = httpRequest.request(Method.GET, "/v2/pet/findByStatus?status=sold");
	}
	public Response getPetsById(long id) {
		
		return response = httpRequest.request(Method.GET, "/v2/pet/"+id);
	}
	public Response postPets() throws NumberFormatException, IOException {
		category=new AdidasPetTestCategory();
		petTag= new AdidasPetTestTag();
		id=Integer.parseInt(GenericJavaMethods.getInstance().getPostId());
		name=GenericJavaMethods.getInstance().getPostName();
		category.setId(Integer.parseInt(GenericJavaMethods.getInstance().getPostCategoryId()));
		category.setName(GenericJavaMethods.getInstance().getPostCategoryName());
		photoUrls.add("photos");
		petTag.setId(Integer.parseInt(GenericJavaMethods.getInstance().getPostTagId()));
		petTag.setName(GenericJavaMethods.getInstance().getPostTagName());
		tags.add(petTag);
		status=GenericJavaMethods.getInstance().getPostStatus();
	    addPetRequest= new AdidasAddPetRequest(id,name,photoUrls,category,tags,status);
		return response = httpRequest.body(addPetRequest).request(Method.POST, "/v2/pet");
	}
	public Response updatePetDetails(String status) {
		Routing.status=status;
	    addPetRequest= new AdidasAddPetRequest(id,name,photoUrls,category,tags,Routing.status);
		return response = httpRequest.body(addPetRequest).request(Method.PUT, "/v2/pet");
	}
	public Response deletePetDetailsById(long id){
		return response = httpRequest.body(addPetRequest).request(Method.DELETE, "/v2/pet/"+id);
	}
}
