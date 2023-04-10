package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

//    @FindBy(id = "select2-b_marital-container")
//    private WebElement borrowerMaritalStatus;

    @FindBy(id = "b_marital")
    private WebElement borrowerMaritalStatusDropdown;

    @FindBy(id = "b_cell")
    private WebElement borrowerCell;

    //Expenses
    @FindBy(id = "monthlyrentalpayment")
    private WebElement monthlyRentalExpenses;

    // Employment and income
    @FindBy(id = "employername1")
    private WebElement employerNameElement;

    @FindBy(id = "grossmonthlyincome")
    private WebElement grossMonthlyIncomeElement;

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

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private WebElement applicationSubmittedConfirmation;
    @FindBy(xpath = "//div[@class='PreApprovalDetails']//p")
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

    @FindBy (xpath =  "//h6[@class='pb-50']")
    private List<WebElement> allSectionHeaders;

    //Summary - Edit buttons

    @FindBy(id = "PreApprovalEdit")
    private WebElement preApprovalInquiryEditButton;

    @FindBy(id = "PersonalnformationEdit")
    private WebElement personalInfoEditButton;

    @FindBy(id = "ExpenseEdit")
    private WebElement expenseEditButton;

    @FindBy(id = "EmploymentIncomeEdit")
    private WebElement employmentIncomeEditButton;

    @FindBy(id = "OrderCreditEdit")
    private WebElement orderCreditcardEditButton;

    @FindBy(id = "eConsentEdit")
    private WebElement eConsentEditButton;

    @FindBy(id = "//a[contains(@class, 'success')]")
    private List<WebElement> allEditButtons;

    public List<String> getAllEditButtonsText() {
        List<String> buttonTexts = new ArrayList<>();
        buttonTexts.add(preApprovalInquiryEditButton.getText());
        buttonTexts.add(personalInfoEditButton.getText());
        buttonTexts.add(expenseEditButton.getText());
        buttonTexts.add(employmentIncomeEditButton.getText());
        buttonTexts.add(orderCreditcardEditButton.getText());
        buttonTexts.add(eConsentEditButton.getText());

        return buttonTexts;
    }
//Summary - labeled links

    @FindBy(xpath = "//a[@id='steps-uid-0-t-0']")
    private WebElement preApprovaldetailsLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-1']")
    private WebElement personalInfoLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-2']")
    private WebElement expensesLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-3']")
    private WebElement employmentAndIncomeLink;


    @FindBy(xpath = "//a[@id='steps-uid-0-t-4']")
    private WebElement creditReportLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-5']")
    private WebElement eConsentLink;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-6']")
    private WebElement summaryLink;


    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement submitButton;






    public void signIn() {
        this.username.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
        this.signInButton.click();

    }
    public void mortgageApplicationAccess() {
        //dashBoardButton.click();
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

    public void fillingOutPersonalInfo(){
        Faker faker = new Faker();
        String borrowersFirstName = faker.name().firstName();
        String borrowersLastName = faker.name().lastName();
        String borrowersEmail =faker.internet().emailAddress();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dob = sdf.format(faker.date().birthday());
        String ssn = randomDigits(3)+"-"+randomDigits(2)+"-"+ randomDigits(4);
        String cellNumber = faker.phoneNumber().phoneNumber();
        borrowerFirstName.sendKeys(borrowersFirstName);
        borrowerLastName.sendKeys(borrowersLastName);
        borrowerEmail.sendKeys(borrowersEmail);
        borrowerDob.sendKeys(dob);
        borrowerSsn.sendKeys(ssn);
        borrowerCell.sendKeys(cellNumber);

        Select maritalDropdown = new Select(borrowerMaritalStatusDropdown);
        maritalDropdown.selectByVisibleText("Single");

        nextButtonPreApproval.click();
    }

    public String randomDigits(int numbers){
        String result = "";
        for (int i=0; i<numbers; i++){
            result+=((int)(1 + Math.random()*9));

        }
        return result;
    }
    public void fillingExpenses(){
        monthlyRentalExpenses.sendKeys("2565");
        nextButtonPreApproval.click();

    }

    public void fillingEmploymentAndIncome(){
        Faker faker = new Faker();
        String employerName = faker.company().name();
        employerNameElement.sendKeys(employerName);
        grossMonthlyIncomeElement.sendKeys("125634967");
        nextButtonPreApproval.click();

    }
    public void fillingCreditReport(){
        nextButtonPreApproval.click();

    }

    public void fillingOutEconsent(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email =faker.internet().emailAddress();

        econsentFirstName.sendKeys(firstName);
        econsentLastName.sendKeys(lastName);
        econsentEmail.sendKeys(email);
        SeleniumUtils.jsClick(econsentAgreeButton);

        nextButtonPreApproval.click();
    }

    public List<String> getSectionHeaders(){
        List<String> headers =new ArrayList<>();
        for (WebElement sectionHeader : allSectionHeaders){
           headers.add(sectionHeader.getText());
        }
        return headers;
    }

    public WebElement getSectionLinkByTitle(String title) {
//        return Driver.getDriver().findElement(By.xpath("//span[contains(.,'"+title+"')]/parent::span/parent::a"));
        return Driver.getDriver().findElement(By.xpath("//span[@class='d-block'][.='"+title+"']/parent::span/parent::a"));
    }
}
