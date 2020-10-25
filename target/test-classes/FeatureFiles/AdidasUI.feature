Feature: Adidas UI Test

@AdidasUITest
Scenario: Validate the laptop addition to Cart and its purchase value
Given I am on HomePage
When  I select laptop
And   I add it to cart
And   I accept the popup
When  I select laptop
And   I add it to cart
And   I accept the popup
And   I navigate to cart page
Then  I should see both the laptops on cart page
When  I delete laptop
And   I click on place order
And   I fill the form with all the details
And   I click on Purchase
Then  I should see purchase id and expected total amount
And   I click on Ok button


