@UATTesting
Feature: Login Page feature

# // Background:
#    Given user is on login page
#  Scenario: Login Page title
#    Given user is on login page
#    When user gets the title of the page
#    Then login page title should be "Lendo"
#
#  Scenario: I forgot my password link
#    Given user is on login page
#    Then  I forgot my password link should be displayed
#
#  Scenario: Don't have an account? Link
#    Given  user is on login page
#    Then Don't have an account? link should be displayed

   Scenario: Login with Valid credentials
    Given user is on login page
    When user gets the title of the page
    Then login page title should be "Lendo"
    Then  I forgot my password link should be displayed
    Then Don't have an account? link should be displayed
    When user enters email "tah16@gmail.com"
    And user enters password "Test@123"
    And user clicks on Continue button
    Then enter the OTP as 1111
    And user click on Verify button
    And deposit button label should be displayed as "Deposit"

