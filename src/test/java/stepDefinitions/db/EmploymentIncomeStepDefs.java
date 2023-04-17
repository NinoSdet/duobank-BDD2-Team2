package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.EmploymentIncomePage;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EmploymentIncomeStepDefs {

    List<String> actualMortgageTableColumnNames;

    @When("I send a request to retrieve column names for tbl_mortgage table")
    public void i_send_a_request_to_retrieve_column_names_for_tbl_mortgage_table() {
        actualMortgageTableColumnNames = DBUtils.getColumnNames("SELECT * from tbl_mortagage");


    }

    @Then("It should be the following")
    public void it_should_be_the_following(List<String> expectedMortgageTableColumnNames) {
        Collections.sort(actualMortgageTableColumnNames);
        List <String> expected = new ArrayList<>(expectedMortgageTableColumnNames);
        Collections.sort(expected);
        System.out.println(expected);
        System.out.println(actualMortgageTableColumnNames);
        Assert.assertTrue(actualMortgageTableColumnNames.containsAll(expected));

    }

    List<String> incomeSourceList;

    @When("I send a request to retrieve income_source from tbl_mortgage table")
    public void i_send_a_request_to_retrieve_income_source_from_tbl_mortgage_table() {
        incomeSourceList = DBUtils.getSingleColumnValues("gross_monthly_income", "tbl_mortagage");

    }

    @Then("It should contain any of the following")
    public void it_should_contain_any_of_the_following(List<String> expectedIncomeSourceList) {

    }

    List<String> employerNameList;
    @When("I send a request to retrieve employer_name")
    public void i_send_a_request_to_retrieve_employer_name() {
        employerNameList = DBUtils.getSingleColumnValues("employer_name", "tbl_mortagage");

        }

    @Then("The result should not be empty")
    public void the_result_should_not_be_empty() {

        Assert.assertFalse(employerNameList.contains(null));
    }

    List <String> grossMonthlyIncomeList;
    @When("I send a request to retrieve gross_monthly_income")
    public void i_send_a_request_to_retrieve_gross_monthly_income() {
        grossMonthlyIncomeList = DBUtils.getSingleColumnValues("gross_monthly_income", "tbl_mortagage");
    }

    @Then("The result should not display empty")
    public void the_result_should_not_display_empty() {

        Assert.assertFalse(grossMonthlyIncomeList.contains(null));
    }


    @Given("the user is on employment and income page")
    public void the_user_is_on_employment_and_income_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters the following data in Employment and Income")
    public void the_user_enters_the_following_data_in_employment_and_income(List<Map<String,String>> dataTable) {
        new EmploymentIncomePage().stepsTillEmploymentAndIncome();

        Map<String, String> data = dataTable.get(0);
        new EmploymentIncomePage().fillEmploymentAndIncomeWithData(
        data.get("employer_name"),
        data.get("position"),
        data.get("city"),
        data.get("state"),
        data.get("start_date"),
        data.get("gross_monthly_income"),
        data.get("monthly_over_time"),
        data.get("monthly_bonuses"),
        data.get("monthly_commissions"),
        data.get("monthly_dividents")
                );
        new EmploymentIncomePage().clickOnNextButton();

    }

    @Then("the data should be mapped correctly to the following columns in the table tbl_mortgage")
    public void the_data_should_be_mapped_correctly_to_the_following_columns_in_the_table_tbl_mortgage(List<Map<String,String>> dataTable) throws SQLException {

        String expectedId =null;
        try{
            expectedId= dataTable.get(0).get("id");
            String expectedEmployer = dataTable.get(0).get("employer_name");
            String expectedPosition = dataTable.get(0).get("position");
            String expectedCity = dataTable.get(0).get("city");
            String expectedState = dataTable.get(0).get("state");
            String expectedStartDate = dataTable.get(0).get("start_date");
            String expectedGrossMonthlyIncome = dataTable.get(0).get("gross_monthly_income");
            String expectedMonthlyOvertime = dataTable.get(0).get("monthly_over_time");
            String expectedMonthlyBonuses = dataTable.get(0).get("monthly_bonuses");
            String expectedMonthlyCommissions = dataTable.get(0).get("monthly_commissions");
            String expectedMonthlyDividents = dataTable.get(0).get("monthly_dividents");

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * from tbl_mortagage where id='" + expectedId + "'");

            String actualId= (String)(actual.get(0).get("id"));
            String  actualEmployer = (String) (actual.get(0).get("employer_name"));
            String  actualPosition = (String)(actual.get(0).get("position"));
            String  actualCity = (String)(actual.get(0).get("city"));
            String  actualState = (String)(actual.get(0).get("state"));
            String actualStartDate = dataTable.get(0).get("start_date");
            String actualGrossMonthlyIncome = dataTable.get(0).get("gross_monthly_income");
            String actualMonthlyOvertime = dataTable.get(0).get("monthly_over_time");
            String actualMonthlyBonuses = dataTable.get(0).get("monthly_bonuses");
            String actualMonthlyCommissions = dataTable.get(0).get("monthly_commissions");
            String actualMonthlyDividents = dataTable.get(0).get("monthly_dividents");

            SoftAssertions softAssertions = new SoftAssertions();

            softAssertions.assertThat(actualId).isEqualTo(expectedId);
            softAssertions.assertThat(actualEmployer).isEqualTo(expectedEmployer);
            softAssertions.assertThat(actualPosition).isEqualTo(expectedPosition);
            softAssertions.assertThat(actualCity).isEqualTo(expectedCity);
            softAssertions.assertThat(actualState).isEqualTo(expectedState);
            softAssertions.assertThat(actualStartDate).isEqualTo(expectedStartDate);
            softAssertions.assertThat(actualGrossMonthlyIncome).isEqualTo(expectedGrossMonthlyIncome);
            softAssertions.assertThat(actualMonthlyOvertime).isEqualTo(expectedMonthlyOvertime);
            softAssertions.assertThat(actualMonthlyBonuses).isEqualTo(expectedMonthlyBonuses);
            softAssertions.assertThat(actualMonthlyCommissions).isEqualTo(expectedMonthlyCommissions);
            softAssertions.assertThat(actualMonthlyDividents).isEqualTo(expectedMonthlyDividents);

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where username='"+expectedId+"'");
        }
    }



}