#Feature: e-Consent feature
#  As a mortgage loan applicant, I want to consent to do business electronically so that I can receive and sign the necessary disclosures related to my loan application. I need to be able to enter my first and last name and email address,
#  and I want to be able to easily indicate whether or not I agree to the terms and conditions.
#
#
#
#  Background: Common steps for all scenarios in E-Consent page
#    Given User/Applicant is on the sign-in page.
#    When  User/Applicant enters valid username password and clicks on the sign-in input boxes
#    And   User/Applicant moves to the Dashboard page.
#    And   User clicks mortgage application section
#    And   User/Applicant fills out all required fields in previous sections
#    Then  User is redirected to the EConsent Page
#
#
#  Scenario: The user should be required to enter their first and last name and email address in order to proceed
#    Given User/Applicant is on E-Consent page
#    When User/ Applicant is entering valid first name ,last name and email adrress
#    Then The user is able to select Yes or No checkbox
#    And click next to move to the next page
#
#
#  Scenario: The email address field should have basic validation to ensure that it is a valid email address
#    Given The user is on E-Consent page
#    Then The user enters invalid email adress
#    And  There was a "Invalid email adress" message should be pop-upped
#
#  Scenario :The user should be presented with the necessary disclosures related to the loan application clearly
#    Given The user is on E-Consent page
#    Then The user can see clearly see disclosures
#         |Your Consent	        |
#         |Withdrawal Of Consent	|
#         |Obtaining Paper Copies|
#         |System Requirements	|
#         |How We Can Reach You  |
#         |eConsent	            |
#
#  Scenario:The user should be able to read and review the disclosures before agreeing or disagreeing to them
#    Given The user on E-Consent Page on disclosures
#    Then The user click each of disclosures
#          |Your Consent	         |
#          |Withdrawal Of Consent |
#          |Obtaining Paper Copies|
#          |System Requirements	 |
#          |How We Can Reach You  |
#          |eConsent	             |
#
#  Scenario: The page should include two radio buttons, one for "Agree" and one for Don't Agree"
#    Given The User on E-Consent Page
#    Then The user can see "Agree" and "Don't Agree" radio buttons
#
#  Scenario : The "Agree" button should be selected by default.
#    Given The User on E-Consent Page
#    Then The user should see "Agree"button already clicked
#
#  Scenario : When the user select "Don't Agree" button
#    Given The user on E-Consent Page
#    Then The user should not be able to proceed with the application
#
#  Scenario: When the user selects the "Agree"button
#    Given The user on E-Consent Page
#    Then The user on E-Consent Page Then The user should be able to proceed with the application
#
#  Scenario : When the user try to submit without selecting one of radio buttons (Agree and Don't Agree)
#    Given The user on E-Consent Page
#    Then The user should see an error message and should not submit the application w
