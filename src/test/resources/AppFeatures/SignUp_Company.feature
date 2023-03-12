Feature: Registration flow feature

Scenario: Create a new investor account
Given user is on login page and do the registration
When user get the link Don't have an account?
Then Click on Don't have an account? link
And verify all the Elements visible on Registration Page
#And verify when user click on link "Already have an account?"
#Then Click on Don't have an account? link
Then user click on Company icon
And click on Sign up button
And user get the first question text "Do you have a company registered in Saudi Arabia?" on second step of Registration
Then user click on Yes button of first question
And user get the Second question text "Do you generate SR 3M or more annually in revenue?" on second step of Registration
Then user click on Yes button of Second question
And user get the Third question text "Has your company been operating for more than 1 year?" on second step of Registration
Then user click on Yes button of Third question
And user click on Next button on second step of Registration
And user enter an email
And user enter a password
And user enter a repeatPassword
And user get the RegistrationStepSecondOfFourthText
Then user click on Next button on third step of Registration
And user enter the First Name as "Ranjeeta"
And user enter the Last Name  as "Sharma"
And user enter the Job Title as "Lead"
And user enter the mobile number as "534221248"
And user click on Next button on fourth step of Registration
And user get the RegistrationStepThirdOfFourthText
And user get the Saudi and Residents icons with links
Then user click on Resident icon
Then user select the Nationality as India
Then user enter the IqamaId
And user enter the mobile number
And user get the entered mobile number text as "Enter the mobile number that's registered under Your national / Iqama number"
And user get the terms and condition text as "By clicking “Submit” below, you agree to Lendo Terms and Conditions"
And user click on Terms and Condition link "Terms and Conditions"
And user click on Continue button
Then user click on Submit button
Then user get the text as "Please confirm the below entered mobile number belongs to your National/Iqama number"
Then user get the mobile number text as "+966530221248"
And user get the Edit and Confirm buttons on popup
Then user click on Confirm button
And user get the RegistrationStepFourthOfFourthText
And user get the SMScode text as "Enter SMS code in the field below" and enter the OTP
Then user click on Next button on Step fourth
And user verify the email
Then user get the verification text on dashboard as "You need to verify your account before investing in the opportunities offered."
And user verify the start button and click on it
And user select the DOB as "04-04-1991"
Then user click on Next button on Verification first step
And user get the Verification StepSecondOfSix
Then user enter the Absher OTP as 760693
Then user click on Next button on Verification second step
#And user get the Verification StepThirdOfSix
#And user get the Primary National Address heading text as "Primary National Address"
Then user click on Next button on Verification third step
#And user get the Verification StepFourthOfSix
And user select the AnnualIncome
And user select the Source of Income
#And user get the tooltip text when mouse hover on Estimated Annual Deposit
And user select the Estimated Annual Deposit
#And user mouse hover on tooltip of Estimated Annual Investment
And user select the Estimated Annual Investment
Then user click on Next button on Verification fourth step
And user select the Job title
And user select the Employment Status
And user enter the Company Name
And user select the Nature of Business
And user click on Next button on fifth step of Verification
And user get the Verification StepSixOfSix
And user select the question first as No
And user select the question second as No
And user select the question third as No
And user select the question fourth as No
Then user click on Finish button
And user click on Continue button after successful verification
And user get the contract accept banner on dashboard
Then user click on Read and accept link
And user accept the contract
And user get the under review banner text as "Your account is under review. No transactions can be made currently. Please check again in a few days."





