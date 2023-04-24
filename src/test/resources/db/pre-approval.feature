@DB
Feature: PreApproval feature

  As a mortgage loan applicant, I want my Preapproval details page data to be stored
  in the database, so that I can access it later and the bank can process my mortgage application

  Background: Common steps for all scenarios in PreApproval details page
    Given the user is on the sign-up pageN
    When the user enters valid username password and clicks on the sign-in buttonN
    And the user is redirected to the dashboard pageN
    And clicks mortgage application buttonN
    Then the user is redirected to the PreApproval details page

  @nino @smoke
  Scenario: The Preapproval details page should be stored in tbl_mortagage table in the specific columns
    Given the user is on the PreApproval details page
    When the user enters valid info in PreApproval details page form fields
      |realtor_status  |realtor_info  |loan_officer_status|purpose_loan    |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|src_down_payment                                |add_fund_available|
      |yes               |John Smith    |yes                  |Purchase a Home |560236            |32626       |5                   |527610       |Other type of Down Payment                      |20000             |

    Then the user can see the entered mortgage preApproval details in the following corresponding columns
      |realtor_status  |realtor_info  |loan_officer_status|purpose_loan    |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|src_down_payment                                |add_fund_available|
      |1               |John Smith    |1                  |Purchase a Home |560236            |32626       |5                   |527610       |Other type of Down Payment                      |20000             |


  @nino @smoke
  Scenario Outline: The realtor_status and loan_officer column values should be stored as integer values
    Given the user is on the PreApproval details page
    When the user marks checkboxes related as "<realtor_status_checkbox>" and "<loan_officer_status_checkbox>" sections in PreApproval details page
    Then the user can see in the "<realtor_status>" and "<loan_officer_status>" column values
      Examples:
      | realtor_status_checkbox  |loan_officer_status_checkbox| realtor_status  |loan_officer_status|
      |yes                       |yes                         |1                |  1                 |
      |no                        |no                          |2                |  2                 |

  @nino @nino1
  Scenario: The realtor_info, purpose_loan and src_down_payment column values should be stored as String values - Create and Read
    Given the user is on the PreApproval details page
    When the user enters the following information in the realtor_info, purpose_loan and src_down_payment columns in PreApproval details page
      |realtor_info  |purpose_loan    |src_down_payment|
      |John Smith    |Purchase a Home |Other type of Down Payment |

    Then All entered values should be stored as a String values

  @nino
  Scenario: The est_purchase_price, down_payment, down_payment_percent, total_loan_amount, add_fund_available column values should be stored as integer values - Create and Read
    Given the user is on the PreApproval details page
    When the user enters the following information in the est_purchase_price, down_payment, down_payment_percent, total_loan_amount, add_fund_available columns in PreApproval details page
      |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|add_fund_available|
      |560236            |32626       |5                   |527610           |20000             |
    Then All entered values should be stored as a integer values

  @nino
  Scenario Outline: Verify mapping of the PreApproval details page form fields upon successful submission of the page
    Given the user is on the PreApproval details page
    When the user enters the following data in "<realtor_status>" , "<realtor_info>", "<loan_officer_status>", "<purpose_loan>", "<est_purchase_price>", "<down_payment>", "<down_payment_percent>", "<total_loan_amount>", "<src_down_payment>", "<add_fund_available>" in the PreApproval details page form fields:
    Then the data should be mapped correctly to the following column names "<realtor_status>" , "<realtor_info>", "<loan_officer_status>", "<purpose_loan>", "<est_purchase_price>", "<down_payment>", "<down_payment_percent>", "<total_loan_amount>", "<src_down_payment>", "<add_fund_available>" in the tbl_mortagage table in the database:
    Examples:
      |realtor_status  |realtor_info  |loan_officer_status|purpose_loan    |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|src_down_payment                                |add_fund_available|
      |1               |John Smith    |1                    |Purchase a Home | 560236.00        |32626       |5                   |527610          |Other type of Down Payment                              |20000             |
      |1               |Bill Wallace  |2                    |Purchase a Home |859654            |98654       |11                  |761000           |Equity on Pending Sale (executed sales contract)|10000             |
      |2               |              |1                    |Purchase a Home |693589            |58693       |8                   |634896           |Other type of Down Payment                      |5000              |



  @nino
  Scenario Outline: Verify that realtor info filed is not empty and contains realtor's name in the database if yes was selected on UI
    Given the user is on the PreApproval details page
    When the user marks  Yes in the "<realtor_status_checkbox>" and fills out the "<realtor_info>" field in PreApproval details page
    Then the user can see realtor info in the "<realtor_status>" and "<realtor_info>" column values
    Examples:
      | realtor_status_checkbox  |realtor_info| realtor_status  |
      |yes                       |John Smith  |1                |
      |yes                       |Bill Wallace |1                |


  @nino
  Scenario Outline: Verify that purpose_loan field is not empty and contains valid loan purpose given in the dropdown options
    When  The user selects one of the "<purpose_loan>" options
    Then  The result should not be empty "<purpose_loan>":
    Examples:
      |purpose_loan   |
      |Purchase a Home|
      |Refinance      |
      |Construction|



