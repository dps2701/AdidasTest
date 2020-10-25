$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Adidas.feature");
formatter.feature({
  "name": "Adidas Test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate available pets, add a pet, update the pet details and delete the pet",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I retrieve available pets",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.i_retrieve_available_pets()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "all the pets with status available are returned",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.all_the_pets_with_status_available_are_returned()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add a pet to the list",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.i_add_a_pet_to_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I retrieve pets by id",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.i_retrieve_pets_by_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the pet is added successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.the_pet_is_added_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I update the pet details",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.i_update_the_pet_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I retrieve pets by id",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.i_retrieve_pets_by_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pet details are updated successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.pet_details_are_updated_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I delete the pet",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.i_delete_the_pet()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I retrieve pets by id",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.i_retrieve_pets_by_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "pet details should be removed from the list",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.PetValidationSteps.pet_details_should_be_removed_from_the_list()"
});
formatter.result({
  "status": "passed"
});
});