* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Use-Case Specification: Book Course
###### Version 1.0

## Table of Contents

1.  [Register](# 1-Book Course)
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

## 1\. Book Course

### 1.1 Brief Description

Implementation of this use case will allow the user to book a course and by that get in touch with somebody who can teach him or her interesting topics. Only registered users will have access to this functionality, as there is no way for a guest to take a course offered by SAM.

## 2\. Flow of Events

### 2.1 Basic Flow

![](ad_book-course.png)

### 2.2 Alternative Flows

No specified alternative flows.

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

![](wf_book-course.png)

3.10 Licensing Requirements

### 3.11 Legal, Copyright, and Other Notices

### 3.12 Applicable Standards

## 4\. Preconditions

The main preconditions for this use case are:

1.  User is registered at SAM
2.  User is logged in

## 5\. Postconditions

## 6\. Extension Points

Future implementation may contain further activities for managing credit points, such as buttons like "Earn more", which redirects you to a list of courses demanded on a platform (possibly sorted based on your skill tree).

### 6.1

The extension point would follow the "view available credit points" activity.