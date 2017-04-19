Feature: Logout
    as logged in user

    Scenario: Log out
        Given I navigate to "http://localhost:8080/"
        And I wait for 2 sec
        And I click on element having class "glyphicon-user"
        And I take screenshot
        And I click on element having class "glyphicon-log-out"
        #log out
        And I click on element having class "glyphicon-user"
        Then element having id "login" should have partial text as "Sign in"


