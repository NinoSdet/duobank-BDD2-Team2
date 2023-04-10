package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.EmploymentIncomePage;
import utils.SeleniumUtils;

import java.util.List;

public class EmploymentIncomeStepDefs {


    @Given("the user is on the sign-up page")
    public void the_user_is_on_the_sign_up_page() {
    }

    @When("the user enters valid username password and clicks on the sign-in button")
    public void the_user_enters_valid_username_password_and_clicks_on_the_sign_in_button() {
    }

    @When("the user is redirected to the dashboard page")
    public void the_user_is_redirected_to_the_dashboard_page() {
    }

    @When("clicks mortgage application")
    public void clicks_mortgage_application() {

    }

    @And("the user goes through the first three steps of application")
    public void theUserGoesThroughTheFirstThreeStepsOfApplication() {
        EmploymentIncomePage employmentIncomePage = new EmploymentIncomePage();
        employmentIncomePage.stepsTillEmploymentAndIncome();
    }
    @Then("the user is redirected to Employment and Income Page")
    public void theUserIsRedirectedToEmploymentAndIncomePage() {
    }


    @When("the user is at Borrower Employment Information section")
    public void the_user_is_at_borrower_employment_information_section() {

    }

    @Then("the user can see  EMPLOYER NAME, POSITION, CITY, and a dropdown box for STATE, and a date picker for START DATE and END DATE")
    public void the_user_can_see_employer_name_position_city_and_a_dropdown_box_for_state_and_a_date_picker_for_start_date_and_end_date() {
    }

    @When("the user is at EMPLOYER NAME input field in the Employment and Income page")
    public void the_user_is_at_employer_name_input_field_in_the_employment_and_income_page() {
    }

    @Then("the user is able to enter Employer Name")
    public void the_user_is_able_to_enter_employer_name() {

    }

    @When("the user is at States dropdown menu in Employment and Income page")
    public void the_user_is_at_STATES_dropdown_menu_in_employment_and_income_page() {

    }
    @And("the user clicks on {string} dropdown")
    public void theUserClicksOnDropdown(String states) {

    }
    @Then("the user is able to see the list of states")
    public void the_user_is_able_to_see_the_list_of_states(List<String> expectedListOfStates) {
        EmploymentIncomePage employmentIncomePage= new EmploymentIncomePage();
        Assert.assertEquals(expectedListOfStates, new EmploymentIncomePage().getStatesAsList());


    }


    @When("the user is at EMPLOYER1 tab in Employment and Income page")
    public void the_user_is_at_employer_tab_in_employment_and_income_page() {
    }

    @Then("the user is able to see THIS IS MY CURRENT JOB tab unchecked by default")
    public void the_user_is_able_to_see_this_is_my_current_job_tab_unchecked_by_default() {
    }

    @When("the user is at EMPLOYER1 section in Employment and Income page")
    public void the_user_is_at_employer1_section_in_employment_and_income_page() {
        new EmploymentIncomePage().clickOnEmployer1tab();
    }

    @Then("the user is able to click on CLEAR option in EMPLOYER1 section")
    public void the_user_is_able_to_click_on_clear_option_in_employer1_section() {
        new EmploymentIncomePage().clickOnClearButton1();
    }

    @Then("the user sees the displayed pop-up warning message")
    public void the_user_sees_the_displayed_pop_up_warning_message() {
        EmploymentIncomePage employmentIncomePage= new EmploymentIncomePage();
        Assert.assertEquals("This action will clear the form, would you like to continue?", employmentIncomePage.getWarningMessageBlock().getText());
    }

    @When("the user is at CLEAR option in EMPLOYER1 section of Employment and Income page")
    public void the_user_is_at_clear_option_in_employer1_section_of_employment_and_income_page() {
    }

    @Then("the user is able to clear the information only in that EMPLOYER1 section")
    public void the_user_is_able_to_clear_the_information_only_in_that_employer1_section() {
        new EmploymentIncomePage().clickOnClearButton1();
        new EmploymentIncomePage().clickCancelOnWarningMessage();
    }

//    @Given("the user is on the Employment Information section of Employment and Income page")
//    public void the_user_is_on_the_employment_information_section_of_employment_and_income_page() {
//    }

    @When("the user enters valid employer name as {string} position name as {string} city name as {string}")
    public void the_user_enters_valid_employer_name_position_name_city_name(String employer1, String position1, String city1) {
        new EmploymentIncomePage().employerInfo1(employer1, position1, city1);
    }

