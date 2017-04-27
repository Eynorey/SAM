* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Master Test Plan

###### <div style="text-align: right;">Version 1.0</div>

<br>
<br>

## Table of Contents

1.  [Introduction](# 1---introduction)
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
7. [Milestones](# 7---milestones)
8. [Risks, Dependencies, Assumptions and Constraints](# 8---risks-dependencies-assumptions-and-constraints)


# Master Test Plan

## 1\. Introduction <a name="introduction"></a>

### 1.1 Purpose

This Software Requirements Specification was created to collect and organize the requirements for the Skill Access Management Application. It includes a thorough description of the expected functionality for the project concerned, as well as the nonfunctional requirements. These are crucial for the purposes of establishing the understanding between the suppliers of the software and the customers, as well as minimizing the risks connected to the misinterpreting customer’s expectations. The document will furthermore provide the basis for costs-estimation and later validation of the results achieved.

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

Long before the digital era, the world has come to realize that knowledge is the key to any type of development. However, by the end of the 20th century the essence of knowledge itself has been changed dramatically. The new level of information accessibility made it into common property rather than a privilege. The fact, that a kid with a smartphone is no worse than a walking encyclopedia, caused a focus shift from information to skill.

Today, Internet can offer a broad variety of information, but fails to teach you how to apply it. Acquiring practical skills is therefore still associated with a new expense item in the budget and having to leave the comfort of your own home. Our platform is designed to change that.

Skill Access Manager, or SAM, will become a network connecting you to those who are ready to share practical knowledge in hundreds of different spheres and those, who want to learn exactly what you have to offer. Earn points by helping your peers out with whatever you like doing most, whether it is playing piano, skating, or solving mathematical equations. Get rated by your students and invest the points earned to learn from others. It is really as simple as that.

We at SAM believe that everyone has some skills to offer. Something you do as a hobby, or without even thinking about it twice, is what others are dying to learn. Use that to become the better version of yourself. Acquire new skills and share them with others. Smartify yourself. Today. With SAM.

### 2.2 User Interface Testing

![](ud_01.png)

User System

*   [Register](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/docs/UC-Specification-Register)

Course System

*   [Manage course offerings](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/docs/UC-Specification-ManageCourse)

## 3\. Deliverables

### 3.1 Reporting on Test Coverage

### 3.2 Incident Logs and Change Requests

### 3.3 Additional automated functional Test Scripts

## 4\. Testing Workflow

## 5\. Environmental Needs

## 6\. Responsibilities, Staffing and Training Needs

## 7\. Milestones

## 4\. Risks, Dependencies, Assumptions and Constraints
