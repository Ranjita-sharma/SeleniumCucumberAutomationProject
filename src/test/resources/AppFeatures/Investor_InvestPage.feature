
Feature: Verify Invest page
  Background:
    Given user has already logged into application and verify Invest Link
      |email|password|
      |tah16@gmail.com|Test@123|

  Scenario: Redirect to Invest page and Click on Invest setting button
    When click on Invest menu link
    Then user is on Invest page and verify that page heading text should be as "Auto Investment"
    And user click on ViewSetting button
    #And user redirect on setting page and verify the page heading text should be as "Auto Invest"
    Then verify the success fees percentage text should be displayed as "Lendo charges 30% success fee on profits made through auto invest."
    And user click on toggle to activate the Auto invest feature
    Then verify the alert popup text as "Are you sure you want to change auto-invest settings?" with "Yes" and "Cancel" buttons
    And user click on Cancel button
    Then user should be on same page without any changes
    And user click again on toggle to activate the Auto invest feature
    And user click on Yes button
    Then verify the alert popup text as "Auto Invest Updated Successfully" with OK button
    And user click on Ok button
    Then popup should be gone and Auto invest feature should be activated
    And user gets the Strategy text "Select a strategy"
    And verify each strategy text and their information
    And user gets the Max Invest text as "Maximum Investment Per Loan"
    And user gets the Loan duration text as "Loan Duration"
    And verify the functionality of Min & Max Investment per loan field
    Then user gets the questions heading text as "You Might Want to Know"
    And verify the first Auto Invest questions as "What is Auto-Invest?"
    Then click on arrow to expand the view and verify the first answer
    And verify the second Auto Invest questions as "Can I use different ways of investing at the same time?"
    Then click on arrow to expand the view and verify the second answer
    And verify the third Auto Invest questions as "Can I turn off auto-invest feature ?"
    Then click on arrow to expand the view and verify the third answer

#    Scenario: Click on Invest setting button

#  Scenario: Activate the Auto-invest toggle feature
#    And user click on toggle to activate the Auto invest feature
#    Then verify the alert popup with "Yes" and "Cancel" buttons
#    And user click on Cancel button
#    Then user should be on same page without any changes
#    And user click on Yes button
#    Then verify the alert popup text as "Auto Invest Updated Successfully" with OK button
#    And user click on Ok button
#    Then popup should be gone and Auto invest feature should be activated
#
#  Scenario: Deactivate the Auto-invest toggle feature
#    Given user is on Invest setting page
#    When user click on toggle to deactivate the Auto invest feature
#    Then verify the alert popup with "Yes" and "Cancel" buttons
#    And user click on Cancel button
#    Then user should be on same page without any changes
#    And user click on Yes button
#    Then verify the alert popup text as "Auto Invest Updated Successfully" with OK button
#    And user click on Ok button
#    Then popup should be gone and Auto invest feature should be activated
#
#  Scenario: Verify the "Select a strategy" section
#    Given user is on Invest setting page
#    When user gets the text "Select a strategy"
#    And verify all the visible strategies
#    And Select any Strategy
#    Then verify the visible text for each strategy selection
#
#  Scenario: Verify the "Expected Risk Score Diversification" for each strategy
#    Given user is on Invest setting page
#    When user selects the strategy as "Moderate"
#    Then verify the "Expected Risk Score Diversification" for Moderate strategy
#    And user selects the strategy as "Conservative"
#    Then verify the "Expected Risk Score Diversification" for Conservative strategy
#    And user selects the strategy as "Aggresive"
#    Then verify the "Expected Risk Score Diversification" for Aggresive strategy
#    And user selects the strategy as "Custom"
#    Then verify the "Expected Risk Score Diversification" for Custom strategy
#
#  Scenario: Verify the visibility of Maximum Investment Per Loan
#     Given user is on Invest setting page
#     When user gets the text as "Maximum Investment Per Loan"
#     And user gets the text as "Loan Duration"
#    And  verify the functionality of Min Investment per loan field
#    And verify the functionality of Max Investment per loan field
#    Then click on Save button
#
#  Scenario: Verify the alert popup of loan duration when user enters the Min and Max values equals
#    Given user is on Invest setting page
#    When user enters 10 value in both Min investment and Max investment field
#    And click on Save button
#    Then alert popup should be displayed as "Min loan duration cannot be equal to Max loan duration"
#
#  Scenario: Verify the alert popup when user left the Min and Max loan duration field as blank
#    Given user is on Invest Setting page
#    When user left the Min loan duration field as blank and click on Save button
#    Then verify the alert popup text
#    And click on Ok button
#    When user left the Max loan duration field as blank and click on Save button
#    Then verify the alert popup text
#    And click on ok button
#
#  Scenario:Verify the section "You Might Want to Know"
#    Given user is on Invest Setting page
#    When user gets the heading text as "You Might Want to Know"
#    Then verify the first Auto Invest questions as "What is Auto-Invest?"
#    And click on arrow to expand the view to see the answer
#    Then verify the answer text
#    Then verify the second Auto Invest questions as "Can I use different ways of investing at the same time?"
#    And click on arrow to expand the view to see the answer
#    Then verify the answer text
#    Then verify the third Auto Invest questions as "Can I turn off auto-invest feature ?"
#    And click on arrow to expand the view to see the answer
#    Then verify the answer text