    @Then("information is added accordingly under corresponding input field")
    public void information_is_added_accordingly_under_corresponding_input_field() {
    }

    @When("the user is at Borrower Employment Information section of Employment and Income page")
    public void the_user_is_at_borrower_employment_information_section_of_employment_and_income_page() {
        EmploymentIncomePage employmentIncomePage= new EmploymentIncomePage();
        Assert.assertEquals("Borrower Gross Monthly Employment Income", employmentIncomePage.getBorrowerGrossMonthlyEmploymentIncomeSection().getText());
    }

    @Then("the user is able to click on ADD ANOTHER EMPLOYER")
    public void the_user_is_able_to_click_on_add_another_employer() {
        new EmploymentIncomePage().addAnotherEmployerButton();
    }

    @Then("the user is able to see a new section for another employer info")
    public void the_user_is_able_to_see_a_new_section_for_another_employer_info() {
    }
    @Given("the user is on the Employment Information section of Employment and Income page")
    public void the_user_is_on_the_employment2_information_section_of_employment_and_income_page() {
    }

    @When("the user enters valid employer2 name as {string} position name as {string} city name as {string}")
    public void the_user_enters_valid_employer2_name_position2_name_city2_name(String employer2, String position2, String city2) {
        new EmploymentIncomePage().employerInfo2(employer2, position2, city2);
       new EmploymentIncomePage().selectStateFromDropdown();
       new EmploymentIncomePage().job1Dates();
       new EmploymentIncomePage().selectStateFromDropdown();
    }

    @Then("information2 is added accordingly under corresponding input field")
    public void information2_is_added_accordingly_under_corresponding_input_field() {
    }

    @When("the user is at EMPLOYER2 section in Employment and Income page")
    public void the_user_is_at_employer2_section_in_employment_and_income_page() {
    }

    @Then("the user is able to click on CLEAR option in EMPLOYER2 section")
    public void the_user_is_able_to_click_on_clear_option_in_employer2_section() {
    }

    @When("the user is at CLEAR option in EMPLOYER2 section of Employment and Income page")
    public void the_user_is_at_clear_option_in_employer2_section_of_employment_and_income_page() {
    }

    @Then("the user is able to clear the information only in that EMPLOYER2 section")
    public void the_user_is_able_to_clear_the_information_only_in_that_employer2_section() {
        new EmploymentIncomePage().clickOnClearButton1();
        new EmploymentIncomePage().clickCancelOnWarningMessage();
    }

    @When("the user is at REMOVE option in EMPLOYER2 section of Employment and Income page")
    public void the_user_is_at_remove_option_in_employer2_section_of_employment_and_income_page() {
    }

    @Then("the user is able to remove the section")
    public void the_user_is_able_to_remove_the_section() {
        new EmploymentIncomePage().clickOnRemoveButton2();
        new EmploymentIncomePage().clickCancelOnWarningMessage();
    }

    @When("the user is on Borrower Gross Monthly Employment Income section")
    public void the_user_is_at_borrower_gross_monthly_employment_income_section_borrower_employment_information_section() {
        EmploymentIncomePage employmentIncomePage= new EmploymentIncomePage();
        Assert.assertEquals(employmentIncomePage.getBorrowerGrossMonthlyEmploymentIncomeSection().getText(), "Borrower Gross Monthly Employment Income");
    }



    @Then("the user can see GROSS MONTHLY INCOME, MONTHLY OVERTIME, MONTHLY BONUSES, MONTHLY COMMISSIONS, MONTHLY INTEREST and Borrower Total Monthly Income")
    public void theUserCanSeeGROSSMONTHLYINCOMEMONTHLYOVERTIMEMONTHLYBONUSESMONTHLYCOMMISSIONSMONTHLYINTERESTAndBorrowerTotalMonthlyIncome() {
        EmploymentIncomePage employmentIncomePage= new EmploymentIncomePage();
        Assert.assertEquals("Gross Monthly Income", employmentIncomePage.getGrossMonthlyIncome().getText());
        Assert.assertEquals("Monthly Overtime", employmentIncomePage.getMonthlyOvertime().getText());
        Assert.assertEquals("Monthly Bonuses", employmentIncomePage.getMonthlyBonuses().getText());
        Assert.assertEquals("Monthly Commissions", employmentIncomePage.getMonthlyCommission().getText());
        Assert.assertEquals("Monthly Dividents/Interest", employmentIncomePage.getMonthlyDividents().getText());
    }

    @When("the user is at Borrower Gross Monthly Employment Income section")
    public void the_user_is_at_borrower_gross_monthly_employment_income_section() {
    }

