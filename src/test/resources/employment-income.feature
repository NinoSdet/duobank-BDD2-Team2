Feature: Employment-Income feature

  As a user applying for a mortgage loan, I want to provide my employment and income details to the bank,
  so that they can evaluate my eligibility for a loan.


  Background: Common steps for all scenarios in PreApproval page
    Given the user is on the sign-up page
    When the user enters valid username password and clicks on the sign-in button
    And the user is redirected to the dashboard page
    And clicks mortgage application


  Scenario: User is able to see EMPLOYER NAME, POSITION, CITY, and a dropdown box for STATE, and a date picker for
  START DATE and END DATE under Borrower Employment Information
    When the user is at Borrower Employment Information section
    Then the user can see  EMPLOYER NAME, POSITION, CITY, and a dropdown box for STATE, and a date picker for START DATE and END DATE


  Scenario: User is able to enter information in EMPLOYER NAME input field.
    When the user is at EMPLOYER NAME input field in the Employment and Income page
    Then the user is able to enter Employer Name


  Scenario: User is able to see the STATE dropdown list with all 50 US states
    When the user is at STATE dropdown menu in Employment and Income page
    And the user clicks on STATES dropdown
    Then the user is able to see the list of 50 states
    |   Alabama               |
    |   Alaska                |
    |   Arizona               |
    |   Arkansas              |
    |   California            |
    |   Colorado              |
    |   Connecticut           |
    |   Delaware              |
    |   District Of Columbia  |
    |   Florida               |
    |   Georgia               |
    |   Hawaii                |
    |   Idaho                 |
    |   Illinois              |
    |   Indiana               |
    |   Iowa                  |
    |   Kansas                |
    |   Kentucky              |
    |   Louisiana             |
    |   Maine                 |
    |   Maryland              |
    |   Massachusetts         |
    |   Michigan              |
    |   Minnesota             |
    |   Mississippi           |
    |   Missouri              |
    |   Montana               |
    |   Nebraska              |
    |   Nevada                |
    |   New Hampshire         |
    |   New Jersey            |
    |   New Mexico            |
    |   New York              |
    |   North Carolina        |
    |   North Dakota          |
    |   Ohio                  |
    |   Oklahoma              |
    |   Oregon                |
    |   Pennsylvania          |
    |   Rhode Island          |
    |   South Carolina        |
    |   South Dakota          |
    |   Tennessee             |
    |   Texas                 |
    |   Utah                  |
    |   Vermont               |
    |   Virginia              |
    |   Washington            |
    |   West Virginia         |
    |   Wisconsin             |
    |   Wyoming               |

  Scenario: User is able to see THIS IS MY CURRENT JOB tab unchecked by default
    When the user is at EMPLOYER1 tab in Employment and Income page
    Then the user is able to see THIS IS MY CURRENT JOB tab unchecked by default


  Scenario: User is able to see CLEAR option that displays a warning pop-up about clearing the information
    When the user is at EMPLOYER1 section in Employment and Income page
    Then the user is able to click on CLEAR option in EMPLOYER1 section
    And the user sees the displayed pop-up warning message


  Scenario: User is able to only clear the information in that section, not any other sections when clicking on CLEAR
    When the user is at CLEAR option in EMPLOYER1 section of Employment and Income page
    Then the user is able to clear the information only in that EMPLOYER1 section



  Scenario Outline: User  is able to enter valid information in each field of Employment Information section
    Given the user is on the Employment Information section of Employment and Income page
    When the user enters valid employer name as "<employer>" position name as "<position>" city name as "<city>"
    Then information is added accordingly under corresponding input field

    Examples:
      | employer      | position        |city               |
      | CapitalOne    | SDET            | Dallas            |
      | Booking.Com   | QA engineer     | San Francisco     |
      | JetBlue       | QA engineer     | Orlando           |


  Scenario: User is able to add a new section for another employer info when clicking on ADD ANOTHER EMPLOYER
    When the user is at Borrower Employment Information section of Employment and Income page
    Then the user is able to click on ADD ANOTHER EMPLOYER
    And the user is able to see a new section for another employer info


  Scenario: User is able to see CLEAR option that displays a warning pop-up about clearing the information
    When the user is at EMPLOYER2 section in Employment and Income page
    Then the user is able to click on CLEAR option in EMPLOYER2 section
    And the user sees the displayed pop-up warning message



  Scenario: User is able to only clear the information in that section, not any other sections when clicking on CLEAR
    When the user is at CLEAR option in EMPLOYER2 section of Employment and Income page
    Then the user is able to clear the information only in that EMPLOYER2 section


  Scenario Outline: User  is able to enter valid information in each field of Employment Information section
    Given the user is on the Employment Information section of Employment and Income page
    When the user enters valid employer name as "<employer>" position name as "<position>" city name as "<city>"
    Then information is added accordingly under corresponding input field

    Examples:
      | employer      | position        | city              |
      | Apple         | SDET            | Kansas City       |
      | Tesla         | QA engineer     | San Jose          |
      | SpaceX        | QA engineer     | Baltimore         |


  Scenario: User is able to see CLEAR option that displays a warning pop-up about clearing the information
    When the user is at EMPLOYER2 section in Employment and Income page
    Then the user is able to click on CLEAR option in EMPLOYER2 section
    And the user sees the displayed pop-up warning message


  Scenario: User is able to remove a section using the REMOVE option
    When the user is at REMOVE option in EMPLOYER2 section of Employment and Income page
    Then the user is able to remove the section


  Scenario: User is able to see fields for GROSS MONTHLY INCOME, MONTHLY OVERTIME, MONTHLY BONUSES, MONTHLY COMMISSIONS,
  MONTHLY DIVIDENDS/INTEREST and Borrower Total Monthly Income under Borrower Gross Monthly Employment Income section
  START DATE and END DATE under Borrower Employment Information
    When the user is at Borrower Gross Monthly Employment Income sectionBorrower Employment Information section
    Then the user can see  GROSS MONTHLY INCOME, MONTHLY OVERTIME, MONTHLY BONUSES, MONTHLY COMMISSIONS, MONTHLY DIVIDENDS/INTEREST and Borrower Total Monthly Income


  Scenario: User is able to enter only numeric input limited to twelve characters with a maximum of two decimal places
    When the user is at Borrower Gross Monthly Employment Income section
    Then the user is able to enter only numeric input limited to twelve characters with a maximum of two decimal places in each input field

  Scenario: User should see THIS FIELD IS REQUIRED message when GROSS MONTHLY INCOME input field is left blank
    When the user is at GROSS MONTHLY INCOME input field
    And the user doesnt input any dollar amount
    Then the user is able to see THIS FIELD IS REQUIRED message


  Scenario: User is able to see the automatically calculated amount in the Borrower Total Monthly Income field
    When the user is at Borrower Total Monthly Income field
    Then the user is able to see the automatically calculated amount in the Borrower Total Monthly Income field




  Scenario Outline: User  is able to enter valid information in each field of Borrower Gross Monthly Employment Income
    Given the user is on the Borrower Gross Monthly Employment Income section of Employment and Income page
    When the user enters monthly gross income as "<gross>" monthly overtime as "<overtime>" monthly bonuses as "<bonuses>" monthly commissions as "<commissions>" monthly interests as "<interests>"
    Then information is added accordingly under corresponding input field of Borrower Gross Monthly Employment Income

    Examples:
      | gross         | overtime        | bonuses              | commissions    |  interests        |
      | 8599.60       | 5400.00         | 15000.00             |0.00            | 4865.32           |
      | 7689.55       | 3600.00         | 14500.00             |6549.99         | 3654.89           |
      | 9650.39       | 0.00            | 16000.00             |3569.49         | 4561.89           |


  Scenario Outline: User  is able to enter dollar amount in each field of Additional Gross Monthly Income section
    Given the user is on the Additional Gross Monthly Income section of Employment and Income page
    When the user enters additional income 1 as "<income1>" additional income 2 as "<income2>" and additional income 3 as "<income3>"
    Then information is entered accordingly by each corresponding selection under INCOME SOURCE dropdown menu

    Examples:
      | income1         | income2       | income3  |
      | 350.25          | 2540.50       | 700.00   |
      | 255.69          | 1225.60       | 500.59   |
      | 355.55          | 695.87        | 225.48   |


  Scenario: income source dropdown
    Given the user is at INCOME SOURCE dropdown menu
    When the user clicks on the "INCOME SOURCE" dropdown
    Then the following options should pop up to choose from
      | Alimony/Child Support               |
      | Social Security/Disability Income   |
      | Unemployment Benefits               |
      | Interest and Dividends              |
      | VA Compensation                     |
      | Royalty Payments                    |
      | Other Types of Income               |


  Scenario: User should be able to navigate to other sections using the PREVIOUS and NEXT buttons
    When the user is at Employment and Income Page
    Then the user is able to navigate to other sections using the PREVIOUS and NEXT buttons


  Scenario: User should be able to go to previous section when clicking on PREVIOUS button
    When the user is at Employment and Income Page
    And the user clicks on PREVIOUS button
    Then the user is able to go to previous section

  Scenario: User should be able to go to next section only if all required fields are filled in
    When the user is at Employment and Income Page
    And the user fills out all required fields
    Then the user is able to go to next section

  Scenario: User should see an error message indicating the fields to be filled in when all required fields are not completed
    When the user is at Employment and Income Page
    And the user does not fill all required fields
    Then the user is not able to go to next section and error message indicates which fields must be filled in






