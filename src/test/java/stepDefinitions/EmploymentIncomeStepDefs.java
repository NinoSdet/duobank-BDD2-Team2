package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.EmploymentIncomePage;

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
        EmploymentIncomePage employmentIncomePage = new EmploymentIncomePage();
        employmentIncomePage.getCurrentJobEmployerName().sendKeys("Booking.com");
    }

    @When("the user is at STATE dropdown menu in Employment and Income page")
    public void the_user_is_at_state_dropdown_menu_in_employment_and_income_page() {
    }

    @When("the user clicks on STATES dropdown")
    public void the_user_clicks_on_states_dropdown() {
        EmploymentIncomePage employmentIncomePage = new EmploymentIncomePage();
        employmentIncomePage.getStates();
    }

    @Then("the user is able to see the list of {int} states")
    public void the_user_is_able_to_see_the_list_of_states(Integer int1, List<WebElement> dataTable) {
    }

    @When("the user is at EMPLOYER1 tab in Employment and Income page")
    public void the_user_is_at_employer_tab_in_employment_and_income_page() {
    }

    @Then("the user is able to see THIS IS MY CURRENT JOB tab unchecked by default")
    public void the_user_is_able_to_see_this_is_my_current_job_tab_unchecked_by_default() {
    }

    @When("the user is at EMPLOYER1 section in Employment and Income page")
    public void the_user_is_at_employer1_section_in_employment_and_income_page() {
    }

    @Then("the user is able to click on CLEAR option in EMPLOYER1 section")
    public void the_user_is_able_to_click_on_clear_option_in_employer1_section() {
    }

    @Then("the user sees the displayed pop-up warning message")
    public void the_user_sees_the_displayed_pop_up_warning_message() {
    }

    @When("the user is at CLEAR option in EMPLOYER1 section of Employment and Income page")
    public void the_user_is_at_clear_option_in_employer1_section_of_employment_and_income_page() {
    }

    @Then("the user is able to clear the information only in that EMPLOYER1 section")
    public void the_user_is_able_to_clear_the_information_only_in_that_employer1_section() {
    }

    @Given("the user is on the Employment Information section of Employment and Income page")
    public void the_user_is_on_the_employment_information_section_of_employment_and_income_page() {
    }

    @When("the user enters valid employer name as {string} position name as {string} city name as {string}")
    public void the_user_enters_valid_employer_name_as_position_name_as_city_name_as(String string, String string2, String string3) {
    }

    @Then("information is added accordingly under corresponding input field")
    public void information_is_added_accordingly_under_corresponding_input_field() {
    }

    @When("the user is at Borrower Employment Information section of Employment and Income page")
    public void the_user_is_at_borrower_employment_information_section_of_employment_and_income_page() {
    }

    @Then("the user is able to click on ADD ANOTHER EMPLOYER")
    public void the_user_is_able_to_click_on_add_another_employer() {
    }

    @Then("the user is able to see a new section for another employer info")
    public void the_user_is_able_to_see_a_new_section_for_another_employer_info() {
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
    }

    @When("the user is at REMOVE option in EMPLOYER2 section of Employment and Income page")
    public void the_user_is_at_remove_option_in_employer2_section_of_employment_and_income_page() {
    }

    @Then("the user is able to remove the section")
    public void the_user_is_able_to_remove_the_section() {
    }

    @When("the user is at Borrower Gross Monthly Employment Income sectionBorrower Employment Information section")
    public void the_user_is_at_borrower_gross_monthly_employment_income_section_borrower_employment_information_section() {
    }

    @Then("the user can see  GROSS MONTHLY INCOME, MONTHLY OVERTIME, MONTHLY BONUSES, MONTHLY COMMISSIONS, MONTHLY DIVIDENDS\\/INTEREST and Borrower Total Monthly Income")
    public void the_user_can_see_gross_monthly_income_monthly_overtime_monthly_bonuses_monthly_commissions_monthly_dividends_interest_and_borrower_total_monthly_income() {
    }

    @When("the user is at Borrower Gross Monthly Employment Income section")
    public void the_user_is_at_borrower_gross_monthly_employment_income_section() {
    }

    @Then("the user is able to enter only numeric input limited to twelve characters with a maximum of two decimal places in each input field")
    public void the_user_is_able_to_enter_only_numeric_input_limited_to_twelve_characters_with_a_maximum_of_two_decimal_places_in_each_input_field() {
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
    public void the_user_enters_monthly_gross_income_as_monthly_overtime_as_monthly_bonuses_as_monthly_commissions_as_monthly_interests_as(String string, String string2, String string3, String string4, String string5) {
    }

    @Then("information is added accordingly under corresponding input field of Borrower Gross Monthly Employment Income")
    public void information_is_added_accordingly_under_corresponding_input_field_of_borrower_gross_monthly_employment_income() {

    }

    @Given("the user is on the Additional Gross Monthly Income section of Employment and Income page")
    public void the_user_is_on_the_additional_gross_monthly_income_section_of_employment_and_income_page() {
    }

    @When("the user enters additional income {int} as {string} additional income {int} as {string} and additional income {int} as {string}")
    public void the_user_enters_additional_income(Integer int1, String string, Integer int2, String string2, Integer int3, String string3) {
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
    public void the_following_options_should_pop_up_to_choose_from(List<WebElement> dataTable) {
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
