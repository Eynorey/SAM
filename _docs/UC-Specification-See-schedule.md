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

## 5\. Postconditions

n/a

## 6\. Extension Points

### 6.1 Planner

A planner function can be implemented to visualize the times in a chosen time period which are available for courses. It can be extended by homeworks from the booked courses, which could show up in the calendar mode as well. 

## 7\. Function Points

As a result, the use case can be estimated with 34 Function Points. 
![](fp_uc8.PNG)