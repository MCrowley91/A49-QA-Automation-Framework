Feature: Play Song feature
@Regression
  Scenario: Play Song success
    Given I open Login page
    When I enter email "mary.crowley@testpro.io"
    And I enter password "Password"
    And I submit
    And I click Play Next Song button
    And I click Play button
    Then the Pause button appears