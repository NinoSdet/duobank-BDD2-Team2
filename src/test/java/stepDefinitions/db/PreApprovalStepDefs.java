package stepDefinitions.db;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pages.PreApprovalPage;
import pages.ReviewingApplicationPage;
import utils.DBUtils;
import utils.SeleniumUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class PreApprovalStepDefs {

    @Given("the user is on the sign-up pageN")
    public void the_user_is_on_the_sign_up_page() {
    }

    @When("the user enters valid username password and clicks on the sign-in buttonN")
    public void the_user_enters_valid_username_password_and_clicks_on_the_sign_in_button() {
        PreApprovalPage preApprovalPage = new PreApprovalPage();
        preApprovalPage.signIn();
        preApprovalPage.mortgageApplicationAccess();
    }

    @When("the user is redirected to the dashboard pageN")
    public void the_user_is_redirected_to_the_dashboard_page() {
    }

    @When("clicks mortgage application buttonN")
    public void clicks_mortgage_application_button() {
        PreApprovalPage preApprovalPage = new PreApprovalPage();
        preApprovalPage.mortgageApplicationAccess();
    }

    @Then("the user is redirected to the PreApproval details page")
    public void the_user_is_redirected_to_the_pre_approval_details_page() {

    }
    @Given("the user is on the PreApproval details page")
    public void the_user_is_on_the_pre_approval_details_page() {

    }

    @When("the user enters valid info in PreApproval details page form fields")
    public void the_user_enters_valid_info_in_pre_approval_details_page_form_fields(List<Map<String, String>> dataTable) {
        Map<String, String> data = dataTable.get(0);
        new PreApprovalPage().fillTheFormWithData(
                data.get("realtor_status"),
                data.get("realtor_info"),
                data.get("loan_officer_status"),
                data.get("purpose_loan"),
                data.get("est_purchase_price"),
                data.get("down_payment"),
                data.get("down_payment_percent"),
                data.get("total_loan_amount"),
                data.get("src_down_payment"),
                data.get("add_fund_available")
                );
        new PreApprovalPage().clickNext();
        new ReviewingApplicationPage().fillingOutPersonalInfo();
        new ReviewingApplicationPage().fillingExpenses();
        new ReviewingApplicationPage().fillingEmploymentAndIncome();
        new ReviewingApplicationPage().fillingCreditReport();
        new ReviewingApplicationPage().fillingOutEconsent();
        new ReviewingApplicationPage().getSubmitButton().click();
        SeleniumUtils.waitFor(3);
    }
    @Then("the user can see the entered mortgage preApproval details in the following corresponding columns")
    public void the_user_can_see_the_entered_mortgage_pre_approval_details_in_the_following_corresponding_columns(List<Map<String, String>> dataTable) throws SQLException {
       String actualId =null;
       try {
           actualId=getLastId();

           List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
           Map<String, String> data = dataTable.get(0);
           SoftAssertions softAssertions = new SoftAssertions();
           softAssertions.assertThat( actual.get(0).get("realtor_status")).isEqualTo(Integer.parseInt(data.get("realtor_status")));
           softAssertions.assertThat((String) actual.get(0).get("realtor_info")).isEqualTo(data.get("realtor_info"));
           softAssertions.assertThat( actual.get(0).get("loan_officer_status")).isEqualTo(Integer.parseInt(data.get("loan_officer_status")));
           softAssertions.assertThat((String) actual.get(0).get("purpose_loan")).isEqualTo(data.get("purpose_loan"));
           softAssertions.assertThat((String) actual.get(0).get("est_purchase_price")).isEqualTo(data.get("est_purchase_price"));
           softAssertions.assertThat((String) actual.get(0).get("down_payment")).isEqualTo(data.get("down_payment"));
           softAssertions.assertThat((String) actual.get(0).get("down_payment_percent")).isEqualTo(data.get("down_payment_percent"));
           softAssertions.assertThat((String) actual.get(0).get("total_loan_amount")).isEqualTo(data.get("total_loan_amount"));
           softAssertions.assertThat((String) actual.get(0).get("src_down_payment")).isEqualTo(data.get("src_down_payment"));
           softAssertions.assertThat((String) actual.get(0).get("add_fund_available")).isEqualTo(data.get("add_fund_available"));

           softAssertions.assertAll();
       }finally{
           DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
       }

    }


    @When("the user marks checkboxes related as {string} and {string} sections in PreApproval details page")
    public void the_user_marks_checkboxes_related_as_and_sections_in_pre_approval_details_page(String realtor_status_checkbox, String loan_officer_status_checkbox) {
        Faker faker = new Faker();
        new PreApprovalPage().fillTheFormWithData(
                realtor_status_checkbox,
                faker.name().fullName(),
                loan_officer_status_checkbox,
                "Purchase a Home",
                "560236",
                "32626",
                "5",
                "527610",
                "Other type of Down Payment",
                "20000"
        );
        new PreApprovalPage().clickNext();
        new ReviewingApplicationPage().fillingOutPersonalInfo();
        new ReviewingApplicationPage().fillingExpenses();
        new ReviewingApplicationPage().fillingEmploymentAndIncome();
        new ReviewingApplicationPage().fillingCreditReport();
        new ReviewingApplicationPage().fillingOutEconsent();
        new ReviewingApplicationPage().getSubmitButton().click();
        SeleniumUtils.waitFor(3);
    }
    @Then("the user can see in the {string} and {string} column values")
    public void the_user_can_see_in_the_and_column_values(String realtor_status, String loan_officer_status) throws SQLException {
        String actualId =null;
        try {
            actualId=getLastId();

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat( actual.get(0).get("realtor_status")).isEqualTo(Integer.parseInt(realtor_status));
            softAssertions.assertThat( actual.get(0).get("loan_officer_status")).isEqualTo(Integer.parseInt(loan_officer_status));


            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }

    }

    @When("the user enters the following information in the realtor_info, purpose_loan and src_down_payment columns in PreApproval details page")
    public void the_user_enters_the_following_information_in_the_realtor_info_purpose_loan_and_src_down_payment_columns_in_pre_approval_details_page(List<Map<String, String>> dataTable) {
        Map<String, String> data = dataTable.get(0);
        new PreApprovalPage().fillTheFormWithData(
                "Yes",
                data.get("realtor_info"),
                "Yes",
                data.get("purpose_loan"),
                "560236",
                "32626",
                "5",
                "527610",
                data.get("src_down_payment"),
                "20000"
        );
        new PreApprovalPage().clickNext();
        new ReviewingApplicationPage().fillingOutPersonalInfo();
        new ReviewingApplicationPage().fillingExpenses();
        new ReviewingApplicationPage().fillingEmploymentAndIncome();
        new ReviewingApplicationPage().fillingCreditReport();
        new ReviewingApplicationPage().fillingOutEconsent();
        new ReviewingApplicationPage().getSubmitButton().click();
        SeleniumUtils.waitFor(3);
    }
    @Then("All entered values should be stored as a String values")
    public void all_entered_values_should_be_stored_as_a_string_values() throws SQLException {
        String actualId =null;
        try {
            actualId=getLastId();

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();

            softAssertions.assertThat(actual.get(0).get("realtor_info") instanceof String);

            softAssertions.assertThat(actual.get(0).get("purpose_loan") instanceof String);

            softAssertions.assertThat(actual.get(0).get("src_down_payment") instanceof String);

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }

    }

    @When("the user enters the following information in the est_purchase_price, down_payment, down_payment_percent, total_loan_amount, add_fund_available columns in PreApproval details page")
    public void the_user_enters_the_following_information_in_the_est_purchase_price_down_payment_down_payment_percent_total_loan_amount_add_fund_available_columns_in_pre_approval_details_page(List<Map<String, String>> dataTable) {
        Map<String, String> data = dataTable.get(0);
        new PreApprovalPage().fillTheFormWithData(
                "Yes",
                "John Smith",
                "Yes",
                "Purchase a Home",
                data.get("est_purchase_price"),
                data.get("down_payment"),
                data.get("down_payment_percent"),
                data.get("total_loan_amount"),
                "Other type of Down Payment",
                data.get("add_fund_available")
        );
        new PreApprovalPage().clickNext();
        new ReviewingApplicationPage().fillingOutPersonalInfo();
        new ReviewingApplicationPage().fillingExpenses();
        new ReviewingApplicationPage().fillingEmploymentAndIncome();
        new ReviewingApplicationPage().fillingCreditReport();
        new ReviewingApplicationPage().fillingOutEconsent();
        new ReviewingApplicationPage().getSubmitButton().click();
        SeleniumUtils.waitFor(3);
    }

    @Then("All entered values should be stored as a integer values")
    public void all_entered_values_should_be_stored_as_a_integer_values() throws SQLException {
        String actualId =null;
        try {
            actualId=getLastId();

        List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actual.get(0).get("est_purchase_price") instanceof Integer);

        softAssertions.assertThat(actual.get(0).get("down_payment") instanceof Integer);

        softAssertions.assertThat(actual.get(0).get("down_payment_percent") instanceof Integer);

        softAssertions.assertThat(actual.get(0).get("total_loan_amount") instanceof Integer);

        softAssertions.assertThat(actual.get(0).get("add_fund_available") instanceof Integer);

        softAssertions.assertAll();
    }finally{
        DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
    }

}


    @When("the user enters the following data in {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} in the PreApproval details page form fields:")
    public void the_user_enters_the_following_data_in_in_the_pre_approval_details_page_form_fields(String realtor_status, String realtor_info, String loan_officer_status,
                                                                                                   String purpose_loan, String est_purchase_price, String down_payment, String down_payment_percent, String total_loan_amount, String src_down_payment, String add_fund_available) {
        new PreApprovalPage().fillTheFormWithData(
               realtor_status,
               realtor_info,
               loan_officer_status,
               purpose_loan,
               est_purchase_price,
               down_payment,
               down_payment_percent,
               total_loan_amount,
               src_down_payment,
               add_fund_available
        );
        new PreApprovalPage().clickNext();
        new ReviewingApplicationPage().fillingOutPersonalInfo();
        new ReviewingApplicationPage().fillingExpenses();
        new ReviewingApplicationPage().fillingEmploymentAndIncome();
        new ReviewingApplicationPage().fillingCreditReport();
        new ReviewingApplicationPage().fillingOutEconsent();
        new ReviewingApplicationPage().getSubmitButton().click();
        SeleniumUtils.waitFor(5);
    }

    private String getLastId(){
        List<List<Object>> dbResults = DBUtils.getListOfLists("SELECT MAX(id) from tbl_mortagage");
        return dbResults.get(0).get(0).toString();
    }
    @Then("the data should be mapped correctly to the following column names {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} in the tbl_mortagage table in the database:")
    public void the_data_should_be_mapped_correctly_to_the_following_column_names_in_the_tbl_mortagage_table_in_the_database(String realtor_status, String realtor_info, String loan_officer_status,
                                                                                                                             String purpose_loan, String est_purchase_price, String down_payment, String down_payment_percent, String total_loan_amount, String src_down_payment, String add_fund_available) throws SQLException {
        String actualId =null;
        try {

            actualId = getLastId();

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat( actual.get(0).get("realtor_status")).isEqualTo(Integer.parseInt(realtor_status));
            softAssertions.assertThat((String) actual.get(0).get("realtor_info")).isEqualTo(realtor_info);
            softAssertions.assertThat( actual.get(0).get("loan_officer_status")).isEqualTo(Integer.parseInt(loan_officer_status));
            softAssertions.assertThat((String) actual.get(0).get("purpose_loan")).isEqualTo(purpose_loan);
            softAssertions.assertThat((String) actual.get(0).get("est_purchase_price")).isEqualTo(est_purchase_price);
            softAssertions.assertThat((String) actual.get(0).get("down_payment")).isEqualTo(down_payment);
            softAssertions.assertThat((String) actual.get(0).get("down_payment_percent")).isEqualTo(down_payment_percent);
            softAssertions.assertThat((String) actual.get(0).get("total_loan_amount")).isEqualTo(total_loan_amount);
            softAssertions.assertThat((String) actual.get(0).get("src_down_payment")).isEqualTo(src_down_payment);
            softAssertions.assertThat((String) actual.get(0).get("add_fund_available")).isEqualTo(add_fund_available);

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }

    }


    @When("the user marks  Yes in the {string} and fills out the {string} field in PreApproval details page")
    public void the_user_marks_yes_in_the_and_fills_out_the_field_in_pre_approval_details_page(String realtor_status_checkbox, String realtor_info) {
         new PreApprovalPage().fillTheFormWithData(
                realtor_status_checkbox,
                realtor_info,
                "Yes",
                "Purchase a Home",
                "560236",
                "32626",
                "5",
                "527610",
                "Other type of Down Payment",
                "20000"
        );
        new PreApprovalPage().clickNext();
        new ReviewingApplicationPage().fillingOutPersonalInfo();
        new ReviewingApplicationPage().fillingExpenses();
        new ReviewingApplicationPage().fillingEmploymentAndIncome();
        new ReviewingApplicationPage().fillingCreditReport();
        new ReviewingApplicationPage().fillingOutEconsent();
        new ReviewingApplicationPage().getSubmitButton().click();
        SeleniumUtils.waitFor(3);
    }

    @Then("the user can see realtor info in the {string} and {string} column values")
    public void the_user_can_see_realtor_info_in_the_and_column_values(String realtor_status, String realtor_info) throws SQLException {
        String actualId =null;
        try {
            actualId=getLastId();

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat( actual.get(0).get("realtor_status")).isEqualTo(Integer.parseInt(realtor_status));
            softAssertions.assertThat((String) actual.get(0).get("realtor_info")).isEqualTo(realtor_info);

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }

    }

    @When("The user selects one of the {string} options")
    public void the_user_selects_one_of_the_options(String purpose_loan) {
        new PreApprovalPage().fillTheFormWithData(
                "Yes",
                "John Smith",
                "Yes",
                purpose_loan,
                "560236",
                "32626",
                "5",
                "527610",
                "Other type of Down Payment",
                "20000"
        );
        new PreApprovalPage().clickNext();
        new ReviewingApplicationPage().fillingOutPersonalInfo();
        new ReviewingApplicationPage().fillingExpenses();
        new ReviewingApplicationPage().fillingEmploymentAndIncome();
        new ReviewingApplicationPage().fillingCreditReport();
        new ReviewingApplicationPage().fillingOutEconsent();
        new ReviewingApplicationPage().getSubmitButton().click();
        SeleniumUtils.waitFor(3);
    }
    @Then("The result should be empty {string}:")
    public void the_result_should_be_empty(String purpose_loan) throws SQLException {
        String actualId =null;
        try {
            actualId=getLastId();

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_mortagage where id=" + actualId);
            SoftAssertions softAssertions = new SoftAssertions();

            softAssertions.assertThat((String) actual.get(0).get("purpose_loan")).isEqualTo(purpose_loan);

            softAssertions.assertAll();
        }finally{
            DBUtils.executeUpdate("DELETE FROM tbl_mortagage where id=" + actualId);
        }

    }
    }






