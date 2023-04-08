package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
@Data
public class ReviewingApplicationPage {
    public ReviewingApplicationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // SignIn
    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[.= 'Sign In']")
    private WebElement signInButton;




    //Dashboard

    @FindBy(xpath = "//a[@href='dashboard.php']")
    private WebElement dashBoardButton;

    @FindBy(xpath = "//a[@href='mortgage.php']")
    private WebElement mortgageApplicationButton;

    // PreApproval details

    @FindBy(xpath= "//input[@id='realtorinfo']")
    private WebElement realtorInfoInputField;

    @FindBy(id = "estimatedprice")
    private WebElement estimatedPurchasePrice;

    @FindBy(id = "downpayment")
    private WebElement downpaymentAmount;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButtonPreApproval;

    //Personal information

    @FindBy(id = "b_firstName")
    private WebElement borrowerFirstName;

    @FindBy(id = "b_lastName")
    private WebElement borrowerLastName;

    @FindBy(id = "b_email")
    private WebElement borrowerEmail;

    @FindBy(id = "b_dob")
    private WebElement borrowerDob;

    @FindBy(id = "b_ssn")
    private WebElement borrowerSsn;

    @FindBy(id = "select2-b_marital-container")
    private WebElement borrowerMaritalStatus;

    @FindBy(id = "b_cell")
    private WebElement borrowerCell;

    //Expenses
    @FindBy(id = "monthlyrentalpayment")
    private WebElement monthlyRentalExpenses;

    // Employment and income
    @FindBy(id = "employername1")
    private WebElement employerName;

    @FindBy(id = "grossmonthlyincome")
    private WebElement grossMonthlyIncome;

    //Credit report - just click on next

    // Econsent


    @FindBy(id = "eConsentdeclarerFirstName")
    private WebElement econsentFirstName;

    @FindBy(id = "eConsentdeclarerLastName")
    private WebElement econsentLastName;

    @FindBy(id = "eConsentdeclarerEmail")
    private WebElement econsentEmail;

    @FindBy(xpath = "//input[@name='consentagree']")
    private WebElement econsentAgreeButton;

    //Summary - labels
    @FindBy(xpath = "//h6[contains(., 'PreApproval Inquiry')]")
    private WebElement preApprovalInquiryLabel;

    @FindBy(xpath = "//h6[contains(., 'Personal Details')]")
    private WebElement personalDetailsLabel;


    @FindBy(xpath = "//h6[.='Expenses']")
    private WebElement expensesLabel;

    @FindBy(xpath = "//h6[contains(., 'Employment & Income')]")
    private WebElement employmentAndIncomeLabel;

    @FindBy(xpath = "//h6[contains(., 'Order Credit')]")
    private WebElement orderCreditLabel;

    @FindBy(xpath = "//h6[contains(., 'eConsent')]")
    private WebElement eConsentLabel;

    //Summary - Edit buttons

    @FindBy(id = "PreApprovalEdit")
    private WebElement preApprovalInquiryEditButton;

//    @FindBy(id = "PersonalnformationEdit")
//    private WebElement personalInfoEditButton;
//
//    @FindBy(id = "PreApprovalEdit")
//    private WebElement preApprovalInquiryEditButton;
//
//    @FindBy(id = "PreApprovalEdit")
//    private WebElement preApprovalInquiryEditButton;


    //Summary - labeled links

    @FindBy(xpath = "//a[@id='steps-uid-0-t-0']")
    private WebElement preApprovaldetailsLink;

    public void mortgageApplicationAccess() {
        dashBoardButton.click();
        mortgageApplicationButton.click();
    }
    public void fillingOutPreApproval(){
         Faker faker = new Faker();
        String realtorInfo = faker.name().firstName() + " " + faker.name().lastName() + " " + faker.internet().emailAddress();
        realtorInfoInputField.sendKeys(realtorInfo);

        estimatedPurchasePrice.sendKeys("963563");
        downpaymentAmount.sendKeys("256365");
        nextButtonPreApproval.click();
    }


    public void signIn() {
        this.username.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
        this.signInButton.click();

    }


}
