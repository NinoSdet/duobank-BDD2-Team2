package stepDefinitions.db;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.EmploymentIncomePage;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class PersonalInfoStepDefs {
    private static final String DB_URL = "jdbc:mysql://apps-database.cb72canasobc.us-east-2.rds.amazonaws.com/loan";
    private static final String DB_USER = "duotech";
    private static final String DB_PASSWORD = "duotech2023";

    private Connection conn;
    @When("I enter the borrower's information:")
    public void enterBorrowerInformation(List<List<String>> borrowerInfo) throws SQLException {
        // Code to enter borrower's information
        String firstName = borrowerInfo.get(1).get(0);
        String middleName = borrowerInfo.get(1).get(1);
        String lastName = borrowerInfo.get(1).get(2);
        String suffix = borrowerInfo.get(1).get(3);
        String email = borrowerInfo.get(1).get(4);
        String dob = borrowerInfo.get(1).get(5);
        String ssn = borrowerInfo.get(1).get(6);
        String maritalStatus = borrowerInfo.get(1).get(7);
        String cell = borrowerInfo.get(1).get(8);
        String home = borrowerInfo.get(1).get(9);
        String realtor_info = borrowerInfo.get(1).get(10);

        // Code to store borrower's information in the database
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        String sql = "INSERT INTO tbl_mortagage (b_firstName, b_middleName, b_lastName, b_suffix, b_email, b_dob, b_ssn, b_marital, b_cell, b_home, realtor_info) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, firstName);
        statement.setString(2, middleName);
        statement.setString(3, lastName);
        statement.setString(4, suffix);
        statement.setString(5, email);
        statement.setString(6, dob);
        statement.setString(7, ssn);
        statement.setString(8, maritalStatus);
        statement.setString(9, cell);
        statement.setString(10, home);
        statement.setString(11, realtor_info);
        statement.executeUpdate();
    }



}