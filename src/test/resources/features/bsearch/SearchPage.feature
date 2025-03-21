@SearchTest
Feature: Search and Select the pets
	Scenario: Search for a pet and select pet and product items
		Given User is on the HomePage
		When User search for "Dog"
		Then User selects the first pet from search results
		Then User selects a product item
		Then Displays the price of product
