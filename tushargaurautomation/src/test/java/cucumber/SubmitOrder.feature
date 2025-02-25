
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
	Background:
Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test for Submitting the order
  
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name  									 | password | productName  		|
      | gaur.tushar281@gmail.com | Test1234	| ZARA COAT 3 		|
      | gaur.tushar281@gmail.com | Test1234	| IPHONE 13 PRO   |
      | gaur.tushar281@gmail.com | Test1234	| ADIDAS ORIGINAL |
		