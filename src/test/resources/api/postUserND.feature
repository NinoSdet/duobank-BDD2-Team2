Feature: POST /user API endpoint features


@api
Scenario: Create  new user successfully

Given the request is authenticated with a valid API key
And the "Content-type" header is set to "application/json"
And the body is added
When I send a "POST" request to the endpoint "/user"
Then the response log should be displayed
Then the response body key "status" should be 1
Then the HTTP status code should be 201
Then the response body should contain key "user_id"
And the response "Content-Type" header should be "application/json"
And the response time should be less than 500 ms
And the response body key "message" should be "The user has been created."

@api
Scenario: Create  new user with a missing API key

  Given the request is not provided with a valid API key
  And the "Content-type" header is set to "application/json"
  And the body is added
  When I send a "POST" request to the endpoint "/user"
  Then the HTTP status code should be 401
  And the response body key "message" should be "Invalid or missing API Key. Provide a valid api key with 'api_key' query parameter."


  @api
  Scenario: Create  new user with a missing first_name

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added but missing the "first_name"
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Missing or Invalid Required Fields!"

  @api
  Scenario: Create  new user with a missing last_name

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added but missing the "last_name"
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Missing or Invalid Required Fields!"

  @api
  Scenario: Create  new user with a missing last_name

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added but missing the "email"
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Missing or Invalid Required Fields!"

  @api
  Scenario: Create  new user with a missing last_name

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added but missing the "password"
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Missing or Invalid Required Fields!"

  @api
  Scenario: Create  new user with an invalid email

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added with an invalid email
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Invalid Email Address!"

  @api
  Scenario: Create  new user with a password missing uppercase character

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added with a password missing uppercase character
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Password must be at least 8 characters long and contain at least one uppercase character, one lowercase character, one number, and one special symbol (!@#$%^&*()-_=+{};:,<.>)!"

  @api
  Scenario: Create  new user with a password missing lowercase character

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added with a password missing lowercase character
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Password must be at least 8 characters long and contain at least one uppercase character, one lowercase character, one number, and one special symbol (!@#$%^&*()-_=+{};:,<.>)!"

  @api
  Scenario: Create  new user with a password missing number

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added with a password missing number
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Password must be at least 8 characters long and contain at least one uppercase character, one lowercase character, one number, and one special symbol (!@#$%^&*()-_=+{};:,<.>)!"

  @api
  Scenario: Create  new user with a password missing at least one special character

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added with a password missing at least one special character
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Password must be at least 8 characters long and contain at least one uppercase character, one lowercase character, one number, and one special symbol (!@#$%^&*()-_=+{};:,<.>)!"

  @api
  Scenario: Create  new user with a password containing less than 8 characters

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added with a password containing less than 8 characters
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Password must be at least 8 characters long and contain at least one uppercase character, one lowercase character, one number, and one special symbol (!@#$%^&*()-_=+{};:,<.>)!"

  @api
  Scenario: Create  new user with an invalid first_name

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added with an invalid first_name
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "First name must be at least 2 characters long!"

  @api
  Scenario: Create  new user with an invalid last_name

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added with an invalid last_name
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response body key "message" should be "Last name must be at least 2 characters long!"

  @api
  Scenario: Create  new user fails if email already exists

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body uses email that already exists
    Then the response log should be displayed
    Then the response body key "success" should be 0
    Then the HTTP status code should be 422
    And the response body key "message" should be "This e-mail is already in use!"
