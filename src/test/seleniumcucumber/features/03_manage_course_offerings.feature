Feature: Manage Courses
    as logged in user

    Scenario: Create course, Read it
        Given I navigate to "http://localhost:8080/#/"
        Given I navigate to "http://localhost:8080/#/course"
        And I wait for 2 sec
        #create course
        When I click on element having class "hidden-xs-down" and text "Create new Course"
        And I wait for 1 sec
        And I take screenshot
        And I enter "Test Title" into input field having id "field_title"
        And I enter "Test Description" into input field having id "field_description"
        And I enter "2016-11-01 08:00" into input field having id "field_start"
        And I enter "2016-11-01 17:00" into input field having id "field_end"
        And I enter "Test location" into input field having id "field_location"
        And I click on element having class "glyphicon-save"
        And I wait for 1 sec
        #read course
        And I click on element having class "glyphicon-eye-open"
        And I wait for 1 sec
        Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[1]/span" should have text as "Test Title"
        Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[2]/span" should have text as "Test Description"
        Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[3]/span" should have text as "Nov 1, 2016 8:00:00 AM"
        Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[4]/span" should have text as "Nov 1, 2016 5:00:00 PM"
        Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[5]/span" should have text as "Test location"

   Scenario: Update course, Read it
       Given I navigate to "http://localhost:8080/#/course"
       And I wait for 2 sec
       #update course
       When I click on element having class "glyphicon-pencil"
       And I wait for 1 sec
       And I clear input field having id "field_title"
       And I enter "Edited Title" into input field having id "field_title"
       And I clear input field having id "field_description"
       And I enter "Edited Description" into input field having id "field_description"
       And I click on element having class "glyphicon-save"
       And I wait for 1 sec
       #read course
       And I click on element having class "glyphicon-eye-open"
       And I wait for 1 sec
       Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[1]/span" should have text as "Edited Title"
       Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[2]/span" should have text as "Edited Description"
       Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[3]/span" should have text as "Nov 1, 2016 8:00:00 AM"
       Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[4]/span" should have text as "Nov 1, 2016 5:00:00 PM"
       Then element having xpath "/html/body/div[2]/div[1]/div/dl/dd[5]/span" should have text as "Test location"

   Scenario: Delete course
       Given I navigate to "http://localhost:8080/#/course"
       And I wait for 2 sec
       #delete course
       When I click on element having class "glyphicon-remove-circle"
       And I wait for 1 sec
       And I click on element having class "glyphicon-remove-circle"
       And I wait for 1 sec
       #see confirmation
       Then element having xpath "/html/body/div[2]/div[1]/div/jhi-alert/div/div/div/div/pre" should have partial text as "A course is deleted"

    Scenario: Enter date with wrong format
       Given I navigate to "http://localhost:8080/#/course"
       And I wait for 2 sec
       #create course
       When I click on element having class "hidden-xs-down" and text "Create new Course"
       And I wait for 1 sec
       And I enter "Test Title" into input field having id "field_title"
       And I enter "Test Description" into input field having id "field_description"
       And I enter "yesterday" into input field having id "field_start"
       And I enter "20161101 17:00" into input field having id "field_end"
       And I enter "Test location" into input field having id "field_location"
       And I wait for 1 sec
       #unable to click save
       Then element having class "btn-primary" should be disabled
