Scenario: Valid form fill
Given An new address form opened in browser
When Required fields of form filled with correct data
Then Check the correctness of the data


Feature: User can log in using proper data
#
#  Scenario: User loged in existing account on url https://mystore-testlab.coderslab.pl
#    Given User opened url https://mystore-testlab.coderslab.pl
#    When User clicked on SignIn button And clicked LogIn button after entered corect email and password
#    And clicked on View Customer Account button
#    And clicked on Adresses button
#    And clicked on Create new address button
#    And filed the form inputs: alias, address, city, zipCode, phone
#    And checked that entered data is correct
#    And clicked on save button
#    Then new address was created
  Scenario Outline: User loged in existing account on url https://mystore-testlab.coderslab.pl
    Given User opened url https://mystore-testlab.coderslab.pl
    When User clicked on SignIn button And clicked LogIn button after entered correct email and password
    And clicked on View Customer Account button
    And clicked on Addresses button
    And clicked on Create new address button
    And filed the Alias form input: <alias>
    And filed the Address form input:<address>
    And filed the City form input:<city>
    And filed the PostalCode form input:<postalCode>
    And enter the country
    And filed the Phone form input:<phoneNumber>
    And check that data in form is correct
    And clicked on save button
    Then check that address is added
    Examples:
      |alias|address  |city |postalCode |phoneNumber  |
      |Alias|Address  |City |11-11      |123 345 567  |