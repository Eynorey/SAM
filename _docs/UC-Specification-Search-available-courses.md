* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Use-Case Specification: Search available courses

###### Version 1.0

## Table of Contents

1.  [Register](# 1-register)
    1.  [Brief Description](# 11-brief-description)
2.  [Flow of Events](# 2-flow-of-events)
    1.  [Basic Flow](# 21-basic-flow)
    2.  [Alternative Flows](# 22-alternative-flows)
3.  [Special Requirements](# 3-special-requirements)
    1.  [Functionality](# 31-functionality)
    2.  [Usability](# 32-usability)
    3.  [Reliability](# 33-reliability)
    4.  [Performance](# 34-performance)
    5.  [Supportability](# 35-supportability)
    6.  [Design constraints](# 36-design-constraints)
    7.  [On-line User Documentation and Help System Requirements](# 37-on-line-user-documentation-and-help-system-requirements)
    8.  [Purchased Components](# 38-purchased-components)
    9.  [Interfaces](# 39-interfaces)
    10.  [Licensing Requirements](# 310-licencing-requirements)
    11.  [Legal, Copyright, and Other Notices](# 311-legal-copyright-and-other-notices)
    12.  [Applicable Standards](# 312-applicable-standards)
4.  [Preconditions](# 4-preconditions)
5.  [Postconditions](# 5-postconditions)
6.  [Extension Points](# 6-extension-points)

## 1\. Register

### 1.1 Brief Description

The use case in question is supposed to create a tool for the user to find the courses he or she is interested in on the SAM Platform. Guests, as well as registered users, can search through courses available on the Website by clicking the "find a course" button. In the Search-View a number of search options should be presented to the user to make it easier to delimit the search to specific criteria like dates, duration, topic or teacher. After setting the desired parameters a key word can be entered into the search field. By pressing "Search"-button user confirms the search request and will be presented with the results in a list form.

## 2\. Flow of Events

### 2.1 Basic Flow

![](ad_search-available-courses.png)

### 2.2 Alternative Flows

## 3\. Special Requirements

### 3.1 Functionality

### 3.2 Usability

### 3.3 Reliability

### 3.4 Performance

### 3.5 Supportability

### 3.6 Design constraints

### 3.7 On-line User Documentation and Help System Requirements

### 3.8 Purchased Components

### 3.9 Interfaces

![](wf_search-available-courses.png)

### 3.10 Licensing Requirements

### 3.11 Legal, Copyright, and Other Notices

### 3.12 Applicable Standards

## 4\. Preconditions

There are no preconditions to this use case, as the user does not have to be registered on the platform in order to search through available courses.

## 5\. Postconditions

The following sections are listing possible states the system can be in immediately after a use case has finished.

### 5.1 Postcondition One

A number of courses found is 1 or larger. In this case a list of courses is presented under the search-field.

### 5.2 Postcondition Two

A number of courses found is 0\. In this case a notification is shown to the user, stating that the search had no success and key-words or parameters should be change in order to find needed course. A button "Create this course" should be shown below notifying the user that he can be the first one to offer a course with given parameters.

## 6\. Extension Points

The following sections represent a list of possible use case extensions.

### 6.1 Autofill

An autofill feature can be implemented to extend the use case. The search field would expand into a dynamic list of popular items searched before, starting with the same characters as the user's search-request.

### 6.2 Sort function

Along with the filters, user can be offered to filter the search results by date, rating or relevance. 