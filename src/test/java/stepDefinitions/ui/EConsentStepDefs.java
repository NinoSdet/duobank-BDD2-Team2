package stepDefinitions.ui;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EConsentPage;
import pages.ReviewingApplicationPage;

public class EConsentStepDefs {


    @Given("User is on the sign-in page.")
    public void user_applicant_is_on_the_sign_in_page() {

    }
    @When("User enters valid username password and clicks on the sign-in input boxes")
    public void user_applicant_enters_valid_username_password_and_clicks_on_the_sign_in_input_boxes() {
        EConsentPage eConsentPage = new EConsentPage();
        eConsentPage.signInPage();
        eConsentPage.mortgageApplicationAccessPage();
    }
    @When("User moves to the Dashboard page.")
    public void user_applicant_moves_to_the_dashboard_page() {

    }
    @When("User clicks mortgage application section")
    public void user_clicks_mortgage_application_section() {
        EConsentPage eConsentPage = new EConsentPage();
        eConsentPage.mortgageApplicationAccessPage();
    }
    @When("User fills out all required fields in previous sections")
    public void user_applicant_fills_out_all_required_fields_in_previous_sections() {
         EConsentPage eConsentPage= new EConsentPage();
         eConsentPage.fillOutPreApprovalPage();
         eConsentPage.fillOutPersonalInfoPage();
         eConsentPage.fillOutExpensesPage();
         eConsentPage.fillOutEmploymentAndIncomeSection();
         eConsentPage.fillOutCreditReportSection();

    }
    @Then("User is redirected to the EConsent Page")
    public void user_is_redirected_to_the_e_consent_page() {

    }
    @Given("User is on E-Consent page")
    public void user_applicant_is_on_e_consent_page() {

    }
    @When("User enters valid first name ,last name and email adrress")
    public void user_applicant_is_entering_valid_first_name_last_name_and_email_adrress() {
        EConsentPage eConsentPage = new EConsentPage();
        eConsentPage.fillingOutEconsent();
    }
    @Then("The user is able to select Agree or Don't Agree checkbox")
    public void the_user_is_able_to_select_Agree_or_DontAgree_checkbox() {
        EConsentPage  eConsentPage = new EConsentPage();
        eConsentPage.clickAgreeButton();
        }

    @Then("click next to move to the next page")
    public void click_next_to_move_to_the_next_page() {
        EConsentPage eConsentPage = new EConsentPage();
        eConsentPage.clickNextButton();
    }

    @When("The user on E-Consent Page on disclosures")
    public void the_user_on_e_consent_page_on_disclosures() {

    }
    @Then("The user can see clearly see disclosures which are Your Consent, Withdrawal Of Consent, Obtaining Paper Copies, System Requirements, How We Can Reach You, eConsent")
    public void the_user_can_see_clearly_see_disclosures_which_are_your_consent_withdrawal_of_consent_obtaining_paper_copies_system_requirements_how_we_can_reach_you_e_consent() {
       EConsentPage eConsentPage = new EConsentPage();
       Assert.assertTrue(eConsentPage.isEconsentYourConsent());
       Assert.assertTrue(eConsentPage.isEconsentWithdrawal());
       Assert.assertTrue(eConsentPage.isEconsentObtainingPaperCopies());
       Assert.assertTrue(eConsentPage.isEconsentHowWeCanReachYou());
    }



    @Then("The user click each of disclosures such as Your Consent, Withdrawal Of Consent, Obtaining Paper Copies, System Requirements, How We Can Reach You")
    public void the_user_click_each_of_disclosures_such_as_your_consent_withdrawal_of_consent_obtaining_paper_copies_system_requirements_how_we_can_reach_you() {
        EConsentPage eConsentPage = new EConsentPage();
        eConsentPage.clickEconsentYourConsent();
        eConsentPage.clickEconsentWitdrawalOfConsent();
        eConsentPage.clickEconsentObtainingPaperCopies();
        eConsentPage.clickEconsentSystemRequirements();
        eConsentPage.clickEconsentHowWeCanReachYou();
    }



    @Then("The user enters invalid email address")
    public void the_user_enters_invalid_email_address() {
        EConsentPage eConsentPage = new EConsentPage();
        eConsentPage.eConsentWrongEmail();
    }

    @Then("There was a Invalid email adress message should be displayed")
    public void there_was_a_invalid_email_adress_message_should_be_displayed() {
        EConsentPage eConsentPage = new EConsentPage();
        Assert.assertTrue(eConsentPage.isInvalidEmailDisplayed());
    }}

// Last Commit
//Commit again
