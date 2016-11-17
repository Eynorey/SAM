Feature: Manage Course Offerings
    as logged in user

    Scenario: List courses
        Given I am on the dashboard
        When the "My courses" button is clicked
        Then the page "offered courses" is displayed

    Scenario: Create new course offering
        Given the page "offered courses" is displayed
        When the "Offer Course" button is clicked
        Then the page "Create or edit a Course" is displayed

    Scenario: Read course details
        Given the page "offered courses" is displayed
        When A course is selected
        And the "Details" button is clicked
        Then the page "Course Details" is displayed

    Scenario: Update course details
        Given the page "Course Details" is displayed
        When the "Edit" button is clicked
        Then the page "Create or edit a Course" is displayed

    Scenario: Delete course
        Given the page "Course Details" is displayed
        When the "Delete Course" button is clicked
        Then a confirmation dialog is shown
        When the "Confirm" button is clicked
        Then the selected course will be removed from the database

