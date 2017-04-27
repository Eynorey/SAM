* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Master Test Plan

###### Version 1.0

## Table of Contents

1.  [Introduction](#markdown-header-1.-Introduction)
    1.  [Purpose](# 11-purpose)
    2.  [Scope](# 12-scope)
    3.  [Document Terminology and Acronyms](# 13-document-terminology-and-acronyms)
    4.  [References](# 14-references)
    5.  [Document Structure](# 15-structure)
2.  [Test Approach](# 2---test-approach)
    1.  [Function Testing](# 21-function-testing)
    2.  [User Interface Testing](# 22-user-interface-testing)
3.  [Deliverables](# 3---deliverables)
    1.  [Reporting on Test Coverage](# 31-reporting-on-test-coverage)
    2.  [Incident Logs and Change Requests](# 32-incident-logs-and-change-requests)
    3.  [Additional automated functional Test Scripts](# 33-additional-automated-functional-test-scripts)
4.  [Testing Workflow](# 4---testing-workflow)
5.  [Environmental Needs](# 5---environmental-needs)
6.  [Responsibilities, Staffing and Training Needs](# 6---responsibilities-staffing-and-training-needs)
7.  [Milestones](# 7---milestones)
8.  [Risks, Dependencies, Assumptions and Constraints](# 8---risks-dependencies-assumptions-and-constraints)

# Master Test Plan

## 1\. Introduction

## 1.1 Purpose

The purpose of the Iteration Test Plan is to gather all of the information necessary to plan and control the test effort for the Skill Access Manager. It describes the approach to testing the software, and is the top-level plan generated and used by managers to direct the test effort.
This Test Plan for the Skill Access Manager supports the following objectives:
- [Identifies the items that should be targeted by the tests.
- Identifies the motivation for and ideas behind the test areas to be covered.
- Outlines the testing approach that will be used.
- Identifies the required resources and provides an estimate of the test efforts.
- Lists the deliverable elements of the test project.]


### 1.2 Scope

The requirements specified in the document are to be applied to the SAM Project. The Skill Access Manager is a free-to-use social platform, which provides a common space for people who want to share their knowledge and profit from other people’s expertise.

ACTORS: There are three types of actors: **guests**, **users** and **admins**.

*   Guests – visitors, who either do not have a personal account or are not logged into their profile
*   Users – logged in SAM-users
*   Admins – (extends users) initially SAM-developers, later on a support team with enhanced abilities on the website.

SUBSYSTEMS: There are four subsystems to the platform: **user system**, **course system**, **dashboard** and **admin console**.

*   User system – allows the actors to be identified as users/guests/admins, store personal information relevant to the platform.
*   Course system – allows users to create new, search or book available and rate their attended courses.
*   Dashboard – gives users an overview of their progress as tutors (depending on given courses) or students (depending on attended courses), scheduled and recommended classes and account balance.
*   Admin console – a system only available for the admins. Allows privileged users to moderate courses and users in accordance with the platform policies.

### 1.3 Document Terminology and Acronyms

Definitions, Acronyms and Abbreviations relevant for the interpretation of the present document can be found in the [Project Glossary](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/wiki/ProjectGlossary).

### 1.4 References

| Title | Date | Publishing organization |
| --- | --- | --- |
| [Project Glossary](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/wiki/ProjectGlossary) | 23/10/16 | SAM Initiative |
| [Project Blog](https://smartifytheworld.wordpress.com/) | 27/10/16 | SAM Initiative |
| [UC Specification Manage Course](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/docs/UC-Specification-ManageCourse) | 11/11/16 | SAM Initiative |
| [UC Specification Register](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/docs/UC-Specification-Register) | 11/11/16 | SAM Initiative |

### 1.5 Document Structure

The following document will provide all the requirement information connected to the SAM-Project. It will introduce the overall description of the project, based on the vision and a use case diagram. In order to achieve a high level of specification in defining the requirements, all the functions presented in the diagram are going to be examined separately (see chapter 3.1). Further requirements are going to be divided into the following five categories:

*   Usability
*   Reliability
*   Performance
*   Supportability
*   Design constraints

All the externally obtained components, relevant interfaces and licensing requirements as well as legal disclaimers and standards (if applicable) are going to be listed in chapters 3.8 through 3.12\. Chapter 4 will provide the reader with the supporting information for the present document.

## 2\. Test Approach

### 2.1 Function Testing

| | Description |
| --- | --- |
| Technique Objective: |[Exercise database access methods and processes independent of the UI so you can observe and log incorrect functioning target behavior or data corruption.] |
| Technique: | [Invoke each database access method and process, seeding each with 	valid and invalid data or requests for data.  Inspect the database to ensure the data has been populated as 	intended and all database events have occurred properly, or review the 	returned data to ensure that the correct data was retrieved for the 	correct reasons.] | 
| Oracles: | [Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.] | 
| Required Tools: | [The technique requires the following tools: | 
| Success Criteria: | [The technique supports the testing of all key database access methods and processes.] | 
| Special Considerations: | [Testing may require a DBMS development environment or drivers to enter or modify data directly in the databases. Processes should be invoked manually. Small or minimally sized databases (limited number of records) should be used to increase the visibility of any non-acceptable events.] |

### 2.2 User Interface Testing

| | Description |
| --- | --- |
| Technique Objective: |[Exercise database access methods and processes independent of the UI so you can observe and log incorrect functioning target behavior or data corruption.] |
| Technique: | [Invoke each database access method and process, seeding each with 	valid and invalid data or requests for data.  Inspect the database to ensure the data has been populated as 	intended and all database events have occurred properly, or review the 	returned data to ensure that the correct data was retrieved for the 	correct reasons.] | 
| Oracles: | [Outline one or more strategies that can be used by the technique to accurately observe the outcomes of the test. The oracle combines elements of both the method by which the observation can be made and the characteristics of specific outcome that indicate probable success or failure. Ideally, oracles will be self-verifying, allowing automated tests to make an initial assessment of test pass or failure, however, be careful to mitigate the risks inherent in automated results determination.] | 
| Required Tools: | [The technique requires the following tools: | 
| Success Criteria: | [The technique supports the testing of all key database access methods and processes.] | 
| Special Considerations: | [Testing may require a DBMS development environment or drivers to enter or modify data directly in the databases. Processes should be invoked manually. Small or minimally sized databases (limited number of records) should be used to increase the visibility of any non-acceptable events.] |

## 3\. Deliverables

### 3.1 Reporting on Test Coverage

### 3.2 Incident Logs and Change Requests

### 3.3 Additional automated functional Test Scripts

## 4\. Testing Workflow

## 5\. Environmental Needs

## 6\. Responsibilities, Staffing and Training Needs

## 7\. Milestones

## 4\. Risks, Dependencies, Assumptions and Constraints