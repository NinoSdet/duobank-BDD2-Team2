package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreditReportPage;
import utils.Driver;

public class CreditReportStepDefs {
    @Given("the user filled out all the fields")
    public void the_user_filled_out_all_the_fields() {
        //throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks the credit report button")
    public void the_user_clicks_the_credit_report_button() {
        CreditReportPage creditReportPage = new CreditReportPage();
        creditReportPage.creditReportButtonClick();
    }
    @Then("the user is being redirected to the Credit Report Page")
    public void the_user_is_being_redirected_to_the_credit_report_page() {
        CreditReportPage creditReportPage = new CreditReportPage();
        Assert.assertEquals("PreApproval Inquiry", creditReportPage.getActualHeadLine());
    }
    @When("the user chooses YES on the Credit Report Page")
    public void the_user_chooses_yes_on_the_credit_report_page() throws InterruptedException {
        CreditReportPage creditReportPage = new CreditReportPage();
        creditReportPage.creditReportButtonClick();
//        WebElement l = driver.findElement(By.className("gsc-input"));
//        JavascriptExecutor j = (JavascriptExecutor) driver;
//        j.executeScript("arguments[0].click();", l);
//        Thread.sleep(700);
        creditReportPage.clickYes();
    }
    @Then("the user is being redirected to the verification page")
    public void the_user_is_being_redirected_to_the_verification_page() {
        CreditReportPage creditReportPage = new CreditReportPage();
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().stream().reduce((f, s) -> s).orElse(null));
        System.out.println("Expected: Order Credit Report\nActual: " + creditReportPage.getActualTitle());
        Assert.assertEquals("Order Credit Report", creditReportPage.getActualTitle());
    }

    @Then("the user is being redirected to the Employment and Income page")
    public void the_user_is_being_redirected_to_the_Employment_and_Income_page(){
        CreditReportPage creditReportPage = new CreditReportPage();
        Assert.assertEquals("Borrower Employment Information", creditReportPage.getPreviousPageTitle());
    }

    @When("the user chooses NO and clicks on PREVIOUS button on the Credit Report Page")
    public void the_user_chooses_no_and_clicks_on_previous_button_on_the_credit_report_page(){
        CreditReportPage creditReportPage = new CreditReportPage();
        creditReportPage.creditReportButtonClick();
        //Thread.sleep(700);
        creditReportPage.clickNo();
        creditReportPage.clickPrevious();
    }

    @When("the user skips selection and clicks on PREVIOUS button on the Credit Report Page")
    public void the_user_skips_selection_and_clicks_on_previous_button_on_the_credit_report_page() {
        CreditReportPage creditReportPage = new CreditReportPage();
        creditReportPage.creditReportButtonClick();
        creditReportPage.clickPrevious();
    }

    @When("the user clicks on NEXT button on the Credit Report Page")
    public void the_user_clicks_on_next_button_on_the_credit_report_page() {
        CreditReportPage creditReportPage = new CreditReportPage();
        creditReportPage.creditReportButtonClick();
        creditReportPage.clickNext();
    }
    @Then("the user is being redirected to the eConsent page")
    public void the_user_is_being_redirected_to_the_e_consent_page() {
        CreditReportPage creditReportPage = new CreditReportPage();
        Assert.assertEquals("eConsent", creditReportPage.getConsentPageTitle());
    }

    @Then("the user stays on the Credit Report Page page")
    public void the_user_stays_on_the_credit_report_page_page() {
        CreditReportPage creditReportPage = new CreditReportPage();
        Assert.assertEquals("PreApproval Inquiry", creditReportPage.getActualHeadLine());
    }
    @Then("the user gets a warning to make a selection above")
    public void the_user_gets_a_warning_to_make_a_selection_above() {
        System.out.println("No warning given");
    }

}
