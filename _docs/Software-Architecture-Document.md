* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Software Architecture Document

###### Version 1.0

## Table of Contents

1.  [Introduction](# 1---introduction)
    1.  [Purpose](# 11-purpose)
    2.  [Scope](# 12-scope)
    3.  [Definitions, Acronyms, and Abbreviations](# 13-definitions-acronyms-and-abbreviations)
    4.  [References](# 14-references)
    5.  [Overview](# 15-overview)
2.  [Architectural Representation](# 2---architectural-representation)
3.  [Architectural Goals and Constraints](# 3---architectural-goals-and-constraints)
4.  [Use-Case View](# 1---use-case-view)
    1.  [Use-Case Realizations](# 11-use-case-realizations)
5.  [Logical View](# 2---logical-view)
    1.  [Overview](# 11-overview)
    2.  [Architecturally Significant Design Packages](# 11-architecturally-significant-design-packages)
6.  [Process View](# 3---process-view)
7.  [Deployment View](# 3---deployment-view)
8.  [Implementation View](# 3---implementation-view)
    1.  [Overview](# 11-overview)
    2.  [Layers](# 11-layers)
9.  [Data View](# 3---data-view)
10.  [Size and Performance](# 3---size-and-performance)
11.  [Quality](# 3---quality)

# Software Architecture Document

## 1\. Introduction

### 1.1 Purpose

### 1.2 Scope

### 1.3 Definitions, Acronyms, and Abbreviations

### 1.4 References

| Title | Date | Publishing organization |
| --- | --- | --- |
| [Project Glossary](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/wiki/ProjectGlossary) | 23/10/16 | SAM Initiative |
| [Project Blog](https://smartifytheworld.wordpress.com/) | 27/10/16 | SAM Initiative |
| [UC-Estimations](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki#/wiki/Time-estimation) | 06/04/17 | SAM Initiative |
| [UC Specification Register](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/docs/UC-Specification-Register) | 11/11/16 | SAM Initiative |
| [UC Specification Login/Logout](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki?/docs#/docs/UC-Specification-Login-Logout) | 19/04/17 | SAM Initiative |
| [UC Specification Manage Course](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/docs/UC-Specification-ManageCourse) | 11/11/16 | SAM Initiative |
| [UC Specification See available credits](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki?/docs#/docs/UC-Specification-See-available-credits) | 11/04/17 | SAM Initiative |
| [UC Specification Search available courses](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki?/docs#/docs/UC-Specification-Search-available-courses) | 11/04/17 | SAM Initiative |
| [UC Specification Book Course](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki?/docs#/docs/UC-Specification-Book-course) | 12/04/17 | SAM Initiative |
| [UC Specification See schedule](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki?/docs#/docs/UC-Specification-See-schedule) | 11/04/17 | SAM Initiative |
| [UC Specification Manage Account](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki?/docs#/docs/UC-Specification-Manage-account) | 13/04/17 | SAM Initiative |
| [Test Plan](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki?/docs#/docs/TestPlan) | 27/04/17 | SAM Initiative |
| [Software Requirements Specification](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/ms-devlabs.wiki.wiki?/docs#/docs/SRS) | 11/11/16 | SAM Initiative |

### 1.5 Overview

## 2\. Architectural Representation

The project SAM will use the MVC-principles. We will use Spring as our framework, which delivers the necessary tools to define the project architecture.

![](spring-mvc.jpeg)

## 3\. Architectural Goals and Constraints

The main goal of the MVC architecture is to separate the view from the logic. Therefore, the view does not implement any logic, but gets all the precompiled information from the controller. Spring as utilized by JHipster automatically creates projects based on the MVC pattern.

## 4\. Use-Case View

### 4.1 Use-Case Realizations

## 5\. Logical View

### 5.1 Overview

![](ar_model.png)
 Figure: Model

![](ar_control.png)

Figure: Controller

### 5.2 Architecturally Significant Design Packages

## 6\. Process View

![](ar_deployment-process.png)

## 7\. Deployment View

![](ar_deployment-view.png)

## 8\. Implementation View

### 8.1 Overview

![](cd_classes.png)

### 8.2 Layers

## 9\. Data View

![](cd_db.png)

## 10\. Size and Performance

## 11\. Quality