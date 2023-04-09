package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class EConsentPage {

    public EConsentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (id = "eConsentdeclarerFirstName")
    private WebElement firstName;

    @FindBy ( id="eConsentdeclarerLastName")
    private WebElement lastName;

    @FindBy ( id= "eConsentdeclarerEmail")
    private WebElement email;

    @FindBy (xpath = "//label[@for='agree']")
    private WebElement agreeButton;

    @FindBy (xpath = "//label[@for='dontagree']")
    private WebElement dontAgreeButton;

    @FindBy (xpath= "//*[@href='#previous']")
    private WebElement previousButton;

    @FindBy (xpath = "//*[@href='#next']")
    private WebElement nextButton;

    @FindBy (xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[1]")
    private WebElement yourConsent;

    @FindBy(xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[1]")
    private WebElement withdrawalOfConsent;

    @FindBy (xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[3]")
    private WebElement obtainingPaperCopies;

    @FindBy (xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[4]")
    private WebElement systemRequirements;

    @FindBy (xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[5]")
    private WebElement howWeCanReachYou;







}





