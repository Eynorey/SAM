#Feature: Register
#    as a guest user
#    I want to register an user account
#
#    Scenario: Successfully registered
#        Given the username is "newuser" and the email is "email@email.de" and the password "12345678"
#        When the register button is clicked
#        Then the register page is shown and the cssSelector is "alert-success" and the message is "Registration saved!"
#
#    Scenario: Register failed
#        Given the username is "newuser" and the email is "email@email.de" and the password "1"
#        When the register button is clicked
#        Then the register page is shown
