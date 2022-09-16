


Feature: User can log in using proper data
  Scenario Outline: User loged in existing account on url https://mystore-testlab.coderslab.pl
    Given User opened url https://mystore-testlab.coderslab.pl
    When User clicked sign in then filled out the form with data and clicked log in
    And clicked on Create new address button
    And filed the Alias form input: <alias>
    And filed the Address form input:<address>
    And filed the City form input:<city>
    And filed the PostalCode form input:<postalCode>
    And entered the Country: <country>
    And filed the Phone form input:<phoneNumber>
    And clicked on save button
    Then check that address is added
    Examples:
      |alias|address  |city |postalCode |country       |phoneNumber  |
      |Alias|Address  |City |11-111     |United Kingdom|123 345 567  |