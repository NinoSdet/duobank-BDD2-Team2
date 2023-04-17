package stepDefinitions.db;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.EmploymentIncomePage;
import pages.PreApprovalPage;
import pages.ReviewingApplicationPage;
import utils.DBUtils;
import utils.SeleniumUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class PersonalInfoStepDefs {


@Given("the user is on the sign-up pageD")
public void the_user_is_on_the_sign_up_page_d() {

        }
@When("the user enters valid username password and clicks on the sign-in buttonD")
public void the_user_enters_valid_username_password_and_clicks_on_the_sign_in_button_d() {
    PreApprovalPage preApprovalPage = new PreApprovalPage();
    preApprovalPage.signIn();
    preApprovalPage.mortgageApplicationAccess();
        }
@When("the user is redirected to the dashboard pageD")
public void the_user_is_redirected_to_the_dashboard_page_d() {

        }
@When("clicks mortgage application buttonD")
public void clicks_mortgage_application_button_d() {
    PreApprovalPage preApprovalPage = new PreApprovalPage();
    preApprovalPage.mortgageApplicationAccess();
        }
@Then("the user is redirected to the Personal details pageD")
public void the_user_is_redirected_to_the_personal_details_page_d() {

        }

    @When("I enter the borrower's information:")
    public void enterBorrowerInformation(List<Map<String, String>> dataTable) throws SQLException {
    new ReviewingApplicationPage().fillingOutPreApproval();
    Map<String, String> data = dataTable.get(0);
        new ReviewingApplicationPage().fillThePersonalInfoFormWithData(
                data.get("First Name"),
                data.get("Middle Name"),
                data.get("Last Name"),
                data.get("Suffix"),
                data.get("Email"),
                data.get("Date of Birth"),
                data.get("SSN"),
                data.get("Marital Status"),
                data.get("Cell"),
                data.get("Home")
        );
        new PreApprovalPage().clickNext();
        new ReviewingApplicationPage().fillingExpenses();
        new ReviewingApplicationPage().fillingEmploymentAndIncome();
        new ReviewingApplicationPage().fillingCreditReport();
        new ReviewingApplicationPage().fillingOutEconsent();
        new ReviewingApplicationPage().getSubmitButton().click();
        SeleniumUtils.waitFor(3);





    // Code to enter borrower's information
//        String firstName = borrowerInfo.get(1).get(0);
//        String middleName = borrowerInfo.get(1).get(1);
//        String lastName = borrowerInfo.get(1).get(2);
//        String suffix = borrowerInfo.get(1).get(3);
//        String email = borrowerInfo.get(1).get(4);
//        String dob = borrowerInfo.get(1).get(5);
//        String ssn = borrowerInfo.get(1).get(6);
//        String maritalStatus = borrowerInfo.get(1).get(7);
//        String cell = borrowerInfo.get(1).get(8);
//        String home = borrowerInfo.get(1).get(9);
//        String realtor_info = borrowerInfo.get(1).get(10);

//        // Code to store borrower's information in the database
//        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//        String sql = "INSERT INTO tbl_mortagage (b_firstName, b_middleName, b_lastName, b_suffix, b_email, b_dob, b_ssn, b_marital, b_cell, b_home, realtor_info) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, firstName);
//        statement.setString(2, middleName);
//        statement.setString(3, lastName);
//        statement.setString(4, suffix);
//        statement.setString(5, email);
//        statement.setString(6, dob);
//        statement.setString(7, ssn);
//        statement.setString(8, maritalStatus);
//        statement.setString(9, cell);
//        statement.setString(10, home);
//        statement.setString(11, realtor_info);
//        statement.executeUpdate();
    }
    private String getLastId(){
        List<List<Object>> dbResults = DBUtils.getListOfLists("SELECT MAX(id) from tbl_mortagage");
        return dbResults.get(0).get(0).toString();
    }
    @Then("the borrower's information should be stored in the tbl_mortagage table in the database")
    public void the_borrower_s_information_should_be_stored_in_the_tbl_mortagage_table_in_the_database(List<Map<String, String>> dataTable) throws SQLException {
        String actualId =null;
        try {
            actualId=getLastId();

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            Map<String, String> data = dataTable.get(0);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat( actual.get(0).get("b_firstName")).isEqualTo(data.get("b_firstName"));
            softAssertions.assertThat((String) actual.get(0).get("b_middleName")).isEqualTo(data.get("b_middleName"));
            softAssertions.assertThat( actual.get(0).get("b_lastName")).isEqualTo(data.get("b_lastName"));
            softAssertions.assertThat((String) actual.get(0).get("b_suffix")).isEqualTo(data.get("b_suffix"));
            softAssertions.assertThat((String) actual.get(0).get("b_email")).isEqualTo(data.get("b_email"));
            softAssertions.assertThat((String) actual.get(0).get("b_dob")).isEqualTo(data.get("b_dob"));
            softAssertions.assertThat((String) actual.get(0).get("b_ssn")).isEqualTo(data.get("b_ssn"));
            softAssertions.assertThat((String) actual.get(0).get("b_marital")).isEqualTo(data.get("b_marital"));
            softAssertions.assertThat((String) actual.get(0).get("b_cell")).isEqualTo(data.get("b_cell"));
            softAssertions.assertThat((String) actual.get(0).get("b_home")).isEqualTo(data.get("b_home"));

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }

    }

}

