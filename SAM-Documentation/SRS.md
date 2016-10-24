***
<p style="font-size:40px" align="right">SAM Initiative</p>
***
<br>
<br>
<br>
<h2 align="right"> Skill Access Manager<br>
Software Requirements Specification<br>
For Skill Access Manager Application </h2>

<p align="right">Version 1.0</p>

<p align="center"><font size="10">Software Requirements Specification</font></p>
<br>
## 1.	Introduction
### 1.1	Purpose
This Software Requirements Specification was created to collect and organize the requirements for the Skill Access Management Application. It includes a thorough description of the expected functionality for the project concerned, as well as the nonfunctional requirements. These are crucial for the purposes of establishing the understanding between the suppliers of the software and the customers, as well as minimizing the risks connected to the misinterpreting customer’s expectations. The document will furthermore provide the basis for costs-estimation and later validation of the results achieved.  
### 1.2	Scope
The requirements specified in the document are to be applied to the SAM Project. The Skill Access Manager is a free-to-use social platform, which provides a common space for people who want to share their knowledge and profit from other people’s expertise.
<br>
ACTORS: There are three types of actors: __guests__, __users__ and __admins__.
* Guests – visitors, who either do not have a personal account or are not logged into their profile
* Users – registered SAM-users
* Admins – (extends users) initially SAM-developers, later on a support team with enhanced abilities on the website.

SUBSYSTEMS: There are four subsystems to the platform: __user system__, __course system__, __dashboard__ and __admin console__. 
* User system – allows the actors to be identified as users/guests/admins,  store personal information relevant to the platform. 
* Course system – allows users to create new, search or book available and rate their attended courses.
* Dashboard – gives users an overview of their progress as tutors (depending on given courses) or students (depending on attended courses), scheduled and recommended classes and account balance. 
* Admin console – a system only available for the admins. Allows privileged users to moderate courses and users in accordance with the platform policies.  

