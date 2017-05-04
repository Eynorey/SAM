* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Use-Case Specification: See available credits

###### Version 1.0

## Table of Contents

1.  [See available credits](# 1-See available credits)
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
7.  [Function Points](# 7-function-points)

## 1\. See available credits

### 1.1 Brief Description

Implementation of this use case will allow the user to have an overview over his or her credits on the platform. Only registered users will have access to this functionality, as there is no way for a guest to take a course offered by SAM. Therefore the information about available credits is going to be placed on the user's personal page, or "classroom", along with other data necessary to manage acquired skills (not included in this use case).

## 2\. Flow of Events

### 2.1 Basic Flow

![](ad_see-available-credits.png)

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

### 
![](wf_see-available-credits.png)
 3.10 Licensing Requirements

### 3.11 Legal, Copyright, and Other Notices

### 3.12 Applicable Standards

## 4\. Preconditions

The main preconditions are: 

*   The user is registered on the platform
*   The user is logged in

## 5\. Postconditions

n/a

## 6\. Extension Points

### 6.1 Earn more

The user can be offered options to earn more credits after a click on the available amount in his personal page. 

### 6.2 Information

The information about the credit points and the payment system on the platform can be shown to the user with a tooltip or a question mark icon next to the available amount.

## 7\. Function Points

### 7.1 External inputs
No External Inputs used. 
### 7.2 External outputs
FTR (Files): 1 (User-Info)

DET (Data Elements): 3 (Creditpoints)

--> Low Complexity
### 7.3 External Inquiries
FTR (Files): 1 (User-Info)

DET (Data Elements): 2 (Creditpoints, UserId)

--> Low Complexity
### 7.4 Internal Logical files
RET (Logical Subgroups): 1 (User)

DET (Data Elements): 2 (UserId, Creditpoints)

--> Low Complexity
### 7.5 External Interface files
No external interfaces used.
### 7.6 FP Estimation

The amount of function points for this use case is 12. 

![](fp_domain-characteristic_uc-5.png)