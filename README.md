# Answer Digital UI Automation Testing & Instructions
 
 
#### Prepared by:
 
**Yusuf CELIK*
 
*QA Test Automation Engineer*
 
  
[celikyus01@gmail.com]
https://www.linkedin.com/in/yusuf-celik-8a12b2208

 
  
 
**- Build Tool:** Maven
 
**- Test Framework:** Cucumber BBD (with Junit 4 Assertions)
 
  
 
##### UI Automation Testing:
 
  
 
`https://demoqa.com/automation-practice-form`
 
 
#### QA:
 
Write a Cucumber BDD test that users can register in the ‘Student Registration Form’.

 
  
 
#### System Requirements:
 
  
 
- Java 1.8 + SDK
- Selenium Webdriver
- Maven
- Cucumber
- Gherkin Language Syntax
- Selenium Webdriver
- JUnit
 
## Test RUN
 
Notes: To run all Scenarios, use `@demoQA_001` tag in the CukesRunner class/Cucumber Options
 
#### [](https://github.com/musaasimobuz/ApiRestServiceTestingExercise#1-way)1. Way:
 
  
 
- Clone the projects
 
- Import maven dependencies from POM
 
- Go **src -> test > java > com > demoQA > runners > CukesRunner** and RUN
 
- To generate "HTML Maven Cucumber Report" ;
 
> Open Maven right-side panel Double Click Project's Lifecycle Click "verify"
 
 
#### [](https://github.com/musaasimobuz/ApiRestServiceTestingExercise#2-way)2. Way:
 
  
 
- Run from command line invoke `mvn clean verify`
 
  
 
## Cucumber Test Feature Scenarios:
#### 1) Validate successful registration has been completed by the user.

a- This scenario tests the registration form after filling all of the boxes within the required information taken from the user. ([https://demoqa.com/automation-practice-form](https://demoqa.com/automation-practice-form))
b- To run separately this scenario, use the `@wip1` tag in the CukesRunner class/Cucumber Options

## Defects Found During the Implementation
a) Whenever the date of birth is deleted, the application gets crashed within an empty white screen appearing. 
b) Whenever there is a selection of 3 hobbies at once, the result does not come with all of them selected. 
c) In the mobile section, the statement of ‘10 digits’ in parentheses does not seem professional. 
d) The ‘First Name & Last Name’ sections accept numbers and punctuation characters.
e) Whenever there is no selection of the ‘state’, ‘city’ should be marked as disabled.
f) The ‘Email’ box accepts invalid email addresses.
g) There are no such data validation messages indicated as red star format indicating which boxes have to be filled and which ones not. 
 
#### 2) Validate alert automation activity performed by utilising test scripts, HTML and CSS locators.
 
a- This Scenario tests ‘Click on the second button and accept the alert’ action.

b- To run separately this scenario, use the `@wip2` tag in the CukesRunner class/Cucumber Options

#### 3) Validate hover over automation activity performed by utilising test scripts, HTML and CSS locators.
 
a- This Scenario tests the ‘Hover over the button and input field’ action.

b- To run separately this scenario, use the `@wip3` tag in the CukesRunner class/Cucumber Options

#### 4) Validate drag and drop element automation activity performed by utilising test scripts, HTML and CSS locators.
 
a- This Scenario tests the ‘Drag and drop element into specific area’ action.

b- To run separately this scenario, use the `@wip4` tag in the CukesRunner class/Cucumber Options

#### 5) Validate close the small modal automation activity performed by utilising test scripts, HTML and CSS locators.
 
a- This Scenario tests the ‘Close the small modal’ action.

b- To run separately this scenario, use the `@wip5` tag in the CukesRunner class/Cucumber Options
#### 6) Validate close the small modal automation activity performed by utilizing test scripts, HTML and CSS locators.
 
a- This Scenario tests the ‘Use the date picker to set the date to 1 month in the future’ action.

b- To run separately this scenario, use the `@wip6` tag in the CukesRunner class/Cucumber Options


 ([https://demoqa.com/automation-practice-form](https://demoqa.com/automation-practice-form))
2021 May®
 
  
### [](https://github.com/musaasimobuz/ApiRestServiceTestingExercise#end)End
 

