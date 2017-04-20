* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Use-Case Specification: Login/Logout

###### Version 1.0

## Table of Contents

1.  [Login/Logout](# 1-Login/Logout)
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
7.  [Function Points](# 6-function-points)

## 1\. Login/Logout

### 1.1 Brief Description

Implementation of this use case will allow the user to change his or her status as registered on the platform. Logging out will make the system apply restrictions, implied for a guest on the website. Logging in will reverse those restrictions. 

## 2\. Flow of Events

### 2.1 Basic Flow

### 2.2 Alternative Flows

No specified alternative flows.

## 3\. Special Requirements

### 3.1 Functionality

It is required, that the user can log in using various other accounts he or she posesses in the social media such as Facebook, Google and Twitter. Three separate buttons should lead the user to respective log in screens. 

### 3.2 Usability

### 3.3 Reliability

### 3.4 Performance

### 3.5 Supportability

### 3.6 Design constraints

### 3.7 On-line User Documentation and Help System Requirements

### 3.8 Purchased Components

### 3.9 Interfaces

### 
![](wf_login-logout.png)
 3.10 Licensing Requirements
n/a
### 3.11 Legal, Copyright, and Other Notices

n/a

### 3.12 Applicable Standards

## 4\. Preconditions

The preconditions vary according to the use case (Login or Logout). 

### 4.1 Precondition One (Login)

The user is expected to be logged out, seen as a guest by the system. 

### 4.2\. Precondition Two (Logout)

The user is expected to be recognized as a registered user. 

## 5\. Postconditions

There are two possible postconditions for the Login/Logout use cases.

### 4.2 Postcondition One

In this postcondition the user is logged in after trying to login or logout. The system identifies the user as a registered user and platform functions are available respectively.

Login: expected postcondition

Logout: error logging out (to be eliminated)

### 4.3 Postcondition Two

In this postcondition the user is logged out. The system identifies the user as a guest and restricts access to specific platform functions (profile management, schedule, etc.)

Login: error while logging in (wrong user data)

Logout: expected postcondition

## 6\. Extension Points

n/a

## 7\. Function Points

The combination of Login and Logout use cases reach the value of 40 function points.

![](fp_domain-characteristic_uc-2.png)