Feature: Line Manager Tests
  As a bank manager, I want to perform various operations on customer accounts.

  Scenario Outline: Validate manager user can  added new customer
    Given the user is on the home page
    When the user clicks on the bank manager login button
    Then the manager actions should be displayed
    When the user adds a new customer with first name "<firstName>", last name "<lastName>", and postcode "<postCode>"
       Then the customer should be added successfully message "Customer added successfully with customer id :"
    Examples:
      | firstName | lastName | postCode |
      | John      | Doe      | 12345    |
      | Jane      | Smith    | 67890    |
      | Alice     | Aeson  | 54321    |

  Scenario: Validate user can open a new account
    Given the user is on the home page
    When the user clicks on the bank manager login button
    And a customer has been added "amal" "osman" "90909"
       Then the customer should be added successfully message "Customer added successfully with customer id :"
    When the user opens a new account for the customer
    Then the account should be created successfully message "Account created successfully with account Number :"

  Scenario: Validate user can sort customers by postcode
    Given the user is on the home page
    When the user clicks on the bank manager login button
    And the customer list is displayed
    When the user sorts customers by postcode
    Then the customers should be sorted in ascending order
    When the user sorts customers by postcode
    Then the customers should be sorted in descending order
  Scenario: Validate user can search for a customer by first name
    Given the user is on the home page
    When the user clicks on the bank manager login button
    Then the customer list is displayed
    When the user searches for a customer with first name "John"
    Then the customer should be displayed

  Scenario: Validate user can delete a customer
    Given the user is on the home page
    When the user clicks on the bank manager login button
    Then the customer list is displayed
    When the user deletes the customer with first name "John"
    Then the customer should no longer be displayed

  Scenario: Validate user can deposit money and  user can view transactions
   Given the user is on the home page
    When the user clicks on the bank manager login button
    And a customer has been added "Asmaa" "osman" "202020"
    Then the customer should be added successfully message "Customer added successfully with customer id :"
    When the user opens a new account for the customer
    Then the account should be created successfully message "Account created successfully with account Number :"
    When the user is on the home page
    And the user logs in as a customer
    When the user deposits "100" into the account
    Then the deposit should be successful message "Deposit Successful"
    When the user views transactions
    Then the transaction should be displayed

