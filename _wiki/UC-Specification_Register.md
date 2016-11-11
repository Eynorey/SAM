***
### <div align="right">SAM Initiative</div>
***
<br>
<br>
<br>
<h2 align="right"> Skill Access Manager<br>
Use-Case Specification: Register </h2>

####<div align="right">Version 1.0</div>

<br>
<br>
<br>

## Table of Contents

1. [Register](#1-register)
  1. [Brief Description](#11-brief-description)
2. [Flow of Events](#2-flow-of-events)
  1. [Basic Flow](#21-basic-flow)
  2. [Alternative Flows](#22-alternative-flows)
3. [Special Requirements](#3-special-requirements)
  1. [Functionality](#31-functionality)
  2. [Usability](#32-usability)
  3. [Reliability](#33-reliability)
  4. [Performance](#34-performance)
  5. [Supportability](#35-supportability)
  6. [Design constraints](#36-design-constraints)
  7. [On-line User Documentation and Help System Requirements](#37-on-line-user-documentation-and-help-system-requirements)
  8. [Purchased Components](#38-purchased-components)
  9. [Interfaces](#39-interfaces)
  10. [Licensing Requirements](310-licencing-requirements)
  11. [Legal, Copyright, and Other Notices](#311-legal-copyright-and-other-notices)
  12. [Applicable Standards](#312-applicable-standards)
4. [Preconditions](#4-preconditions)
5. [Postconditions](#5-postconditions)
6. [Extension Points](#6-extension-points)
  
<br>
<br>
###<div align="center"><font size="10">Use-Case Specification: Register</font></div>
<br>

##1. Register
###1.1 Brief Description
The purpose of this use case is for a new user (guest) to create an account on the SAM Platform. Any guest can enter the registration process by clicking "Register"-button from the welcome page. After filling in the correct user data and sending it with a click on the confirmation button, an automatic message is generated by the system to verify the given email address. It is send to the user email by the system. If guest activates the link in the automatic message, an account is created and access to the full SAM-functionality is granted to the new user. 

##2. Flow of Events
###2.1 Basic Flow

![](https://rawgit.com/Eynorey/SAM/master/uploads/activity_diagrams/ad_register.svg)
###2.2 Alternative Flows
####2.2.1 First Alternative Flow
If the "check emails" activity is unsuccessful after a number of repetitions an alternative flow can be chosen.

![](https://rawgit.com/Eynorey/SAM/master/uploads/activity_diagrams/ad_register-alt1.svg)

##3. Special Requirements
>_[A special requirement is typically a nonfunctional requirement that is specific to a use case, but is not easily or naturally specified in the text of the use case’s event flow. Examples of special requirements include legal and regulatory requirements, application standards, and quality attributes of the system to be built including usability, reliability, performance or supportability requirements. Additionally, other requirementssuch as operating systems and environments, compatibility requirements, and design constraintsshould be captured in this section.]_

###3.1 Functionality
###3.2 Usability
###3.3 Reliability
###3.4 Performance
###3.5 Supportability
###3.6 Design constraints
###3.7 On-line User Documentation and Help System Requirements
###3.8 Purchased Components
###3.9 Interfaces

![](https://rawgit.com/Eynorey/SAM/master/uploads/wireframes/wf_register.svg)

###3.10 Licensing Requirements
###3.11 Legal, Copyright, and Other Notices
###3.12 Applicable Standards
##4. Preconditions
>_[A precondition of a use case is the state of the system that must be present prior to a use case being performed.]_

###4.1 Precondition One
##5. Postconditions
>_[A postcondition of a use case is a list of possible states the system can be in immediately after a use case has finished.]_

###5.1 Postcondition One
##6. Extension Points
>_[Extension points of the use case.]_

###6.1 <Name of Extension Point>
>_[Definition of the location of the extension point in the flow of events.]_