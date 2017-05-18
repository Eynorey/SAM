* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Use-Case Specification: Manage course offerings [CRUD]

###### Version 1.0

## Table of Contents

1.  [Manage course offerings](# 1-offer-course)
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
    10.  [Licensing Requirements](310-licencing-requirements)
    11.  [Legal, Copyright, and Other Notices](# 311-legal-copyright-and-other-notices)
    12.  [Applicable Standards](# 312-applicable-standards)
4.  [Preconditions](# 4-preconditions)
5.  [Postconditions](# 5-postconditions)
6.  [Extension Points](# 6-extension-points)
7.  [Function Points](# 7-function-points)

## 1\. Manage course offerings

### 1.1 Brief Description

The purpose of this use case is to create and organize offered courses on the SAM platform. You need it to inform the system what you are willing to teach. After that, the system can recommend the course to users who want to learn the course's contents.

## 2\. Flow of Events

### 2.1 Basic Flow

The basic flow of the use case _Manage Course_ can be represented by the standard CRUD activity diagram. The user enters the use case by offering a new course (Create) or attempting to view the list of available courses. The two activities are connected with each other through saving or adding new item operations. Three further operations can be invoked from the course list: view details (Read), Delete and edit (Update).

![](ad_manage-course_crud.png)

A closer look at the activities, which come in place in case a user decides to offer a new course is provided in the following activity diagram.

![](ad_manage-course_create.png)

Any logged in user can click the "offer new course" button. At this point the system would show an edit form (also used in the "Update" scenario. After filling in the course details and pressing the confirm button, the system checks if the course data is valid. If not, the user is notified about the problem and asked to fill in the correct details. If the course data is valid, the course will be added to the list of offered courses, which is displayed afterwards. As the necessary steps are equal for Update and Create operation, the system is going to send an email to the participants of the course. As the list of participants is empty at this point, the email not going to be sent and the system is switching to the list overview, which is presented in the following diagram.

![](ad_manage-course_read.png)

The list of courses can be accessed by creating a new course or jumped to by pressing the corresponding menu-button. If no courses exist in the list, the "offer new course" button is going to be shown instead. Clicking on a course entry in an non-empty course list calls a screen with the course details. Two actions will be available at this point. You can either delete the course or edit the course (redirection to the course edit form). In both cases the relevant participants will be informed via email.

### 2.2 Alternative Flows

n/a

## 3\. Special Requirements

### 3.1 Functionality

See Gherkin .feature file below

[Link to file](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_git/sam-private?path=%2Fsrc%2Ftest%2Ffeatures%2Fcourse%2Fmanage_course_offerings.feature&version=GBmaster&_a=contents)

![](feature_manage-course.png)

### 3.2 Usability

### 3.3 Reliability

### 3.4 Performance

### 3.5 Supportability

### 3.6 Design constraints

### 3.7 On-line User Documentation and Help System Requirements

### 3.8 Purchased Components

### 3.9 Interfaces

![](wf_manage-course.png)

### 3.10 Licensing Requirements

### 3.11 Legal, Copyright, and Other Notices

### 3.12 Applicable Standards

## 4\. Preconditions

There is a number of preconditions, which depend on the action performed with the course entry (Create, Read, Update or Delete).

### 4.1 Precondition One (Create)

User has to be logged in on the platform in order to offer a new course.

### 4.2 Precondition Two (Read, Update, Delete)

To update or delete a course the course entry have to be existent in the list of courses displayed to the user. It also has to be offered by the user for him to update or delete it. Displaying the course is available for all the users, inclusive guest-users.

## 5\. Postconditions

Postconditions of the case depend on the action, similarly with the preconditions.

### 5.1 Postcondition One (Create)

A new course with the entered data needs to be created on the platform and appear in the available list of courses.

### 5.2 Postcondition Two (Update)

The information entered into the fields and confirmed by a user is updated in the course detail view and the list view.

### 5.3 Postcondition Three(Delete)

The course disappearse from the list of available courses.

## 6\. Extension Points

n/a

## 7\. Function Points

### 7.1 External Inputs

FTR (Files): 1 (Course)

DET (Data Elements): 6 (Date, Time, Name, Description, Tutor, Preconditions)

--> Low Complexity

### 7.2 External Outputs

FTR (Files): 1 (Course)

DET (Data Elements): 6 (Date, Time, Name, Description, Tutor, Preconditions)

--> Low Complexity

### 7.3 External Inquiries

FTR (Files): 2 (Course, User-Calendar)

DET (Data Elements): 3 (Title, Date, Time)

--> Low Complexity

### 7.4 Internal Logical files

RET (Logical Subgroups): 2 (Course, User-Calendar)

DET (Data Elements): 6 (Date, Time, Name, Description, Tutor, Preconditions)

--> Low Complexity

### 7.5 External Interface files

No external interfaces used.

### 7.6 FP Estimation

According to the estimation table below, the use case can be measured with 31 function points. 
![](fp_domain-characteristic_uc-4.png)