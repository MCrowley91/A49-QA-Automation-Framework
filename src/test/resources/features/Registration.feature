Feature: Registration feature
@Regression
  Scenario: Registration page redirect success
    Given I navigate to Login page
    When I click Registration button
    Then I am directed to Register new account or Reset your password page