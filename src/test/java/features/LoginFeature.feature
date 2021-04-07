Feature: Application login

  Scenario: Valid user is able to login
    Given User navigates to the "https://demo.spreecommerce.org/" page
    When User logs in with username "test@valid.com" and password "<some-text>"
    Then User is logged in successfully


  Scenario: Invalid user is unable to login
    Given User navigates to the "https://demo.spreecommerce.org/" page
    When User logs in with username "test@invalid.com" and password "<some-text>"
    Then An error message is displayed