    @Then("the user is able to enter only numeric input limited to twelve characters with a maximum of two decimal places in each input field")
    public void the_user_is_able_to_enter_only_numeric_input_limited_to_twelve_characters_with_a_maximum_of_two_decimal_places_in_each_input_field() {
        EmploymentIncomePage employmentIncomePage= new EmploymentIncomePage();
        employmentIncomePage.getGrossMonthlyIncome().sendKeys("123654789654123.25");
        Assert.assertEquals("PLEASE ENTER A VALUE LESS THAN OR EQUAL TO 999999999999.99.", employmentIncomePage.getGrossMontlyIncomeErrorMessage().getText());
    }

    @When("the user is at GROSS MONTHLY INCOME input field")
    public void the_user_is_at_gross_monthly_income_input_field() {
    }

    @When("the user doesnt input any dollar amount")
    public void the_user_doesnt_input_any_dollar_amount() {
    }

    @Then("the user is able to see THIS FIELD IS REQUIRED message")
    public void the_user_is_able_to_see_this_field_is_required_message() {
    }

    @When("the user is at Borrower Total Monthly Income field")
    public void the_user_is_at_borrower_total_monthly_income_field() {
    }

    @Then("the user is able to see the automatically calculated amount in the Borrower Total Monthly Income field")
    public void the_user_is_able_to_see_the_automatically_calculated_amount_in_the_borrower_total_monthly_income_field() {
    }

    @Given("the user is on the Borrower Gross Monthly Employment Income section of Employment and Income page")
    public void the_user_is_on_the_borrower_gross_monthly_employment_income_section_of_employment_and_income_page() {
    }

    @When("the user enters monthly gross income as {string} monthly overtime as {string} monthly bonuses as {string} monthly commissions as {string} monthly interests as {string}")
    public void the_user_enters_monthly_gross_income_as_monthly_overtime_as_monthly_bonuses_as_monthly_commissions_as_monthly_interests_as(String gross, String overtime, String bonuses, String commissions, String interests) {
        new EmploymentIncomePage().mainIncome(gross, overtime, bonuses, commissions, interests);
    }

    @Then("information is added accordingly under corresponding input field of Borrower Gross Monthly Employment Income")
    public void information_is_added_accordingly_under_corresponding_input_field_of_borrower_gross_monthly_employment_income() {

    }

    @Given("the user is on the Additional Gross Monthly Income section under Employment and Income page")
    public void the_user_is_on_the_additional_gross_monthly_income_section_of_employment_and_income_page() {
    }

    @When("the user enters additional income1 as {string} additional income2 as {string} and additional income3 as {string}")
    public void the_user_enters_additional_income(String income1, String income2, String income3) {
        new EmploymentIncomePage().additionalIncome(income1, income2, income3);
    }

    @Then("information is entered accordingly by each corresponding selection under INCOME SOURCE dropdown menu")
    public void information_is_entered_accordingly_by_each_corresponding_selection_under_income_source_dropdown_menu() {
    }

    @Given("the user is at INCOME SOURCE dropdown menu")
    public void the_user_is_at_income_source_dropdown_menu() {
    }

    @When("the user clicks on the {string} dropdown")
    public void the_user_clicks_on_the_dropdown(String string) {
    }

    @Then("the following options should pop up to choose from")
    public void the_following_options_should_pop_up_to_choose_from(List<String> incomeSource) {
        EmploymentIncomePage employmentIncomePage= new EmploymentIncomePage();

    }

    @When("the user is at Employment and Income Page")
    public void the_user_is_at_employment_and_income_page() {
    }

    @Then("the user is able to navigate to other sections using the PREVIOUS and NEXT buttons")
    public void the_user_is_able_to_navigate_to_other_sections_using_the_previous_and_next_buttons() {
    }

    @When("the user clicks on PREVIOUS button")
    public void the_user_clicks_on_previous_button() {
    }

    @Then("the user is able to go to previous section")
    public void the_user_is_able_to_go_to_previous_section() {
    }

    @When("the user fills out all required fields")
    public void the_user_fills_out_all_required_fields() {
    }

    @Then("the user is able to go to next section")
    public void the_user_is_able_to_go_to_next_section() {
    }

    @When("the user does not fill all required fields")
    public void the_user_does_not_fill_all_required_fields() {
    }

    @Then("the user is not able to go to next section and error message indicates which fields must be filled in")
    public void the_user_is_not_able_to_go_to_next_section_and_error_message_indicates_which_fields_must_be_filled_in() {
    }



}