### 1.3	Definitions, Acronyms, and Abbreviations
Definitions, Acronyms and Abbreviations relevant for the interpretation of the present document can be found in the [Project Glossary](https://github.com/Eynorey/SAM/wiki/Project-Glossary "SAM Project Glossary"). 

### 1.4	References
|Title |	Date	| Publishing organization |
|------|----------------|-------------------------|
|[Project Glossary](https://github.com/Eynorey/SAM/wiki/Project-Glossary "SAM Project Glossary") |	23/10/16 | SAM Initiative |
|-|-|-|

### 1.5	Overview

The following document will provide all the requirement information connected to the SAM-Project. It will introduce the overall description of the project, based on the vision and a use case diagram. In order to achieve a high level of specification in defining the requirements, all the functions presented in the diagram are going to be examined separately (see chapter 3.1). Further requirements are going to be divided into the following five categories: 
* Usability
* Reliability
* Performance
* Supportability
* Design constraints 

All the externally obtained components, relevant interfaces and licensing requirements as well as legal disclaimers and standards (if applicable) are going to be listed in chapters 3.8 through 3.12. Chapter 4 will provide the reader with the supporting information for the present document.

## 2.	Overall Description

### 2.1	Vision

Long before the digital era, the world has come to realize that knowledge is the key to any type of development. However, by the end of the 20th century the essence of knowledge itself has been changed dramatically. The new level of information accessibility made it into common property rather than a privilege. The fact, that a kid with a smartphone is no worse than a walking encyclopedia, caused a focus shift from information to skill.
Today, Internet can offer a broad variety of information, but fails to teach you how to apply it. Acquiring practical skills is therefore still associated with a new expense item in the budget and having to leave the comfort of your own home. Our platform is designed to change that.
Skill Access Manager, or SAM, will become a network connecting you to those who are ready to share practical knowledge in hundreds of different spheres and those, who want to learn exactly what you have to offer. Earn points by helping your peers out with whatever you like doing most, whether it is playing piano, skating, or solving mathematical equations. Get rated by your students and invest the points earned to learn from others. It is really as simple as that.
We at SAM believe that everyone has some skills to offer. Something you do as a hobby, or without even thinking about it twice, is what others are dying to learn. Use that to become the better version of yourself. Acquire new skills and share them with others. Smartify yourself. Today. With SAM.

### 2.2	Use Case Diagram

__[INSERT UML]__

## 3.	Specific Requirements 

### 3.1	Functionality

The overall use case diagram, which gives an overview for the project as a whole, devides SAM-System into four different blocks or subsystems: 
* User system
* Course system
* Dashboard
* Admin console

These are going to represent the organizational structure of the present chapter. Each use case covered in the diagram is going to be described in a separate section of a corresponding block with a functional requirements connected to the use case in question. 

#### 3.1.1	User System

##### 3.1.1.1	Register
##### 3.1.1.2 Log In
##### 3.1.1.3 Log out
##### 3.1.1.4 Manage Account


### 3.2	Usability 
[This section includes all those requirements that affect usability. For example,
•	specify the required training time for a normal users and a power user to become productive at particular operations
•	specify measurable task times for typical tasks or base the new system’s usability requirements on other systems that the users know and like
•	specify requirement to conform to common usability standards, such as IBM’s CUA standards Microsoft’s GUI standards]
#### 3.2.1	<Usability Requirement One>
[The requirement description goes here.]
### 3.3	Reliability 
[Requirements for reliability of the system should be specified here. Some suggestions follow:
•	Availability—specify the percentage of time available ( xx.xx%), hours of use, maintenance access, degraded mode operations, and so on.
•	Mean Time Between Failures (MTBF) — this is usually specified in hours, but it could also be specified in terms of days, months or years.
•	Mean Time To Repair (MTTR)—how long is the system allowed to be out of operation after it has failed?
•	Accuracy—specifies precision (resolution) and accuracy (by some known standard) that is required in the system’s output.
•	Maximum Bugs or Defect Rate—usually expressed in terms of bugs per thousand lines of code (bugs/KLOC) or bugs per function-point( bugs/function-point).
•	Bugs or Defect Rate—categorized in terms of minor, significant, and critical bugs: the requirement(s) must define what is meant by a “critical” bug; for example, complete loss of data or a complete inability to use certain parts of the system’s functionality.]
#### 3.3.1	<Reliability Requirement One>
[The requirement description.]
### 3.4	Performance
[The system’s performance characteristics are outlined in this section. Include specific response times. Where applicable, reference related Use Cases by name.
•	Response time for a transaction (average, maximum)
•	Throughput, for example, transactions per second
•	Capacity, for example, the number of customers or transactions the system can accommodate
•	Degradation modes (what is the acceptable mode of operation when the system has been degraded in some manner)
•	Resource utilization, such as memory, disk, communications, and so forth.
#### 3.4.1	<Performance Requirement One>
[The requirement description goes here.]
### 3.5	Supportability
[This section indicates any requirements that will enhance the supportability or maintainability of the system being built, including coding standards, naming conventions, class libraries, maintenance access, and maintenance utilities.]
#### 3.5.1	<Supportability Requirement One>
[The requirement description goes here.]
### 3.6	Design Constraints
[This section indicates any design constraints on the system being built. Design constraints represent design decisions that have been mandated and must be adhered to.  Examples include software languages, software process requirements, prescribed use of developmental tools, architectural and design constraints, purchased components, class libraries, and so on.]
#### 3.6.1	<Design Constraint One>
[The requirement description goes here.]
### 3.7	On-line User Documentation and Help System Requirements
[Describes the requirements, if any, for o-line user documentation, help systems, help about notices, and so forth.]
### 3.8	Purchased Components
[This section describes any purchased components to be used with the system, any applicable licensing or usage restrictions, and any associated compatibility and interoperability or interface standards.]
### 3.9	Interfaces
[This section defines the interfaces that must be supported by the application. It should contain adequate specificity, protocols, ports and logical addresses, and the like, so that the software can be developed and verified against the interface requirements.]
#### 3.9.1	User Interfaces
[Describe the user interfaces that are to be implemented by the software.]
#### 3.9.2	Hardware Interfaces
[This section defines any hardware interfaces that are to be supported by the software, including logical structure, physical addresses, expected behavior, and so on.]
#### 3.9.3	Software Interfaces
[This section describes software interfaces to other components of the software system. These may be purchased components, components reused from another application or components being developed for subsystems outside of the scope of this SRS but with which this software application must interact.]
#### 3.9.4	Communications Interfaces
[Describe any communications interfaces to other systems or devices such as local area networks, remote serial devices, and so forth.]
### 3.10	Licensing Requirements
[Defines any licensing enforcement requirements or other usage restriction requirements that are to be exhibited by the software.]
### 3.11	Legal, Copyright, and Other Notices
[This section describes any necessary legal disclaimers, warranties, copyright notices, patent notices, wordmark, trademark, or logo compliance issues for the software.]
### 3.12	Applicable Standards
[This section describes by reference any applicable standard and the specific sections of any such standards which apply to the system being described. For example, this could include legal, quality and regulatory standards, industry standards for usability, interoperability, internationalization, operating system compliance, and so forth.]
## 4.	Supporting Information
[The supporting information makes the SRS easier to use.  It includes:
•	Table of contents
•	Index
•	Appendices
These may include use-case storyboards or user-interface prototypes. When appendices are included, the SRS should explicitly state w