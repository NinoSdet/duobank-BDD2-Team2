package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CreditReportPage {
    public CreditReportPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[.= 'Sign In']")
    private WebElement signInButton;

    @FindBy(id = "steps-uid-0-t-4")
    private WebElement creditReportButton;

    @FindBy(xpath = "//label[@for='creditreport1']")
    private WebElement yesReport;

    @FindBy(xpath = "//label[@for='creditreport2']")
    private WebElement noReport;

    @FindBy(xpath = "//a[@href='#previous']")
    private WebElement previous;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement next;

    public void creditReportButtonClick() {
        creditReportButton.click();
    }

    public void clickYes() {
        yesReport.click();
    }

    public void clickNo() {
        noReport.click();
    }

    public void clickPrevious() {
        previous.click();
    }

    public void clickNext() {
        next.click();
    }

    public String getActualHeadLine() {
        String actualHeadLine = Driver.getDriver().findElement(By.xpath("//*[@id=\"steps-uid-0-p-4\"]/h6")).getText();
        return actualHeadLine;}

    public String getPreviousPageTitle() {
        String previousPageTitle = Driver.getDriver().findElement(By.xpath("//*[@id=\"steps-uid-0-p-3\"]/h6[1]")).getText();
        return previousPageTitle;}

    public String getConsentPageTitle() {
        String consentPageTitle = Driver.getDriver().findElement(By.xpath("//*[@id=\"steps-uid-0-p-5\"]/h4")).getText();
        return consentPageTitle;
    }

    public String getActualTitle(){
        String actualTitle = Driver.getDriver().getTitle();
        return actualTitle;
    }
}