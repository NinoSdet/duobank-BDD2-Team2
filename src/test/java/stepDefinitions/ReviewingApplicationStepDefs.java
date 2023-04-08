package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ReviewingApplicationPage;

import java.util.List;

public class ReviewingApplicationStepDefs {

    @Given("the user is on the sign-up page")
    public void the_user_is_on_the_sign_up_page() {

    }
    @When("the user enters valid username password and clicks on the sign-in button")
    public void the_user_enters_valid_username_password_and_clicks_on_the_sign_in_button() {
        ReviewingApplicationPage reviewingApplicationPage = new ReviewingApplicationPage();
        reviewingApplicationPage.signIn();
        reviewingApplicationPage.mortgageApplicationAccess();


    }
    @When("the user is redirected to the dashboard page")
    public void the_user_is_redirected_to_the_dashboard_page() {

    }
    @When("clicks mortgage application button")
    public void clicks_mortgage_application_button() {
        ReviewingApplicationPage reviewingApplicationPage = new ReviewingApplicationPage();
        reviewingApplicationPage.mortgageApplicationAccess();

    }
    @When("the user fills out all required fields in previous sections")
    public void the_user_fills_out_all_required_fields_in_previous_sections() {
    ReviewingApplicationPage reviewingApplicationPage = new ReviewingApplicationPage();
    reviewingApplicationPage.fillingOutPreApproval();
    reviewingApplicationPage.fillingOutPersonalInfo();
    reviewingApplicationPage.fillingExpenses();
    reviewingApplicationPage.fillingEmploymentAndIncome();
    reviewingApplicationPage.fillingCreditReport();
    reviewingApplicationPage.fillingOutEconsent();

    }
    @Then("the user is redirected to the Summary page")
    public void the_user_is_redirected_to_the_summary_page() {

    }
    @When("the user is on summary page")
    public void the_user_is_on_summary_page() {

    }
    @Then("the user can see the text {string}")
    public void the_user_can_see_the_text(String expectedPageTitle) {
        ReviewingApplicationPage reviewingApplicationPage = new ReviewingApplicationPage();
//        Assert.assertEquals(expectedPageTitle, reviewingApplicationPage.getApplicationSubmittedConfirmation().getText());

    }


    @Then("the user can see the all information he entered in all sections")
    public void the_user_can_see_the_all_information_he_entered_in_all_sections() {

    }




    @Then("the user can see that each is labeled and separated from the other sections")
    public void the_user_can_see_that_each_is_labeled_and_separated_from_the_other_sections(List<String> dataTable) {


    }





    @Then("the user can see and click the edit button for each section so the user can make changes to that section")
    public void the_user_can_see_and_click_the_edit_button_for_each_section_so_the_user_can_make_changes_to_that_section() {

    }



    @When("the user clicks the Edit button")
    public void the_user_clicks_the_edit_button() {

    }
    @Then("the user redirected to the relevant page to make any necessary changes")
    public void the_user_redirected_to_the_relevant_page_to_make_any_necessary_changes() {

    }



    @When("the user makes changes to a section")
    public void the_user_makes_changes_to_a_section() {

    }
    @Then("the user should be able to return to the Summary page and see the updated information for that section")
    public void the_user_should_be_able_to_return_to_the_summary_page_and_see_the_updated_information_for_that_section() {

    }



    @When("the user edits any {string} of the application in any order")
    public void the_user_edits_any_of_the_application_in_any_order(String string) {

    }
    @Then("the user should be able to return to the Summary page at any time")
    public void the_user_should_be_able_to_return_to_the_summary_page_at_any_time() {

    }


    @When("the user reviews all information entered")
    public void the_user_reviews_all_information_entered() {

    }
    @Then("the user should be able to click Submit button")
    public void the_user_should_be_able_to_click_submit_button() {

    }



    @When("the user clicks Submit button")
    public void the_user_clicks_submit_button() {

    }
    @Then("the user should be redirected to the confirmation page")
    public void the_user_should_be_redirected_to_the_confirmation_page() {

    }



}
