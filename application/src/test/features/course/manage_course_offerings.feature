Feature: Manage Course Offerings
    as logged in user

    Scenario: List courses
        Given I am on the dashboard
        When The "My courses" button is clicked
        Then The page "offered courses" is displayed

    Scenario: Create new course offering
        Given The the page "offered courses" is displayed
        When The "Offer Course" button is clicked
        Then The

    Scenario: Read course details
        Given The the page "offered courses" is displayed
        When A course is selected
        And The "Details" button is clicked
        Then The page "Course Details" is displayed

    Scenario: Update course details
        Given The the page "Course Details" is displayed
        When The "Edit" button is clicked
        Then The page "Edit Course Details" is displayed

    Scenario: Delete course



