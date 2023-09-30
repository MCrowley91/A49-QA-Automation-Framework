Feature: Login functionality
@Smoke
  Scenario: Login success with correct email and password
    Given I open Login page
    When I enter email "mary.crowley@testpro.io"
    And I enter password "Password"
    And I submit
    Then I am logged in
@Regression
Scenario: Login fails with empty email
 Given I open Login page
 When I enter password "password"
 And I submit
 Then I remain on the login page
 @Regression
 Scenario: Login fails with empty password
 Given I open Login page
 When I enter email "mary.crowley@testpro.io"
 And I submit
 Then I remain on the login page
@Regression
Scenario: Login fails with invalid email
Given I open Login page
When I enter email "mary@gmail.com"
And I enter password "password"
Then I remain on the login page
@Regression
Scenario: Login fails with invalid password
Given I open Login page
When I enter email "mary.crowley@testpro.io"
And I enter password "wrongpassword"
Then I remain on the login page