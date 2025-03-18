Feature: Product Details and Cart Functionality

  Scenario: Validate product details
    Given user is on the product page for "FI-FW-02"
    Then product title should be "Adult Male Goldfish"
    And product description should be visible
    And product price should be displayed
    And product image should be present
    And product availability should be "in stock"
    Then add the product to cart
    Then check if user is directed to cart page "https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-20"
    
