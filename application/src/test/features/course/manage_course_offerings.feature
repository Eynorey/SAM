Feature: Manage Course Offerings
    as logged in user

    Scenario: List courses
        Given I am on the dashboard
        When The "My courses" button is clicked
        Then The the page "offered courses" is displayed

    Scenario: Create new course offering

    Scenario: Read course details
        Given The the page "offered courses" is displayed
        When A course is selected
        When The "Details" button is clicked
        Then The the page "Course Details" is displayed

    Scenario: Update course details
        Given The the page "Course Details" is displayed
        When The "Edit" button is clicked
        Then The the page "Edit Course Details" is displayed

    Scenario: Delete course



