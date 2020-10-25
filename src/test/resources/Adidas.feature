Feature: Adidas Test


Scenario: Validate available pets, add a pet, update the pet details and delete the pet
Given I retrieve available pets
Then all the pets with status available are returned
When I add a pet to the list
And I retrieve pets by id
Then the pet is added successfully
When I update the pet details
And I retrieve pets by id
Then pet details are updated successfully
When I delete the pet
And I retrieve pets by id
Then pet details should be removed from the list