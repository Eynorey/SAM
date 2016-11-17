* * *

### SAM Initiative

###### Skill Access Manager

* * *

# Use-Case Specification: Manage course offerings [CRUD]

###### Version 1.0

## Table of Contents

1.  [Manage course offerings](# 1-offer-course)
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
    10.  [Licensing Requirements](310-licencing-requirements)
    11.  [Legal, Copyright, and Other Notices](# 311-legal-copyright-and-other-notices)
    12.  [Applicable Standards](# 312-applicable-standards)
4.  [Preconditions](# 4-preconditions)
5.  [Postconditions](# 5-postconditions)
6.  [Extension Points](# 6-extension-points)

## 1\. Manage course offerings

### 1.1 Brief Description

The purpose of this use case is to create and organize offered courses on the SAM platform. You need it to inform the system what you are willing to teach. After that, the system can recommend the course to users who want to learn the course's contents.

## 2\. Flow of Events

### 2.1 Basic Flow

The basic flow of the use case _Manage Course_ can be represented by the standard CRUD activity diagram. The user enters the use case by offering a new course (Create) or attempting to view the list of available courses. The two activities are connected with each other through saving or adding new item operations. Three further operations can be invoked from the course list: view details (Read), Delete and edit (Update).

![](pasted-image-161117110134.png)

A closer look at the activities, which come in place in case a user decides to offer a new course is provided in the following activity diagram.

![](pasted-image-161117110337.png)

Any logged in user can click the "offer new course" button. At this point the system would show an edit form (also used in the "Update" scenario. After filling in the course details and pressing the confirm button, the system checks if the course data is valid. If not, the user is notified about the problem and asked to fill in the correct details. If the course data is valid, the course will be added to the list of offered courses, which is displayed afterwards. As the necessary steps are equal for Update and Create operation, the system is going to send an email to the participants of the course. As the list of participants is empty at this point, the email not going to be sent and the system is switching to the list overview, which is presented in the following diagram.

![](pasted-image-161117113249.png)

The list of courses can be accessed by creating a new course or jumped to by pressing the corresponding menu-button. If no courses exist in the list, the "offer new course" button is going to be shown instead. Clicking on a course entry in an non-empty course list calls a screen with the course details. Two actions will be available at this point. You can either delete the course or edit the course (redirection to the course edit form). In both cases the relevant participants will be informed via email.

### 2.2 Alternative Flows

#### 2.2.1 First Alternative Flow

> _[More complex alternatives are described in a separate section, referred to in the Basic Flow subsection of Flow of Events section. Think of the Alternative Flow subsections like alternative behavior each alternative flow represents alternative behavior usually due to exceptions that occur in the main flow. They may be as long as necessary to describe the events associated with the alternative behavior. When an alternative flow ends, the events of the main flow of events are resumed unless otherwise stated.]_

##### First Alternative Subflow

> _[Alternative flows may, in turn, be divided into subsections if it improves clarity.]_

#### 2.2.2 Second Alternative Flow

> _[There may be, and most likely will be, a number of alternative flows in a use case. Keep each alternative flow separate to improve clarity. Using alternative flows improves the readability of the use case, as well as preventing use cases from being decomposed into hierarchies of use cases. Keep in mind that use cases are just textual descriptions, and their main purpose is to document the behavior of a system in a clear, concise, and understandable way.]_

## 3\. Special Requirements

> _[A special requirement is typically a nonfunctional requirement that is specific to a use case, but is not easily or naturally specified in the text of the use case’s event flow. Examples of special requirements include legal and regulatory requirements, application standards, and quality attributes of the system to be built including usability, reliability, performance or supportability requirements. Additionally, other requirementssuch as operating systems and environments, compatibility requirements, and design constraintsshould be captured in this section.]_

### 3.1 Functionality

See Gherkin .feature file below

[Link to file](https://eynorey.visualstudio.com/SAM%20-%20Smartify%20The%20World/_git/sam-private?path=%2Fapplication%2Fsrc%2Ftest%2Ffeatures%2Fcourse%2Fmanage_course_offerings.feature&version=GBmaster&_a=contents)

![](feature_manage-course.png)

### 3.2 Usability

### 3.3 Reliability

### 3.4 Performance

### 3.5 Supportability

### 3.6 Design constraints

### 3.7 On-line User Documentation and Help System Requirements

### 3.8 Purchased Components

### 3.9 Interfaces

![](wf_manage-course.png)

### 3.10 Licensing Requirements

### 3.11 Legal, Copyright, and Other Notices

### 3.12 Applicable Standards

## 4\. Preconditions

> _[A precondition of a use case is the state of the system that must be present prior to a use case being performed.]_

### 4.1 Precondition One

## 5\. Postconditions

> _[A postcondition of a use case is a list of possible states the system can be in immediately after a use case has finished.]_

### 5.1 Postcondition One

## 6\. Extension Points

> _[Extension points of the use case.]_

### 6.1<name point="" extension="" of=""></name>

> _[Definition of the location of the extension point in the flow of events.]_