package stepDefinitions.api;

import com.github.javafaker.Faker;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetAndPostUserStepDefsNino {

    RequestSpecification requestSpecification;
    Response response;
    @Given("the request is authenticated with a valid API key")
    public void the_request_is_authenticated_with_a_valid_api_key() {
        requestSpecification = given().
                queryParam("api_key", ConfigReader.getProperty("api_key"));
    }
    @Given("the {string} header is set to {string}")
    public void the_header_is_set_to(String key, String value) {
        requestSpecification.header(key, value);
    }
    @Given("the body is added")
    public void the_body_is_added() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password(8,16,true,true,true)+"1Rd$";



        requestSpecification.body("{\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"first_name\": \""+firstName+ "\",\n" +
                "  \"last_name\": \""+lastName+"\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}");
    }
    @When("I send a {string} request to the endpoint {string}")
    public void i_send_a_request_to_the_endpoint(String requestMethod, String endpoint) {

        if (requestMethod.equalsIgnoreCase("GET")) {
            response = requestSpecification.
                    when().log().all().
                    get(endpoint);
        } else if (requestMethod.equalsIgnoreCase("POST")) {
            response = requestSpecification.
                    when().log().all().
                    post(endpoint);
        }
    }
    @Then("the response log should be displayed")
    public void the_response_log_should_be_displayed()  {
        response.then().log().all();
    }
    @Then("the response body key {string} should be {int}")
    public void the_response_body_key_should_be(String key, Integer value) {

        response.then().body(key, equalTo(value));

    }
    @Then("the HTTP status code should be {int}")
    public void the_http_status_code_should_be(Integer statusCode) {
        response.then().
                statusCode(equalTo(statusCode));
    }
    @Then("the response body should contain key {string}")
    public void the_response_body_should_contain_key(String key) {
        response.then().body(key, greaterThan(0));
    }
    @Then("the response {string} header should be {string}")
    public void the_response_header_should_be(String key, String value) {
        response.then().
                header(key,value);

    }
    @Then("the response time should be less than {int} ms")
    public void the_response_time_should_be_less_than_ms(Integer ms) {
        response.then().
                time(lessThan((long)ms));
    }
    @Then("the response body key {string} should be {string}")
    public void the_response_body_key_should_be(String key, String value) {

        response.then().body(key, equalTo(value));

    }

    // missing api key
    @Given("the request is not provided with a valid API key")
    public void the_request_is_not_provided_with_a_valid_api_key() {
        requestSpecification = given().
                queryParam("api_key", "");
    }

    // missing input
    @Given("the body is added but missing the {string}")
    public void the_body_is_added_but_missing_the(String field) {
        requestSpecification.body(getBodyWithKeyValue(field,""));
    }

    private String getBodyWithKeyValue(String key, String value){
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String username = new Faker().name().username();
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password(8,16,true,true,true)+"1Rd$";
        Map<String, String> data = Map.of("username",username,
                "first_name", firstName,
                "last_name",lastName,
                "email",email,
                "password", password);
        Map<String,String> userData = new HashMap<>(data);
        if (userData.containsKey(key)) {
            userData.put(key, value);
        }
        try {
            return new ObjectMapper().writeValueAsString(userData);
        }catch (Exception ex){
            return "{}";
        }
    }

    // invalid email
    @Given("the body is added with an invalid email")
    public void the_body_is_added_with_an_invalid_email() {
        requestSpecification.body(getBodyWithKeyValue("email",new Faker().internet().emailAddress().replace("@", "")));
    }

    //invalid password uppercase
    @Given("the body is added with a password missing uppercase character")
    public void the_body_is_added_with_a_password_missing_uppercase_character() {
        requestSpecification.body(getBodyWithKeyValue("password",new Faker().internet().password(8,16,false,true,true).toLowerCase()));
    }

    //invalid password lowercase
    @Given("the body is added with a password missing lowercase character")
    public void the_body_is_added_with_a_password_missing_lowercase_character() {
        requestSpecification.body(getBodyWithKeyValue("password",new Faker().internet().password(8,16,true,true,true).toUpperCase()));
    }

    //invalid password number

    @Given("the body is added with a password missing number")
    public void the_body_is_added_with_a_password_missing_number() {
        requestSpecification.body(getBodyWithKeyValue("password",new Faker().internet().password(8,16,true,true,false).replace("[0-9]", "a")));
    }

    //invalid password special character
    @Given("the body is added with a password missing at least one special character")
    public void the_body_is_added_with_a_password_missing_at_least_one_special_character() {
        requestSpecification.body(getBodyWithKeyValue("password",new Faker().internet().password(8,16,true,false,true).replace("\\.[]{}()<>*+-=!?^$|", "a")));
    }
    //invalid password less than 8 characters
    @Given("the body is added with a password containing less than {int} characters")
    public void the_body_is_added_with_a_password_containing_less_than_characters(Integer int1) {
        requestSpecification.body(getBodyWithKeyValue("password",new Faker().internet().password(2,4,true,true,true)));
    }
//invalid first_name
    @Given("the body is added with an invalid first_name")
    public void the_body_is_added_with_an_invalid_first_name() {
        requestSpecification.body(getBodyWithKeyValue("first_name",new Faker().name().firstName().substring(0,1)));
    }

    //invalid last_name
    @Given("the body is added with an invalid last_name")
    public void the_body_is_added_with_an_invalid_last_name() {
        requestSpecification.body(getBodyWithKeyValue("last_name",new Faker().name().lastName().substring(0,1)));
    }

    //email already exists
    @Given("the body uses email that already exists")
    public void the_body_uses_email_that_already_exists() {
        String requestBodyValue =getBodyWithKeyValue("", "");
        requestSpecification.body(requestBodyValue);
        i_send_a_request_to_the_endpoint("POST", "/user");
        requestSpecification.body(requestBodyValue);
        i_send_a_request_to_the_endpoint("POST", "/user");

    }

}
