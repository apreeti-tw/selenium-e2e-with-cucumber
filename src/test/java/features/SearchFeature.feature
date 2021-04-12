Feature: Search

  Scenario: Valid keyword returns search results
    Given User navigates to the "https://demo.spreecommerce.org/" page
    When User searches for "dress"
    Then Products list should be displayed

  Scenario: Invalid keyword returns no search results
    Given User navigates to the "https://demo.spreecommerce.org/" page
    When User searches for "invalid keyword"
    Then No search results should be displayed



