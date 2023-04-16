@AnarDb

Feature: employment and income details should be securely stored in the database, so that user can easily provide and update this information through the
  Employment and Income page of the application


@AnarDb
Scenario: Verify the column names for albums tbl_mortgage
When I send a request to retrieve column names for tbl_mortgage table
Then It should be the following
| employer_name          |
| position               |
| city                   |
| state                  |
| start_date             |
| end_date               |
| current_job            |
| co_employer_name       |
| co_position            |
| co_city                |
| co_state               |
| co_start_date          |
| co_end_date            |
| co_current_job         |
| gross_monthly_income   |
| monthly_overtime       |
| monthly_bonuses        |
| monthly_commissions    |
| monthly_dividends      |
| c_gross_monthly_income |
| c_monthly_overtime     |
| c_monthly_bonuses      |
| c_monthly_commissions  |
| c_monthly_dividends    |
| add_belong             |
| income_source          |
| amount                 |

  @AnarDb
  Scenario: Verify the income_source column content
    When  I send a request to retrieve income_source from tbl_mortgage table
    Then It should contain any of the following
      |  Alimony/Child Support              |
      |  Social Security/Disability Income  |
      |  Unemployment Benefits              |
      |  Interest and Dividends             |
      |  VA Compensation                    |
      |  Royalty Payments                   |
      |  Other Types of Income              |

  @AnarDb
  Scenario: Verify the employer_name column is not empty
    When  I send a request to retrieve employer_name
    Then  The result should not be empty


  @AnarDb
  Scenario: Verify the gross_monthly_income column is not empty
    When  I send a request to retrieve gross_monthly_income
    Then  The result should not display empty


  @AnarDb
  Scenario: Verify data mapping of employment and income page
    Given the user is on employment and income page
    When the user enters the following data in Employment and Income
      | employer_name    | position    | city           | state     | start_date   |gross_monthly_income| monthly_over_time| monthly_bonuses|monthly_commissions| monthly_dividents|
      | CapitalOne       | SDET        | Anaheim        | CA        | 01/10/2009   |8000.65             | 1500.84          | 2200.54        |3500.20            | 5600.50          |


    Then the data should be mapped correctly to the following columns in the table tbl_mortgage
      | employer_name    | position    | city           | state     | start_date   |gross_monthly_income| monthly_over_time| monthly_bonuses|monthly_commissions| monthly_dividents|
      | CapitalOne       | SDET        | Anaheim        | CA        | 01/10/2009   |8000.65             | 1500.84          | 2200.54        |3500.20            | 5600.50          |

