Feature: Login

    Scenario: Right Credentials
        When I navigate to "http://localhost:8080/#/"
        And I wait for 1 sec
        And I click on element having id "account-menu"
        And I click on element having id "login"
        And I wait for 1 sec
        And I take screenshot
        And I enter "testuser" into input field having id "username"
        And I enter "testpassword" into input field having id "password"
        And I click on element having class "btn" and text "Sign in"
        #see welcome screen
        And I wait for 2 sec
        Then element having xpath "/html/body/div[2]/div[1]/div/div/div[2]/h1" should have partial text as "Welcome"
