# Answer Digital UI Automation Testing & Instructions
 
 
#### Prepared by:
 
**Yusuf CELIK**

*QA Test Automation Engineer*
 
  
celikyus01@gmail.com

https://www.linkedin.com/in/yusuf-celik-8a12b2208

 
  
 
**- Build Tool:** Maven
 
**- Test Framework:** Cucumber BBD (with Junit 4 Assertions)
 
  
 
##### UI Automation Testing:

`https://demoqa.com/automation-practice-form`
 
 
#### QA:

Generating test scenarios and automation framework for Student Registration Form and completing other tasks given.
 

 
#### System Requirements:

- Java 1.8 + SDK
- Selenium Webdriver
- Maven
- Cucumber
- Gherkin Language Syntax
- Selenium Webdriver
- JUnit
 
## Test RUN

#### https://github.com/celikyus01/AnswerDigital.git

 
- Clone the projects
 
- Reload maven dependencies from POM
 
- Go **src -> test > java > com > answerDig > runners > CukesRunner

- Specify tag (example:   tags = "@register_invalid_input_quick_check_up")

        @all: runs all scenarios in  the framwork
        @t1: runs all test cases under task 1
        @succesful_register : fills the form with valid data and validates application allows successful registration
        @register_invalid_email : to validate application does not accept invalid emails (scenario outline)
        @register_invalid_input_quick_check_up  : to validate application does not accept invalid emails and names. It completes all validation in the same browser tab.
        @t2: runs all test cases under task 2
        @t3: runs all test cases under task 3
        @t4: runs all test cases under task 4
        @t5: runs all test cases under task 5
        @t6: runs all test cases under task 6
 
- Click run button (make sure Cukes Runner is specified as a runner source )
- To generate "HTML Maven Cucumber Report" ;
    > Open Maven right-side panel Double Click Project's Lifecycle Click "verify"


 
## Cucumber Test Feature Scenarios and BUGS found:
#### TASK-1

a- This scenario tests the registration form after filling all of the boxes within the required information taken from the user. ([https://demoqa.com/automation-practice-form](https://demoqa.com/automation-practice-form))

b- To run separately this scenario, use the `@wip1` tag in the CukesRunner class/Cucumber Options

#### TASK-1 - BUGS FOUND

a) Whenever the date of birth is deleted, the application gets crashed within an empty white screen appearing.

b) Whenever there is a selection of 3 hobbies at once, the result might not come with all of them selected. Try at least 3-4 times.

c) In the mobile section, the statement of ‘10 digits’ in parentheses does not seem professional.

d) The ‘First Name & Last Name’ sections accept numbers and punctuation characters.

e) Whenever there is no selection of the ‘state’, ‘city’ should be marked as disabled.

f) The ‘Email’ box accepts invalid email addresses such as: email@example..com (email cannot have double dot after domain..)

g) There are no such data validation messages indicated as red star format indicating which boxes have to be filled and which ones not.

h) Compulsory fields could be marked with * 

#### TASK-2
This Scenario tests ‘Click on the second button and accept the alert’ action.

#### TASK-3
This Scenario tests the ‘Hover over the button and input field’ action.

#### TASK-4
This Scenario tests the ‘Drag and drop element into specific area’ action.

#### TASK-5
This Scenario tests the ‘Close the small modal’ action.

#### TASK-6
This Scenario tests the ‘Use the date picker to set the date to 1 month in the future’ action.

2021 May®

#### https://github.com/celikyus01/AnswerDigital.git
  

 

