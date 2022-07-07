Feature: Login functionality

@PositiveTest, @ParameterizedTest

Scenario: Login
Given User is on login page

When User enters valid username and valid password

|Admin|admin123|

Then User should logs in successfully
