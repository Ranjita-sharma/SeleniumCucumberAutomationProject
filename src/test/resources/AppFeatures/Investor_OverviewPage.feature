@UATTesting
Feature: Investor Dashboard Feature

Background:
Given user has already logged into application
  |email|password|
  |tah16@gmail.com|Test@123|

#  Scenario: Investor dashboard page title
#    Given user is on dashboard page
#    When user gets the title of the page
#    Then login page title should be "Lendo"

#  Scenario: Investor dashboard page count
#    Given user is on dashboard page
#    Then user gets Investor dashboard section
#    |Overview|
#    |Invest|
#    |Account Statement|
#    |My Portfolio|
#    |عربى|
#    |Wallet Balance|
#    |Deposit|
#    |Withdraw|
#    |How does Lendo ensure Shari’ah compliance?|
#    |Invest Now                                |
#    |View Portfolio                            |
#    |Avg. ROI                                  |
#    |Total Investment                          |
#    |Total Earned                              |
#    |Expected Total Repayment                  |
#    And Investor dashboard count should be 12
  Scenario: Invest link is available on Investor Dashboard page
    Given user is on dashboard page
    Then user gets the all features are available
    And user click on Invest Now button
#    Then user gets the AVG ROI details

  Scenario: Navigate to Invest page
  Given user is on dashboard page
  And user click on Invest menu link
  Then navigate to Invest page
