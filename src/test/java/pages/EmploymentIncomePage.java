package pages;

import com.github.javafaker.Faker;
import io.cucumber.java.an.E;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class EmploymentIncomePage {

    public EmploymentIncomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




    //login *************************
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
    @FindBy(id = "b_marital")
    private WebElement borrowerMaritalStatusDropdown;



    //Expenses
    @FindBy(id = "monthlyrentalpayment")
    private WebElement monthlyRentalExpenses;

    public void enterMonthlyRent() {
        monthlyRentalExpenses.sendKeys("1850.00");
    }




    //***************************

    @FindBy(xpath = "//select[@id='state1']//option")
    private List<WebElement> states;

    public List<WebElement> getStates() {
        return states;
    }

        @FindBy(xpath = "//a[@aria-controls='employer1']//i[@class='bx bx-minus']")
        private WebElement employer1Maximize;

    public void clickOnEmployer1tab() {
        employer1Maximize.click();

    }

        @FindBy(id="state1")
        private WebElement statesDropdown;

        public void clickOnStateDropdown() {
            statesDropdown.click();
        }

        @FindBy(xpath = "//a[@aria-controls='employer1']//i[@class='bx bx-plus']")
        private WebElement employer1Minimize;

        @FindBy(id="clear1")
        private WebElement currentJobClearButton;

        public void clickOnClearButton1() {
            currentJobClearButton.click();
        }

    @FindBy(id="grossmonthlyincome-error")
    private WebElement grossMontlyIncomeErrorMessage;



        @FindBy(id="currentjob1")
        private WebElement currentJobCheckbox;

        @FindBy(id="employername1")
        private WebElement currentJobEmployerName;

        @FindBy(id="position1")
        private WebElement currentJobPosition;

        @FindBy(id="city")
        private WebElement currentJobCity;

        @FindBy(id="start_date1")
        private WebElement currentJobStartDate;

        @FindBy(xpath = "//button[@class='swal2-confirm btn btn-warning']")
        private WebElement clearWarningYes;

        @FindBy(xpath = "//button[@class='swal2-cancel btn btn-danger ml-1']")
        private WebElement clearWarningCancel;
        public void clickCancelOnWarningMessage() {
            clearWarningCancel.click();
        }


        @FindBy(id="remove2")
        private WebElement removeButton2;

        public void clickOnRemoveButton2() {
        removeButton2.click();
    }




        @FindBy(id="addemployer")
        private WebElement addAnotherEmployerButton;

        public void addAnotherEmployerButton() {
        addAnotherEmployerButton.click();

    }


        @FindBy(xpath = "//a[@aria-controls='employer2']//i[@class='bx bx-minus']")
        private WebElement employer2Maximize;

        @FindBy(xpath = "//a[@aria-controls='employer2']//i[@class='bx bx-plus']")
        private WebElement employer2Minimize;

        @FindBy(id="start_date1")
        private WebElement startDate1;

        @FindBy(id="end_date1")
        private WebElement endDate1;

        public void job1Dates() {
        startDate1.sendKeys("01/10/2019");
        endDate1.sendKeys("03/15/2022");
    }

        @FindBy(id="clear2")
        private WebElement previousJob1ClearButton;

        public void clickOnClearButton2() {
            previousJob1ClearButton.click();
        }

        @FindBy(id="currentjob2")
        private WebElement previousJob1Checkbox;

        @FindBy(id="employername2")
        private WebElement previousJob1EmployerName;

        @FindBy(id="position2")
        private WebElement previousJob1Position;

        @FindBy(id="city2")
        private WebElement previousJob1City;

        @FindBy(id="start_date2")
        private WebElement previousJob1StartDate;

        @FindBy(id="grossmonthlyincome")
        private WebElement grossMonthlyIncome;

        @FindBy(id="monthlyovertime")
        private WebElement monthlyOvertime;

        @FindBy(id="monthlybonuses")
        private WebElement monthlyBonuses;

        @FindBy(id="monthlycommission")
        private WebElement monthlyCommission;

        @FindBy(id="monthlydividents")
        private WebElement monthlyDividents;


        @FindBy(xpath = "//div[@class='borrowertotalmonthlyincome']")
        private WebElement totalMonthlyIncomeCalculated;

        @FindBy(id="incomesource1")
        private WebElement incomeSource1;

        @FindBy(id="amount1")
        private WebElement incomeSourceAmount1;

        @FindBy(id="incomesource2")
        private WebElement incomeSource2;

        @FindBy(id="amount2")
        private WebElement incomeSourceAmount2;

        @FindBy(id="incomesource3")
        private WebElement incomeSource3;

        @FindBy(id="amount3")
        private WebElement incomeSourceAmount3;

        @FindBy(xpath = "//a[@href='#previous']")
        private WebElement previousButton;


        @FindBy(xpath = "//a[@href='#next']")
        private WebElement nextButton;

        @FindBy(xpath = "//select[@id='state1']//option")
        private List<WebElement> listOfStates;

        @FindBy(xpath = "//select[@id='state1']")
        private WebElement listOfStatesSelect;

        @FindBy(id="swal2-content")
        private WebElement WarningMessageBlock;

        @FindBy(xpath = "//h6[@class='py-50'][2]")
        private WebElement BorrowerGrossMonthlyEmploymentIncomeSection;

        @FindBy(xpath="//label[@for='grossmonthlyincome']")
        private WebElement grossMonthlyIncomeLabel;

        @FindBy(xpath="//label[@for='monthlyovertime']")
        private WebElement monthlyOvertimeLabel;

        @FindBy(xpath="//label[@for='monthlybonuses']")
        private WebElement monthlyBonusesLabel;

        @FindBy(xpath="//label[@for='monthlycommission']")
        private WebElement monthlyCommissionsLabel;

        @FindBy(xpath="//label[@for='monthlydividents']")
        private WebElement monthlyDividentsLabel;




// work thru steps to get to my page

    public void stepsTillEmploymentAndIncome() {
        this.username.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
        this.signInButton.click();
        new EmploymentIncomePage().mortgageApplicationAccess();
        new EmploymentIncomePage().fillingOutPreApproval();
        new EmploymentIncomePage().personalInfo();
        new EmploymentIncomePage().fillingExpenses();
    }

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
    public void personalInfo() {
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

    public void fillingExpenses() {
        monthlyRentalExpenses.sendKeys("2565");
        nextButtonPreApproval.click();
    }
    public void selectIncomeSource1() {
        Select incomeSourceDropdown1 = new Select(incomeSource1);
        incomeSourceDropdown1.selectByVisibleText("Interest and Dividends");
    }
    public void selectIncomeSource2() {
        Select incomeSourceDropdown2 = new Select(incomeSource2);
        incomeSourceDropdown2.selectByVisibleText("VA Compensation");
    }

    public void selectIncomeSource3() {
        Select incomeSourceDropdown3 = new Select(incomeSource3);
        incomeSourceDropdown3.selectByVisibleText("Other Types of Income");

    }
    public void selectStateFromDropdown() {
        Select statesDropDown = new Select(statesDropdown);
        statesDropDown.selectByVisibleText("Arizona (AZ)");
    }

    public void selectIncomeSource() {
        EmploymentIncomePage employmentIncomePage = new EmploymentIncomePage();
        employmentIncomePage.incomeSource1.click();
        employmentIncomePage.incomeSource2.click();
        employmentIncomePage.incomeSource3.click();
    }


    //employer income related codes
    public void employerInfo1 (String employer1, String position1, String city1){
        getCurrentJobEmployerName().sendKeys(employer1);
        getCurrentJobPosition().sendKeys(position1);
        getCurrentJobCity().sendKeys(city1);
    }

    public void employerInfo2 (String employer2, String position2, String city2){
        getPreviousJob1EmployerName().sendKeys(employer2);
        getPreviousJob1Position().sendKeys(position2);
        getPreviousJob1City().sendKeys(city2);
    }

    public void mainIncome (String gross, String overtime, String bonuses, String commissions, String interests){
        getGrossMonthlyIncome().sendKeys(gross);
        getMonthlyOvertime().sendKeys(overtime);
        getMonthlyBonuses().sendKeys(bonuses);
        getMonthlyCommission().sendKeys(commissions);
        getMonthlyDividents().sendKeys(interests);
    }

    public void additionalIncome (String income1, String income2, String income3){
        getIncomeSourceAmount1().sendKeys(income1);
        getIncomeSourceAmount2().sendKeys(income2);
        getIncomeSource3().sendKeys(income3);

    }

// make the names of states as list
    public List<String> getStatesAsList() {

        List<String> states = new ArrayList<>();
        Select allStatesSelect = new Select(listOfStatesSelect);
        SeleniumUtils.waitFor(2);
        for(WebElement option: allStatesSelect.getOptions()){
            states.add(option.getText());
        }

        states.remove("--Select--");
        Collections.sort(states);
        return states;
    }


    }

    //click on employer1 button
// click on This is my current job checkbox to check
// click on This is my current job checkbox to un-check
// enter employer info
//click on clear
//click on Cancel of warning message
//select start date
//enter employer2 info
//select start and end date
//enter $ amounts in main income
//select source and enter $ amounts in additional income
//click on next
