package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.PersonalInfoPage;
import utils.Driver;
import utils.SeleniumUtils;

public class PersonalI_StepDefinisions_D {

    @Given("userName1")
    public void perusername() {

        SeleniumUtils.waitFor(2);
        PersonalInfoPage personalInfoPage = new PersonalInfoPage();
        personalInfoPage.userName1();
        personalInfoPage.passWord();
        personalInfoPage.loGin();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Duobank Mortgage Application");
        new PersonalInfoPage().mortageClick();
        new PersonalInfoPage().preapruNo();
        new PersonalInfoPage().estimatePri();
        new PersonalInfoPage().setEstimateDownP();
        new PersonalInfoPage().setPreaprovalNext();
        Assert.assertTrue("personal information", Driver.getDriver().getPageSource().contains("Personal Information"));

    }
}