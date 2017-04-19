* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Use-Case Specification: See schedule

###### Version 1.0

## Table of Contents

1.  [See schedule](# 1-see-schedule)
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

## 1\. See schedule

### 1.1 Brief Description

The purpose of this use case is for a registered user to be able to see the courses he or she booked. They will be listed in a table-like format with the closest upcoming courses being displayed at the top of the list.

## 2\. Flow of Events

### 2.1 Basic Flow

![](ad_see-schedule.png)

### 2.2 Alternative Flows

#### 2.2.1

## 3\. Special Requirements

[A special requirement is typically a nonfunctional requirement that is specific to a use case, but is not easily or naturally specified in the text of the use case’s event flow. Examples of special requirements include legal and regulatory requirements, application standards, and quality attributes of the system to be built including usability, reliability, performance or supportability requirements. Additionally, other requirementssuch as operating systems and environments, compatibility requirements, and design constraintsshould be captured in this section.]

### 3.1 Functionality

When selecting a course (clicking on an item), the user will be redirected to the course info page fur further reference.

### 3.2 Usability

### 3.3 Reliability

### 3.4 Performance

### 3.5 Supportability

### 3.6 Design constraints

The list should be sorted in the way so that the most recent upcoming course should be displayed on top and maybe somehow additionally marked.

### 3.7 On-line User Documentation and Help System Requirements

### 3.8 Purchased Components

### 3.9 Interfaces

![](wf_see-schedule.png)

### 3.10 Licensing Requirements

### 3.11 Legal, Copyright, and Other Notices

### 3.12 Applicable Standards

## 4\. Preconditions

In order for the user to see courses, he has to book some first. Those will then show up in this list here.

### 4.1 Precondition One

## 5\. Postconditions

[A postcondition of a use case is a list of possible states the system can be in immediately after a use case has finished.]

### 5.1 Postcondition One

## 6\. Extension Points

[Extension points of the use case.]

### 6.1

[Definition of the location of the extension point in the flow of events.]

## 7\. Function Points

### 7.1 External Inputs

The only user input, interacting with the internal logic files of the System, is taking place through creating a new user. This interacts with one file (file type reference, or FTR) - User Login-Data file and changes 8 data element types (DET's). Therefore the complexity for this row is low.

### 7.2 External Outputs

The output visible for the user is his registration information when account is created (e-mail). User Login-Data file is interacted with to show this information, but not all of the fields are accessed and displayed. Only user name and email will be shown to the user. Therefore the complexity can be estimated as low.

### 7.3 External Inquiries

There are 4 external inquiries in the use case.
* 3 are used to register with account data from other social media
* 1 is an interaction for picking the birth date from a pop-up calendar

Two files are being referenced in this case - a calendar and a User Login-Data table. Each only have a minor amount of data element types referenced. Therefore the complexity is low.

### 7.4 Internal Logical files
The User Login-Data table is the referenced ILF, which has one logical subgroup (RET) - User, and 8 different fields (DET). Complexity is therefore low. 

### 7.5 External Interface files
Only one file is used to interact with the external interfaces. It has a minor amount of referenced fields and therefore a low complexity. 

### 7.6 FP Estimation
As a result, the use case can be estimated with 34 Function Points. 
![](fp_uc8.PNG)