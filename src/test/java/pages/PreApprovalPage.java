package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.text.SimpleDateFormat;

@Data
public class PreApprovalPage {
    public PreApprovalPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[.= 'Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href='dashboard.php']")
    private WebElement dashBoardButton;

//    @FindBy(xpath = "//span[.='Mortgage Application']")
//    private WebElement mortgageApplicationButton;

    @FindBy(xpath = "//a[@href='mortgage.php']")
    private WebElement mortgageApplicationButton;

    @FindBy(xpath = "//label[@for='realtor1']")
    private WebElement yesRealtorCheckBoxLabel;

    @FindBy(xpath = "//input[@id='realtor1']")
    private WebElement yesRealtorCheckBox;

    @FindBy(xpath = "//label[@for='realtor2']")
    private WebElement noRealtorCheckBoxLabel;
    //
    @FindBy(xpath = "//input[@id='realtor2']")
    private WebElement noRealtorCheckBox;
    //
    @FindBy(xpath= "//input[@id='realtorinfo']")
    private WebElement realtorInfoInputField;

    @FindBy(xpath = "//label[@for='loanofficer1']")
    private WebElement yesLoanOfficerCheckBoxLabel;

    @FindBy(xpath = "//input[@id='loanofficer1']")
    private WebElement yesLoanOfficerCheckBox;

    @FindBy(xpath = "//label[@for='loanofficer2']")
    private WebElement noLoanOfficerCheckBoxLabel;
    //
    @FindBy(xpath = "//input[@id='loanofficer2']")
    private WebElement noLoanOfficerCheckBox;



    @FindBy(xpath = "//select[@name='purpose_loan']")
    private WebElement loanPurposeDropDown;

    @FindBy(id = "estimatedprice")
    private WebElement estimatedPurchasePrice;

    @FindBy(id = "downpayment")
    private WebElement downpaymentAmount;

    public WebElement getDownPaymentSourceDropdown() {
        return downPaymentSourceDropdown;
    }

    @FindBy(xpath = "//select[@name='src_down_payment']")
    private WebElement downPaymentSourceDropdown;

    @FindBy(xpath = "//label[contains(@id, 'estimatedprice')]")
    private WebElement EstimatedPriceErrorMessage;

    @FindBy(xpath = "//label[contains(@id, 'downpayment')]")
    private WebElement downPaymentErrorMessage;

    @FindBy(xpath = "//label[contains(@id, 'downpaymentpercentage')]")
    private WebElement downPaymentPercentageErrorMessage;

    @FindBy(xpath = "//label[contains(@id, 'additionalfunds')]")
    private WebElement additionalFundsErrorMessage;





    public WebElement getEstimatedPurchasePrice() {
        return estimatedPurchasePrice;
    }

    public WebElement getDownpaymentAmount() {
        return downpaymentAmount;
    }

    public WebElement getDownpaymentpercentage() {
        return downpaymentpercentage;
    }

    public WebElement getLoanAmount() {
        return loanAmount;
    }

    @FindBy(id = "downpaymentpercentage")
    private WebElement downpaymentpercentage;

    @FindBy(xpath = "//input[@id='loanamount']")
    private WebElement loanAmount;

    public WebElement getAdditionalFunds() {
        return additionalFunds;
    }

    @FindBy(id = "additionalfunds")
    private WebElement additionalFunds;


    public WebElement getUsername() {
        return username;
    }


    public WebElement getNextButton() {
        return nextButton;
    }

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;

    @FindBy(xpath = "//ul[@role='tablist']/li[2]")
    private WebElement personalInformationTab;

    public WebElement getPersonalInformationTab() {
        return personalInformationTab;
    }

    public WebElement getPreapprovalDetailsTab() {
        return preapprovalDetailsTab;
    }

    @FindBy(xpath = "//ul[@role='tablist']/li[1]")
    private WebElement preapprovalDetailsTab;

    @FindBy(name = "src_down_payment")
    private WebElement sourceOfDownpaymentDropdown;





    public void signIn() {
        this.username.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
        this.signInButton.click();

    }

    public void mortgageApplicationAccess() {
//        SeleniumUtils.waitFor(5);
//        dashBoardButton.click();
//        SeleniumUtils.waitForClickablility(mortgageApplicationButton, 10);
        mortgageApplicationButton.click();
    }

    public void clickYesRealtor(){
        yesRealtorCheckBoxLabel.click();
    }

    public void clickNoRealtor(){
        noRealtorCheckBoxLabel.click();
    }

    public WebElement getYesRealtorCheckBox() {
        return yesRealtorCheckBox;
    }

    public WebElement getNoRealtorCheckBox() {
        return noRealtorCheckBox;
    }

    public void enterRealtorInfo(String realtorInfo){
        realtorInfoInputField.sendKeys(realtorInfo);
    }

    public WebElement getRealtorInfoInputField() {
        return realtorInfoInputField;
    }

    public void clickYesLoanOfficer(){
        yesLoanOfficerCheckBoxLabel.click();
    }

    public void clickNoLoandOfficer(){
        noLoanOfficerCheckBoxLabel.click();
    }

    public WebElement getYesLoanOfficerCheckBox() {
        return yesLoanOfficerCheckBox;
    }

    public WebElement getNoLoanOfficerCheckBox() {
        return noLoanOfficerCheckBox;
    }

    public void selectPurchaseHome() {
        SeleniumUtils.jsClick(loanPurposeDropDown);

    }

    public WebElement getLoanPurposeDropDown() {
        return loanPurposeDropDown;
    }

    public void fillTheFormWithData(String realtorStatus,
                                    String realtorInfo,
                                    String loanOfficerStatus,
                                    String purposeLoan,
                                    String estPurchasePrice,
                                    String downpayment,
                                    String downpaymentPercent,
                                    String totalLoanAmount,
                                    String srcDownpayment,
                                    String addFundAvailable){

        if (realtorStatus.equalsIgnoreCase("Yes") || realtorStatus.equals("1")){
            clickYesRealtor();
            this.realtorInfoInputField.sendKeys(realtorInfo);
        }else{
            clickNoRealtor();
        }
        if (loanOfficerStatus.equalsIgnoreCase("Yes") || loanOfficerStatus.equals("1")){
            clickYesLoanOfficer();
        }else{
            clickNoLoandOfficer();
        }
        Select loanPurposeSelect = new Select(loanPurposeDropDown);
        loanPurposeSelect.selectByVisibleText(purposeLoan);

        this.estimatedPurchasePrice.sendKeys(estPurchasePrice);
        this.downpaymentAmount.sendKeys(downpayment);
//


        Select srcDropdown = new Select(sourceOfDownpaymentDropdown);
        srcDropdown.selectByVisibleText(srcDownpayment);

        this.additionalFunds.sendKeys(addFundAvailable);


    }


    public void clickNext() {
        nextButton.click();
    }
}
