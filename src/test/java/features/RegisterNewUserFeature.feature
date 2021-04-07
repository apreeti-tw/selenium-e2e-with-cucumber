Feature: Register new user

  Scenario Outline: New user is registered successfully
    Given User navigates to the "https://demo.spreecommerce.org/" page
    When User signs up with "<username>" and "<password>"
    Then User is registered successfully

    Examples:
      |username         |password
      |test1@valid.com  |<some-text>
      |test2@valid.com  |<some-text>
