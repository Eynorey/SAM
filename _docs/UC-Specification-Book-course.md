* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Use-Case Specification: Book Course

###### Version 1.0

## Table of Contents

1.  [Book Course](# 1-Book Course)
    1.  [Brief Description](#briefdescription)
    2. Mockup
    3. Screenshot
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
7.  [Function Points](# 7-function-points)

## 1\. Book Course

### 1.1 <a name="briefdescription">Brief Description</a>

Implementation of this use case will allow the user to book a course and by that get in touch with somebody who can teach him or her interesting topics. Only registered users will have access to this functionality, as there is no way for a guest to take a course offered by SAM.

### 1.2 Mockup

![](wf_book-course.png)

### 1.3 Screenshot 

## 2\. Flow of Events

### 2.1 Basic Flow

![](ad_book-course.png)

### 2.2 Alternative Flows

No specified alternative flows.

## 3\. Special Requirements

No special requirements.

## 4\. Preconditions

The main preconditions for this use case are:

1.  User is registered at SAM
2.  User is logged in

## 5\. Postconditions

## 6\. Extension Points

Future implementation may contain further activities for managing credit points, such as buttons like "Earn more", which redirects you to a list of courses demanded on a platform (possibly sorted based on your skill tree).

### 6.1

The extension point would follow the "view available credit points" activity.

## 7\. Function Points

### 7.1 External Inputs

No external inputs.

### 7.2 External Outputs

FTR (Files): 1 (Course)

DET (Data Elements): 1 (User name)

--> Low Complexity

### 7.3 External Inquiries

FTR (Files): 1 (Course)

DET (Data Elements): 3 (Title, Description, Time)

--> Low Complexity

### 7.4 Internal Logical files

RET (Logical Subgroups): 1 (Course)

DET (Data Elements): 1 (BookedBy)

--> Low Complexity

### 7.5 External Interface files

No external interfaces used.

### 7.6 FP Estimation


As a result, the use case can be estimated with 23 Function Points. 

![](fp_domain-characteristic_uc-7.PNG)