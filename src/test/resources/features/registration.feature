Feature: Registration


  Scenario Outline: Successful registration
    Given Pepito wants to sing up in the aplication
    When Pepito send the required information to sing up
    |<name>|<last name>|<age>|<email>|<country>|
    Then Pepito should have a new account created
    Examples:
    |name|last name|age|email|country|
    |Julian|Mesa|26|pepito@gmail.com|Colombia|
    |Henrry|Chari|21|goku@gmail.com|Colombia|



  Scenario: Missing required fields for registration
    Given Pepito wants to sing up in the aplication
    When Pepito does not send the required information
    Then Pepito should be told all fields are required


