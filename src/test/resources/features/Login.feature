Feature: Login feature

Scenario: Login success
  Given I open Login page
  When I enter email "mary.crowley@testpro.io"
  And I enter password "Password"
  And I submit
  Then I am logged in