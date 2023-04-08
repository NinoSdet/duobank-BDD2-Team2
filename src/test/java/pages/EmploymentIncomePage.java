package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

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

    //***************************

    @FindBy(xpath = "//select[@id='state1']//option")
    private List<WebElement> states;

    public List<WebElement> getStates() {
        return states;
    }

        @FindBy(xpath = "//a[@aria-controls='employer1']//i[@class='bx bx-minus']")
        private WebElement employer1Maximize;

        @FindBy(xpath = "//a[@aria-controls='employer1']//i[@class='bx bx-plus']")
        private WebElement employer1Minimize;

        @FindBy(id="clear1")
        private WebElement currentJobClearButton;

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


        @FindBy(xpath = "//a[@aria-controls='employer2']//i[@class='bx bx-minus']")
        private WebElement employer2Maximize;

        @FindBy(xpath = "//a[@aria-controls='employer2']//i[@class='bx bx-plus']")
        private WebElement employer2Minimize;

        @FindBy(id="clear2")
        private WebElement previousJob1ClearButton;

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


    }
