Feature: Bonify Login Feature

Background:
	Given I have started Browser
  When I sign in to Bonify Application

@BonifyApplicationLogin
Scenario: Login to Bonify
Then I redirect to Home Page and Logged out