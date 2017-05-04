Feature: Register

     Scenario: invalid email
         Given I navigate to "http://localhost:8080/#/register"
         And I wait for 1 sec
         Then I take screenshot
         #enter email without @ symbol
         And I enter "usertest.com" into input field having id "email"
         And I wait for 1 sec
         Then element having xpath "/html/body/div[2]/div[1]/div/div/div[2]/form/div[2]/div/p[2]" should have text as "Your email is invalid."

     Scenario: Password confirmation does not match
         Given I navigate to "http://localhost:8080/#/register"
         And I wait for 1 sec
         #register with different passwords
         When I enter "testuser" into input field having name "login"
         And I enter "user@test.com" into input field having id "email"
         And I enter "testpassword" into input field having id "password"
         And I enter "testpassword12345" into input field having id "confirmPassword"
         And I click on element having class "btn-primary" and text "Register"
         And I wait for 1 sec
         Then element having xpath "/html/body/div[2]/div[1]/div/div/div[1]/div[5]" should have text as "The password and its confirmation do not match!"

    Scenario: Registration successful
        Given I navigate to "http://localhost:8080/#/register"
        And I wait for 1 sec
        #register
        When I enter "testuser" into input field having name "login"
        And I enter "user@test.com" into input field having id "email"
        And I enter "testpassword" into input field having id "password"
        And I enter "testpassword" into input field having id "confirmPassword"
        And I click on element having class "btn-primary" and text "Register"
        And I wait for 2 sec
        Then element having xpath "/html/body/div[2]/div[1]/div/div/div[1]/div[1]/strong" should have partial text as "Registration saved!"
