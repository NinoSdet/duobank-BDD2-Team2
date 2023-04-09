Feature: e-Consent feature
  As a mortgage loan applicant, I want to consent to do business electronically so that I can receive and sign the necessary disclosures related to my loan application. I need to be able to enter my first and last name and email address,
  and I want to be able to easily indicate whether or not I agree to the terms and conditions.




  Scenario: User/Applicant can see First Name , Last Name and Email input boxes on Enconsent Page
    Given User/Applicant is on Enconsent page
    When User/ Applicant is entering valid first name ,last name and email adress
    Then the user can select Yes or No checkbox
    And click next to move to the next page


    Scenario: User / Applicant input inval
