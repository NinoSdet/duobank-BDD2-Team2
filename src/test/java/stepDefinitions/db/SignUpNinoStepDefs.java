package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.PreApprovalPage;
import utils.DBUtils;
import utils.SeleniumUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SignUpNinoStepDefs {
    @Given("the user is on the SignUp page")
    public void the_user_is_on_the_sign_up_page() {

    }
    @When("the user enters valid info in SignUp page form fields")
    public void the_user_enters_valid_info_in_sign_up_page_form_fields(List<Map<String, String>> dataTable) {
        Map<String, String> data = dataTable.get(0);
        new PreApprovalPage().fillTheSignUpFormWithData(
                data.get("first_name"),
                data.get("last_name"),
                data.get("email"),
                data.get("password")

        );
            SeleniumUtils.waitFor(3);
    }
    @Then("the user can see the entered information in the following corresponding columns")
    public void the_user_can_see_the_entered_information_in_the_following_corresponding_columns(List<Map<String, String>> dataTable) throws SQLException {
        String actualId =null;
        try {
            actualId=getLastId();

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_user where id=" + actualId);
            Map<String, String> data = dataTable.get(0);
            SoftAssertions softAssertions = new SoftAssertions();

            softAssertions.assertThat((String) actual.get(0).get("first_name")).isEqualTo(data.get("first_name"));
            softAssertions.assertThat((String) actual.get(0).get("last_name")).isEqualTo(data.get("last_name"));
            softAssertions.assertThat((String) actual.get(0).get("email")).isEqualTo(data.get("email"));
            softAssertions.assertThat((String) actual.get(0).get("password")).isEqualTo(data.get("password"));

            softAssertions.assertAll();
        }finally{
            DBUtils.executeDelete("DELETE FROM tbl_user where id=" + actualId);
        }

    }

    private String getLastId() {
        List<List<Object>> dbResults = DBUtils.getListOfLists("SELECT MAX(id) from tbl_user");
        return dbResults.get(0).get(0).toString();
    }

    List<Map<String,Object>> actualList =null;
    @When("I send a request to retrieve duplicate usernames")
    public void i_send_a_request_to_retrieve_duplicate_usernames() {
       actualList =DBUtils.getListOfMaps("SELECT email, count(*) from tbl_user GROUP BY email HAVING count(*)>1");
    }
    @Then("the result should be empty")
    public void the_result_should_be_empty() {
        Assert.assertEquals(0, actualList.size());

    }
    String userPassword;
    @When("the user enters valid info in SignUp page form fields and clicks SignUp button")
    public void the_user_enters_valid_info_in_sign_up_page_form_fields_and_clicks_sign_up_button(List<Map<String, String>> dataTable) {
        Map<String, String> data = dataTable.get(0);
               new PreApprovalPage().fillTheSignUpFormWithData(
                data.get("first_name"),
                data.get("last_name"),
                data.get("email"),
                data.get("password")

        );
        userPassword=data.get("password");
        SeleniumUtils.waitFor(3);
    }
    @Then("the user password is encrypted with MD5")
    public void the_user_password_is_encrypted_with_md5() throws SQLException {

        String actualId =null;
        try {
            actualId=getLastId();

            List<Map<String, Object>> actual = DBUtils.getListOfMaps("SELECT * FROM tbl_user where id=" + actualId);
            Assert.assertEquals(DigestUtils.md5Hex(userPassword), actual.get(0).get("password"));
        }finally{
            DBUtils.executeDelete("DELETE FROM tbl_user where id=" + actualId);
        }


    }

}
