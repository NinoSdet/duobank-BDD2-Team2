package pages;

import com.github.javafaker.Faker;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.text.SimpleDateFormat;

public class EConsentPage {

    public EConsentPage() {
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
    private WebElement realtorInfoInput;

    @FindBy(id = "estimatedprice")
    private WebElement estimatePurchasePrice;

    @FindBy(id = "downpayment")
    private WebElement downPaymentAmount;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButtonForPreApproval;

    //Personal information

    @FindBy(id = "b_firstName")
    private WebElement borrowersFirstNameInput;

    @FindBy(id = "b_lastName")
    private WebElement borrowersLastNameInput;

    @FindBy(id = "b_email")
    private WebElement borrowersEmailInput;

    @FindBy(id = "b_dob")
    private WebElement borrowersDobInput;

    @FindBy(id = "b_ssn")
    private WebElement borrowersSsn;

//    @FindBy(id = "select2-b_marital-container")
//    private WebElement borrowerMaritalStatus;

    @FindBy(id = "b_marital")
    private WebElement borrowersMaritalStatusDropdown;

    @FindBy(id = "b_cell")
    private WebElement borrowersCell;

    //Expenses
    @FindBy(id = "monthlyrentalpayment")
    private WebElement monthlyRentExpenses;

    // Employment and income
    @FindBy(id = "employername1")
    private WebElement employerNameSection;

    @FindBy(id = "grossmonthlyincome")
    private WebElement grossMonthlyIncome;



    // E-Consent Page

    @FindBy (id = "eConsentdeclarerFirstName")
    private WebElement eConsentFirstName;

    @FindBy ( id="eConsentdeclarerLastName")
    private WebElement eConsentLastName;

    @FindBy ( id= "eConsentdeclarerEmail")
    private WebElement eConsentEmail;

    @FindBy (xpath = "//label[@for='agree']")
    private WebElement eConsentAgreeButton;

    @FindBy (xpath = "//label[@for='dontagree']")
    private WebElement eConsentDontAgreeButton;

    @FindBy (xpath= "//*[@href='#previous']")
    private WebElement eConsentPreviousButton;

    @FindBy (xpath = "//*[@href='#next']")
    private WebElement eConsentNextButton;

    @FindBy (id= "eConsentdeclarerEmail-error")
    private WebElement invalidEmailPopUpMessage;

    @FindBy (xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[1]")
    private WebElement eConsentYourConsent;

    @FindBy(xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[1]")
    private WebElement eConsentWithdrawalOfConsent;

    @FindBy (xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[3]")
    private WebElement eConsentObtainingPaperCopies;

    @FindBy (xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[4]")
    private WebElement eConsentSystemRequirements;

    @FindBy (xpath="//*[@id=\"steps-uid-0-p-5\"]/div[3]/pre/a[5]")
    private WebElement eConsentHowWeCanReachYou;


    public void signInPage() {
        this.username.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
        this.signInButton.click();

    }
    public void mortgageApplicationAccessPage() {
        dashBoardButton.click();
        mortgageApplicationButton.click();
    }
    public void fillOutPreApprovalPage(){
        Faker faker = new Faker();
        String realtorInfo = faker.name().firstName() + " " + faker.name().lastName() + " " + faker.internet().emailAddress();
        realtorInfoInput.sendKeys(realtorInfo);

        estimatePurchasePrice.sendKeys("234567");
        downPaymentAmount.sendKeys("543365");
        nextButtonForPreApproval.click();
    }

    public void fillOutPersonalInfoPage(){
        Faker faker = new Faker();
        String borrowersFirstName = faker.name().firstName();
        String borrowersLastName = faker.name().lastName();
        String borrowersEmail =faker.internet().emailAddress();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dob = sdf.format(faker.date().birthday());
        String ssn = randomDigitsCalculate(3)+"-"+randomDigitsCalculate(2)+"-"+ randomDigitsCalculate(4);
        String cellNumber = faker.phoneNumber().phoneNumber();
        borrowersFirstNameInput.sendKeys(borrowersFirstName);
        borrowersLastNameInput.sendKeys(borrowersLastName);
        borrowersEmailInput.sendKeys(borrowersEmail);
        borrowersDobInput.sendKeys(dob);
        borrowersSsn.sendKeys(ssn);
        borrowersCell.sendKeys(cellNumber);

        Select maritalDropdown = new Select(borrowersMaritalStatusDropdown);
        maritalDropdown.selectByVisibleText("Single");

        nextButtonForPreApproval.click();
    }

    public String randomDigitsCalculate(int numbers){
        String result = "";
        for (int i=0; i<numbers; i++){
            result+=((int)(1 + Math.random()*9));

        }
        return result;
    }
    public void fillOutExpensesPage(){
        monthlyRentExpenses.sendKeys("2565");
        nextButtonForPreApproval.click();

    }

    public void fillOutEmploymentAndIncomeSection(){
        Faker faker = new Faker();
        String employerName = faker.company().name();
        employerNameSection.sendKeys(employerName);
        grossMonthlyIncome.sendKeys("125634967");
        nextButtonForPreApproval.click();

    }
    public void fillOutCreditReportSection(){
        nextButtonForPreApproval.click();

    }
    public void fillingOutEconsent(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email =faker.internet().emailAddress();

        eConsentFirstName.sendKeys(firstName);
        eConsentLastName.sendKeys(lastName);
        eConsentEmail.sendKeys(email);
        SeleniumUtils.jsClick(eConsentAgreeButton);

        nextButtonForPreApproval.click();
    }

    public void clickEconsentYourConsent(){
        SeleniumUtils.jsClick(eConsentYourConsent);
    }
    public void clickEconsentWitdrawalOfConsent() {
        SeleniumUtils.jsClick(eConsentWithdrawalOfConsent);
    }
    public void clickEconsentObtainingPaperCopies(){
        SeleniumUtils.jsClick(eConsentObtainingPaperCopies);
    }
    public void clickEconsentSystemRequirements(){
        SeleniumUtils.jsClick(eConsentSystemRequirements);
    }

    public void clickEconsentHowWeCanReachYou(){
        SeleniumUtils.jsClick(eConsentHowWeCanReachYou);
    }
}






