package stepDefs;

import java.io.IOException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.*;

import com.adidas.javautil.GenericJavaMethods;
import com.adidas.test.AdidasPetTest;
import com.adidas.test.Routing;

public class PetValidationSteps {
	
	private static Response response;
	Routing routing = new Routing(GenericJavaMethods.getInstance().getBaseUrl());
	
		
    @Given("I retrieve available pets")
	public void i_retrieve_available_pets() throws IOException {
		response=routing.getPetsByAvailableStatus();
	
	}

	@Then("all the pets with status available are returned")
	public void all_the_pets_with_status_available_are_returned() {
		boolean flag=false;
		if(response.getStatusCode()==200){
			AdidasPetTest[]  petsAvailable= response.getBody().as(AdidasPetTest[].class);
			 for(int i=0; i<petsAvailable.length;i++){
				if(petsAvailable[i].getStatus().equalsIgnoreCase("available")){
					flag=true;
				}else{
					flag=false;
					break;
				}
			 }
			 }else{
				 Assert.assertTrue(false);
			 }
			Assert.assertTrue(flag);
		
		
		
		
		
	}

	@When("I add a pet to the list")
	public void i_add_a_pet_to_the_list() throws IOException {
		response=routing.postPets();
		Assert.assertEquals(200, response.getStatusCode());
		
	}
	@And("I retrieve pets by id")
	public void i_retrieve_pets_by_id() throws IOException {
		response=routing.getPetsById(Routing.id);
	
	}
	@Then("the pet is added successfully")
	public void the_pet_is_added_successfully() {
		boolean flag=false;
      if(response.getStatusCode()==200){
    	  AdidasPetTest pets= response.getBody().as(AdidasPetTest.class);
			
				if(pets.getId()==Routing.id){
					flag=true;
					
				}else{
					flag=false;
				}
			 
			 }else{
				 Assert.assertTrue(false);
			 }
      Assert.assertTrue(flag);
      }
	

	@When("I update the pet details")
	public void i_update_the_pet_details() throws IOException {
       String status=GenericJavaMethods.getInstance().getPostUpdatedStatus();
		response=routing.updatePetDetails(status);
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("pet details are updated successfully")
	public void pet_details_are_updated_successfully() {
		boolean flag=false;
	      if(response.getStatusCode()==200){
	    	  AdidasPetTest pets= response.getBody().as(AdidasPetTest.class);
				
					if(pets.getId()==Routing.id && pets.getStatus().equalsIgnoreCase(Routing.status)){
						flag=true;
						
					}else{
						flag=false;
					}
				 
				 }else{
					 Assert.assertTrue(false);
				 }
	      Assert.assertTrue(flag);
	}

	@When("I delete the pet")
	public void i_delete_the_pet() throws IOException {
		response=routing.deletePetDetailsById(Routing.id);
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("pet details should be removed from the list")
	public void pet_details_should_be_removed_from_the_list() {
		boolean flag=false;
		Assert.assertEquals(404, response.getStatusCode());
	      if(response.getStatusCode()==404){
				JsonPath jsonPath= new JsonPath(response.getBody().asString());
					if(jsonPath.get("type").toString().equalsIgnoreCase("error")
							&& jsonPath.get("message").toString().contains("not found")){
						flag=true;
						
					}else{
						flag=false;
					}
				 
				 }else{
					 Assert.assertTrue(false);
				 }
	      Assert.assertTrue(flag);
	}

}
