package stepDefinitions.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.PersonalInfoPage;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PersonalI_StepDefinisions_2_D {

    @Then("an additional section for personal information  information is displayed")
    public void anAdditionalSectionForPersonalInformationInformationIsDisplayed() {
        Assert.assertTrue("Personal Information", Driver.getDriver().getPageSource().contains("Personal Information"));

    }
    @Then("the user enters the personal information first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("all required fields are filled out")
    public void allRequiredFieldsAreFilledOut() {
        //String excepted = "Current Monthly Housing Expenses";
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Current Monthly Housing Expenses"));
    }

    @When("the user selects for the co-borrower question")
    public void theUserSelectsForTheCoBorrowerQuestion() throws InterruptedException {
        SeleniumUtils.waitFor(2);
        PersonalInfoPage personalI_page_factory_d1 = new PersonalInfoPage();
        personalI_page_factory_d1.setCoBorrower();
    }

    @Then("an additional section for co-borrower's information is displayed")
    public void anAdditionalSectionForCoBorrowerSInformationIsDisplayed() {
        Assert.assertTrue("Co-Borrower's Information",Driver.getDriver().getPageSource().contains("Co-Borrower's Information"));
    }
    @When("the user reads the Privacy Policy and clicks the checkbox to accept the terms")
    public void theUserReadsThePrivacyPolicyAndClicksTheCheckboxToAcceptTheTerms() {
        new PersonalInfoPage().setPerPtivacyCheckBoxButton();
        new PersonalInfoPage().setPerPtivacyCheckBoxButton();
    }
    @Then("the checkbox is checked and the user can move forward to the next page of the application")
    public void theCheckboxIsCheckedAndTheUserCanMoveForwardToTheNextPageOfTheApplication() {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//label[@for='privacypolicy']")).isEnabled());
    }
    @Then("the user enters the co-borrower's first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersTheCoBorrowerSFirstNameLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        new PersonalInfoPage().setCoFirstName();
        new PersonalInfoPage().setCoMiddleName();
        new PersonalInfoPage().setCoLastName();
        new PersonalInfoPage().setCoSulfixPlace();
        SeleniumUtils.waitFor(2);
        new PersonalInfoPage().setCoSulfixSr();
        new PersonalInfoPage().setCoEmailAd();
        new PersonalInfoPage().setCoDateBirth();
        SeleniumUtils.scrollDown(200);
        new PersonalInfoPage().setCoSSN();
        new PersonalInfoPage().setCoSSN();
        SeleniumUtils.waitFor(5);
        new PersonalInfoPage().setCoMarytalStatus();
        SeleniumUtils.waitFor(2);
        new PersonalInfoPage().setCoMarytalStatus();
        SeleniumUtils.waitFor(2);
        new PersonalInfoPage().setCophoneNumber();
        new PersonalInfoPage().setCoHomephoneNumber();
        personalInfoPage.setPerCoNextButton();
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Current Monthly Housing Expenses"));

    }

    @Then("the user enters the personal information first name incoreccet only number, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameIncoreccetLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setNegativpersonalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information first name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameIncoreccetNumberAndLettersLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setNegativ_2_personalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }


    @Then("the user enters the personal information first name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameIncoreccetLettersWithSpaceLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setNegativ_3_personalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information first name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationFirstNameLettersWithCharctersMoreLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setNegativ_4_personalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information Middle name incoreccet only number, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationMiddleNameIncoreccetOnlyNumberLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonal_1_MiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information Middle name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationMiddleNameIncoreccetNumberAndLettersLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonal_2_MiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information Middle name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationMiddleNameIncoreccetLettersWithSpaceLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonal_3_MiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information Middle name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationMiddleNameLettersWithCharctersMoreLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonal_4_MiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information Last name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationLastNameIncoreccetNumberAndLettersLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonal_1_LastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information Last name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationLastNameIncoreccetLettersWithSpaceLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setpersonal_2_LastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information Last name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone")
    public void theUserEntersThePersonalInformationLastNameLettersWithCharctersMoreLastNameEmailDateOfBirthSSNMaritalStatusCellPhoneAndHomePhone() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setpersonal_3_LastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    //Parametr
    @Then("the user enters the personal information neqativ first name {string}")
    public void theUserEntersThePersonalInformationFirstName(String name) {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalparametrName(name);
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();

    }


    @Then("the user enters the personal information neqativ Middle name {string}")
    public void theUserEntersThePersonalInformationNeqativMiddleName(String nameMiddle) {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonalParametrMiddleName(nameMiddle);
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("the user enters the personal information neqativ Last name {string}")
    public void theUserEntersThePersonalInformationNeqativLastName(String nameLast) {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalParametrLastName(nameLast);
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("all required fields negativ are filled out")
    public void allRequiredFieldsNegativAreFilledOut() {
        Assert.assertTrue("ARE YOU APPLYING WITH A CO-BORROWER?",Driver.getDriver().getPageSource().contains("ARE YOU APPLYING WITH A CO-BORROWER?"));
    }

    //link text xpath
    @Then("sulfix {string}")
    public void sulfix(String linkName) {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalName();
        personalInfoPage.setPersonalMiddleName();
        personalInfoPage.setPersonalLastName();
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixlinkxpath(linkName);
        personalInfoPage.setPerEmailAd();
        personalInfoPage.setPerDateBirth();
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }

    @Then("all required xpath {string} are filled out")
    public void allRequiredXpathAreFilledOut(String linkName) {
        Assert.assertEquals(linkName,new PersonalInfoPage().getCurrent());
    }

    //Data Table
    @Then("Click in sulfix place")
    public void clickInSulfixPlace() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPerSulfixPlace();
    }

    @Then("i should see following options")
    public void i_should_see_following_options(List<String> dataTable) {

        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        List<String> actualy = personalInfoPage.getsulfixDataT();

        Assert.assertEquals(dataTable, actualy);
        System.out.println(dataTable);
    }
    @Then("Click in marytal status place")
    public void click_in_marytal_status_place() {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.getPerMarytalStatus();
    }
    @Then("i should see marytal status following options")
    public void i_should_see_marytal_status_following_options(List<String> dataTable) {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        List<String> actualy = personalInfoPage.marytalDataT();

        Assert.assertEquals(dataTable, actualy);
        System.out.println(dataTable);
    }


    //Scenario1 Outline
    @When("the user enters the personal information {string},{string},{string},{string},{string}")
    public void theUserEntersThePersonalInformation(String name, String middleName, String lastName, String email, String dateOfbirth) {
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalOutlineName(name);
        personalInfoPage.setPersonalOutlineMiddleName(middleName);
        personalInfoPage.setPersonalOutlineLastName(lastName);
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailOutlineAd(email);
        personalInfoPage.setPerDateOutlineBirth(dateOfbirth);
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();

    }


    @Then("all required fields positiv are filled out")
    public void allRequiredFieldsPositivAreFilledOut() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Current Monthly Housing Expenses"));

    }

    //Data table all in
    @When("the user enters the personal information")
    public void the_user_enters_the_personal_information( List<List<String>> dataTable) {

        String firstName = dataTable.get(0).get(0);
        String middleName = dataTable.get(0).get(1);
        String lastName = dataTable.get(0).get(2);
        String email12 = dataTable.get(0).get(3);
        String dateOfBirth12 = dataTable.get(0).get(4);

        // Fill out the personal information section
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.setPersonalDataTName(firstName);
        personalInfoPage.setPersonalDataTMiddleName(middleName);
        personalInfoPage.setPersonalDataTLastName(lastName);
        personalInfoPage.setPerSulfixPlace();
        personalInfoPage.setPerSulfixIII();
        personalInfoPage.setPerEmailDataTAd(email12);
        personalInfoPage.setPerdataDataTBirth(dateOfBirth12);
        personalInfoPage.setPerSSN();
        personalInfoPage.setPerMarytalStatus();
        personalInfoPage.setPerCell();
        personalInfoPage.setPerHome();
        personalInfoPage.setPerCoNextButton();
    }
}


