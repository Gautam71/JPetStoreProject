Feature: Shopping Cart Functionality

  Scenario: Add multiple products to the cart
    Given user is on the homepage     
    When user search for the animals and add first product to cart 
    	| fish |
      | dog |
      | snake |
    Then the cart should display the following products
      | Adult Male Goldfish |
      | Male Adult Bulldog |
      | Venomless Rattlesnake |

  Scenario:
  	Given user is on the cart page
  	When user update quantity of a product
  	Then quantity should be updated in the cart
  	
  Scenario:
  	Given user is on the cart page
  	When user removes a product "EST-6" from the cart 
  	Then it should be removed from the cart

  Scenario: Proceed to checkout
    Given user has items in the cart
    When user proceeds to checkout
    Then checkout page should be displayed
