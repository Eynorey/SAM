* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Software Requirements Specification for Skill Access Manager Application

###### Version 2.0

![workItem]({"id":"TOC"})

## Table of Contents

1.  [Introduction](# 1---introduction)
    1.  [Purpose](# 11-purpose)
    2.  [Scope](# 12-scope)
    3.  [Definitions, Acronyms, and Abbreviations](# 13-definitions-acronyms-and-abbreviations)
    4.  [References](# 14-references)
    5.  [Overview](# 15-overview)
2.  [Overall Description](# 2---overall-description)
    1.  [Vision](# 21-vision)
    2.  [Use Case Diagram](# 22-use-case-diagram)
3.  [Specific Requirements](# 3---specific-requirements)
    1.  [Functionality](# 31-functionality)
    2.  [Usability](# 32-usability)
    3.  [Reliability](# 33-reliability)
    4.  [Performance](# 34-performance)
    5.  [Supportability](# 35-supportability)
    6.  [Design constraints](# 36-design-constraints)
    7.  [On-line User Documentation and Help System Requirements](# 37-on-line-user-documentation-and-help-system-requirements)
    8.  [Purchased Components](# 38-purchased-components)
    9.  [Interfaces](# 39-interfaces)
    10.  [Licensing Requirements](# 310----licensing-requirements)
    11.  [Legal, Copyright, and Other Notices](# 311----legal-copyright-and-other-notices)
    12.  [Applicable Standards](# 312----applicable-standards)
4.  [Supporting Information](# 4---supporting-information)

# Software Requirements Specification

## 1\. Introduction

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

### 1.3 Definitions, Acronyms, and Abbreviations

Definitions, Acronyms and Abbreviations relevant for the interpretation of the present document can be found in the [Project Glossary](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/wiki/ProjectGlossary).

### 1.4 References

| Title | Date | Publishing organization |
| --- | --- | --- |
| [Project Glossary](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/wiki/ProjectGlossary) | 23/10/16 | SAM Initiative |
| [Project Blog](https://smartifytheworld.wordpress.com/) | 27/10/16 | SAM Initiative |

### 1.5 Overview

The following document will provide all the requirement information connected to the SAM-Project. It will introduce the overall description of the project, based on the vision and a use case diagram. In order to achieve a high level of specification in defining the requirements, all the functions presented in the diagram are going to be examined separately (see chapter 3.1). Further requirements are going to be divided into the following five categories:

*   Usability
*   Reliability
*   Performance
*   Supportability
*   Design constraints

All the externally obtained components, relevant interfaces and licensing requirements as well as legal disclaimers and standards (if applicable) are going to be listed in chapters 3.8 through 3.12\. Chapter 4 will provide the reader with the supporting information for the present document.

## 2\. Overall Description

### 2.1 Vision

Long before the digital era, the world has come to realize that knowledge is the key to any type of development. However, by the end of the 20th century the essence of knowledge itself has been changed dramatically. The new level of information accessibility made it into common property rather than a privilege. The fact, that a kid with a smartphone is no worse than a walking encyclopedia, caused a focus shift from information to skill.

Today, Internet can offer a broad variety of information, but fails to teach you how to apply it. Acquiring practical skills is therefore still associated with a new expense item in the budget and having to leave the comfort of your own home. Our platform is designed to change that.

Skill Access Manager, or SAM, will become a network connecting you to those who are ready to share practical knowledge in hundreds of different spheres and those, who want to learn exactly what you have to offer. Earn points by helping your peers out with whatever you like doing most, whether it is playing piano, skating, or solving mathematical equations. Get rated by your students and invest the points earned to learn from others. It is really as simple as that.

We at SAM believe that everyone has some skills to offer. Something you do as a hobby, or without even thinking about it twice, is what others are dying to learn. Use that to become the better version of yourself. Acquire new skills and share them with others. Smartify yourself. Today. With SAM.

### 2.2 Use Case Diagram

![](ud_01.png)

User System

*   [Register](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/docs/UC-Specification-Register)

Course System

*   [Manage course offerings](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_apps/hub/agile-extensions.wiki.wiki#/docs/UC-Specification-ManageCourse)

## 3\. Specific Requirements

### 3.1 Functionality

The overall use case diagram, which gives an overview for the project as a whole, devides SAM-System into four different blocks or subsystems:

*   User system
*   Course system
*   Dashboard
*   Admin console

These are going to represent the organizational structure of the present chapter. Each use case covered in the diagram is going to be described in a separate section of a corresponding block with a functional requirements connected to the use case in question.

#### 3.1.1 User System

##### Register

Any unregistered user (guest) is able to create an account (register) on the SAM-Page by providing the following information:

*   name
*   e-mail
*   password

Before the registration can come into force, the user is asked to agree to the Terms and Conditions provided by the SAM Initiative and confirm his e-mail address by following a link. After the e-mail has been confirmed a guest can log into his profile.

##### Log In

Any registered guest can perform a log in operation. Inserting correct registration data in the corresponding fields opens access to a user profile on the SAM platform.

##### Log out

Logged in users can change their role to "guest" by clicking on the "Log out" button.

##### Manage Account

Any logged in user can add, edit or delete personal information in his profile.

#### 3.1.2 Course System

##### Search Available Courses

Any platform visitor (guest/admin/user) is able to see and navigate the list of courses offered by SAM-users. These can be searched and sorted by any relevant criteria (such as subject, name or tutor). General information about each course can be obtained from the list, whereas detailed course discription is shown after a click on the chosen course.

##### Book Course

Any user can book a course, as long as his credit points cover the costs of the course and the course is taking place any time after the booking operation has been performed.

##### Manage Course Offerings

Any user can offer a course by giving detailed information about it and defining point in time, when the course will take place.

##### Rate Course

Users, who partisipated in a SAM-course, can rate it by filling in a short questionnaire about their experience.

#### 3.1.3 Dashboard

##### See Available Credits

Credit Points or credits are users financial resources. Registering on the platform (see chapter 3.1.1.1) provides the new user with a start capital which can be spent on available courses (see chapter 3.1.2.2). Further credits can be earned by giving courses. The dashboard interface provides the user with information about his Credit Points account.

##### See Recommended Courses

Depending on the information provided in the profile (see chapter 3.1.1.4), SAM can put together a personalized list of courses, which might be interesting for the user. These are accessible from the dashboard interface.

##### Check Course Ratings

Dashboard provides logged in users with the rating of the courses they have given in the past, based on the reviews of those who attended these courses (see chapter 3.1.2.4).

##### See Skill Tree

Any user can track his or her progress in form of a skill tree, which is developed by SAM to visualize the knowledge obtained while using the platform.

##### See Schedule

All the booked and offered courses, which take place at any point in the future can be seen in the schedule. Schedule is a part of the dashbord interface and helps users to plan their time by reminding them about the upcoming events.

#### 3.1.4 Admin console

##### Moderate Courses

A user with admin privileges can disapprove of any course offered on the platform based on the guidelines provided by the SAM Initiative. The denounced course has to be removed from the platform or edited to comply with the guidelines.

##### Moderate Users

An admin has the power to punish a user for violation of Terms and Conditions provided by the SAM Initiative.

### 3.2 Usability

We plan on designing the user interface in an intuitive and self-explaining way, so that there will be no need for further documents or tutorials on how to use the site.

Once we start looking at the UI and workflows, we will also have a look at best practices and try to adjust to common usability standards, such as IBM’s CUA standards and Microsoft’s GUI standards.

Optimizing efficnency is not a priority, as the platform should mainly be fun and easy to use, so there will be no need to provide dedicated power user options as this is not a productivity tool.

#### 3.2.1 Requirement One: no training time needed

The goal is that a user registers, maybe gets some hints on where he can do the most important things to get started, and will be able to use the platform without any further hurdles right away.

#### 3.2.2 Requirement Two: No function overload

The platform will do amny things of its own, so there is no need to create either large amounts of seetings, nor an overwhelming toolkit of functions which would need explanation for the user.

#### 3.2.3 Requirement Three: Natural workflow

The platform and its functionalities should feel natural to use, and user should find the things they want to do where they expect them, and at the first place they look for them.

But of course, we might be blinded by what we think is best, or we might tink we know what will be easiest to use, but the truth is that we will need to invite people unknown to the platform, give them specific tasks and observe their behavior. After that, we can adjust our workflow design accordingly.

### 3.3 Reliability

The server will ideally be available 24/7\. Though as of now, we have little impact on this as the free Azure plan works the following way:

There is a certain amount of memory and computing power available on each server, each customer gets their portion of it, depending on what they pay for. The remaining resources (also while the machines of the paying customers are idle) will be distributed over free plan users such as us. So depending on the load there is on the servers by paying customers, our service might be running more or less stable and performing accordingly.

Azure does deliver detailed insights and analytics on performance, failed HTTP requests, internal server errors, reliability and so on.

Should the platform grow, this might not be an option anymore at some point, forcing us to move to a paid plan.

As development begins and we will have some experiences on how this behaves, we will have better understanding of the reliability.

### 3.4 Performance

tbd

as we haven't started developing at the time of writing, specific thoughts on performance have not been given yet. As we start developing, there will be both single function time measurements and load tests.

We will update this document once we have a test environment set up which deliveres first results and insights.

### 3.5 Supportability

In order to maintain supportability and readability of our code, we will try to adopt the latest clean code standard as far as possible and establish an understandable naming convention which will be used throughout the project.

As the website will be hosted on Azure and probably be managed via the Team Foundation Services platform, it will be easy to upgrade the frameworks and tools on which the application is running, as integrated plug-ins or tools for CI and so forth will be updated to newer versions automatically.

### 3.6 Design Constraints

tbd.

All we know at the moment is that we will focus on providing both a modern but also a little playful or fun design, as this will be a platform where learning will also be fun and very social.

This page will be updated once we decided on technologies and programming languages regarding frontend and design.

### 3.7 On-line User Documentation and Help System Requirements

As descvibed earier under the topic of [Usability](#32-usability), the goal is to eliminate the need for a help system or a documentation by delivering an intuitive and self-explaining user interface.

However, at some points it might be necessary to use helping popups explaining a certain functionality. One could also think of a small kind of walkthrough or tutorial for newly registered users, highlighting the first few steps to get started.

### 3.8 Purchased Components

As for now, we will be using the free options provided by Microsoft Azure and other completely free tools. If we find ourselves needing more, we will switch to a paid option and update this section accordingly.

### 3.9 Interfaces

tbd

#### 3.9.1 User Interfaces

There will be the following user interfaces implemented which will soloely be accessible through the web:

*   **Landing page** showing available courses to guests of the site
*   **Login screen** enabling users to register or log in
*   **Dashboard**
    *   display recommended courses
    *   book courses
    *   offer courses
    *   show profile info
*   **Settings** to edit profile or account information
*   **Admin Console** to moderate courses and user profiles

#### 3.9.2 Hardware Interfaces

n/a

#### 3.9.3 Software Interfaces

SAM should be running in all common Browsers like Firefox, Chrome, Edge, Internet Explorer and Safari.

#### 3.9.4 Communications Interfaces

The service will be hosted on and will be accessible only through the internet, thus an internet conneciton is required.

### 3.10 Licensing Requirements

Under public GitHub license.

### 3.11 Legal, Copyright, and Other Notices

tbd

### 3.12 Applicable Standards

A lot of Clean Code concepts will be used.

## 4\. Supporting Information

tbd