Feature: Play Song feature
@Regression
  Scenario: Play Song success
    Given I go to Login page
    When I enter the email "mary.crowley@testpro.io"
    And I enter the password "Password"
    And I click submit
    And I click Play Next Song button
    And I click Play button
    Then the Pause button appears