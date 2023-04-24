@DB
Feature: SignUp feature

  @nino2 @smoke
  Scenario: The SignUp page should be stored in tbl_mortagage table in the specific columns
    Given the user is on the SignUp page
    When the user enters valid info in SignUp page form fields
      |first_name  |last_name  |email            |password  |
      |John         |Smith     |jsmith@gmail.com |jsmith@ |
    Then the user can see the entered information in the following corresponding columns
      |first_name  |last_name  |email            |password  |
      |John         |Smith     |jsmith@gmail.com |0678722c17a013a56bc7741552e35beb|

  @nino3
  Scenario: The should ensure that each user has a unique username associated with their account
    Given the user is on the SignUp page
    When I send a request to retrieve duplicate usernames

    Then the result should be empty

  @nino2 @smoke
  Scenario: The database should store and eccrypt user passwords in an MD5 hash
    Given the user is on the SignUp page
    When the user enters valid info in SignUp page form fields and clicks SignUp button
      |first_name  |last_name  |email            |password  |
      |John         |Smith     |jsmith@gmail.com |jsmith@ |
    Then the user password is encrypted with MD5


