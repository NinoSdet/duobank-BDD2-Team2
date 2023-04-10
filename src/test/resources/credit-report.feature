Feature: Credit-Report feature

  As a user applying for a mortgage loan, I want to be able to order a credit report
  through the preapproval inquiry page so that the bank can verify my eligibility for the loan.

  Background: Common steps for all scenarios in Reviewing Application page
    Given the user is on the sign-up pageR
    When the user enters valid username password and clicks on the sign-in buttonR
    And the user is redirected to the dashboard pageR
    And clicks mortgage application button
    And the user fills out all required fields in previous sections
    When the user clicks the credit report button
    Then the user is being redirected to the Credit Report Page

  @Slava
  Scenario: the user gets to the Credit Report Page
    Given the user filled out all the fields
    When the user clicks the credit report button
    Then the user is being redirected to the Credit Report Page

  @Slava
  Scenario: the user is able to go to the previous page after YES is chosen
    When the user chooses YES on the Credit Report Page
    Then the user is being redirected to the verification page

  @Slava
  Scenario: the user is able to go to the previous page after NO is chosen
    When the user chooses NO and clicks on PREVIOUS button on the Credit Report Page
    Then the user is being redirected to the Employment and Income page

  @Slava
  Scenario: the user is able to go to the previous page when NOTHING is chosen
    When the user skips selection and clicks on PREVIOUS button on the Credit Report Page
    Then the user is being redirected to the Employment and Income page

  @Slava
  Scenario: the user is able to go to the next page when YES is chosen
    When the user clicks on NEXT button on the Credit Report Page
    Then the user is being redirected to the eConsent page

  @Slava
  Scenario: the user is able to go to the next page when NO is chosen
    When the user clicks on NEXT button on the Credit Report Page
    Then the user is being redirected to the eConsent page

  @Slava
  Scenario: the user is not able to go to the next page when NOTHING is chosen
    When the user clicks on NEXT button on the Credit Report Page
    Then the user stays on the Credit Report Page page
    And the user gets a warning to make a selection above

