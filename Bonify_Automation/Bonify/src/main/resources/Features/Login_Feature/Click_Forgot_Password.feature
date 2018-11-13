Feature: Forgot Password Feature

Background:
	Given I have started Browser

@ClickForgotPassword
Scenario: Forgot Password
When I Click on Forgot Password Link
Then I redirect to Appropriate Page
