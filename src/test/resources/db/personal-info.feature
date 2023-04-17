@DB
Feature: Storing Personal Information in Duobank Mortgage Application



  Background: Common steps for all scenarios in Personal details pageD
    Given the user is on the sign-up pageD
    When the user enters valid username password and clicks on the sign-in buttonD
    And the user is redirected to the dashboard pageD
    And clicks mortgage application buttonD
    Then the user is redirected to the Personal details pageD
  @DaniaDb
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    When I enter the borrower's information:
      | First Name | Middle Name | Last Name | Suffix | Email | Date of Birth | SSN | Marital Status | Cell | Home |
      | John       | M            | Doe       | Jr.     | john.doe@email.com | 01/01/1980 | 123-45-6789 | Single | 1234567890 | 9876543210 |
#    And I select "Yes" for co-borrower question
#    And I enter the co-borrower's information:
#      | First Name | Middle Name | Last Name | Suffix | Email | Date of Birth | SSN | Marital Status | Cell | Home |
#      | Jane       | A            | Smith     | Mrs    | jane.smith@email.com | 02/02/1990 | 987-65-4321 | Married | 9876543210 | 1234567890 |
#    And I submit the form
    Then the borrower's information should be stored in the tbl_mortagage table in the database
      | b_firstName | b_middleName | b_lastName | b_suffix | b_email | b_dob | b_ssn | b_marital | b_cell | b_home |
      | John       | M            | Doe       | Jr.     | john.doe@email.com | 1980-01-01 | 123-45-6789 | Single | 123-456-7890 | 987-654-3210 |
