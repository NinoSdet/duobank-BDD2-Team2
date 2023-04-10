Feature: e-Consent feature
  As a mortgage loan applicant, I want to consent to do business electronically so that I can receive and sign the necessary disclosures related to my loan application. I need to be able to enter my first and last name and email address,
  and I want to be able to easily indicate whether or not I agree to the terms and conditions.



  Background: Common steps for all scenarios in E-Consent page
    Given User is on the sign-in page.
    When  User enters valid username password and clicks on the sign-in input boxes
    And   User moves to the Dashboard page.
    And   User clicks mortgage application section
    And   User fills out all required fields in previous sections
    Then  User is redirected to the EConsent Page

  @eConsentPage
  Scenario: The user should be required to enter their first and last name and email address in order to proceed
    Given User is on E-Consent page
    When User enters valid first name "John" ,last name "Doe" and email address johndoe@examples.com
    Then The user is able to select Agree or Don't Agree checkbox
    And User clicks next to move to the next page

  @eConsentPage
  Scenario: The email address field should have basic validation to ensure that it is a valid email address
    Given The user is on E-Consent page
    Then The user enters invalid email address "invalid_email"
    And  There was an invalid email address message should be displayed

  @eConsentPage
  Scenario: The user should be presented with the necessary disclosures related to the loan application clearly
    When The user is on E-Consent page
    Then The user can see clearly see disclosures : Your Consent, Withdrawal Of Consent, Obtaining Paper Copies, System Requirements, How We Can Reach You, eConsent

  @eConsentPage
  Scenario: The user should be able to read and review the disclosures before agreeing or disagreeing to them
    When The user on E-Consent Page on disclosures
    Then The user click each of disclosures : Your Consent, Withdrawal Of Consent, Obtaining Paper Copies, System Requirements, How We Can Reach You

  @eConsentPage
  Scenario: The page should include two radio buttons, one for "Agree" and one for "Don't Agree"
    When The User on E-Consent Page
    Then The user can see Agree and Don't Agree radio buttons

  @eConsentPage
  Scenario: The "Agree" button should be selected by default.
    When The User on E-Consent Page
    Then The user should see Agree button already clicked

  @eConsentPage
  Scenario: When the user selects "Don't Agree" button
    When The user on E-Consent Page
    Then The user should not be able to proceed with the application

  @eConsentPage
  Scenario: When the user selects the "Agree" button
    When The user on E-Consent Page
    Then The user should be able to proceed with the application

  @eConsentPage
  Scenario: When the user tries to submit without selecting one of the radio buttons "Agree" and "Don't Agree"
    When The user on E-Consent Page
    Then The user should see an error message and should not submit the application.
