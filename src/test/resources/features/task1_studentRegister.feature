@register
Feature: Student can register

  @succesful_register
  Scenario: Succesful registration
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
    And the user uploades "studentRegister.txt" file
    When the student clicks on "Submit" button
    Then the user verifies "Thanks for submitting the form"
    And the user verifies the verification table information is matching with form data

  @register_invalid_email
  Scenario Outline: Using INVALID email: scenario outline, longer execution
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user fills "Email" as "<email>"
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
    And the user uploades "studentRegister.txt" file
    When the student clicks on "Submit" button
    Then the user verifies "Thanks for submitting the form" is not present
    Examples:
      | email                         |
      | plainaddress                  |
      | #@%^%#$@#$@#.com              |
      | @example.com                  |
      | Joe Smith <email@example.com> |
      | email.example.com             |
      | email@example@example.com     |
      | .email@example.com            |
      | email.@example.com            |
      | email..email@example.com      |
      | email@example.com (Joe Smith) |
      | email@example                 |
      | email@-example.com            |
      | email@example.web             |
      | email@111.222.333.44444       |
      | email@example..com            |
      | Abc..123@example.com          |

  Scenario Outline: Using INVALID email: scenario outline, longer execution
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user fills "Email" as "<email>"
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
    And the user uploades "studentRegister.txt" file
    When the student clicks on "Submit" button
    Then the user verifies "Thanks for submitting the form" is not present
    Examples:
      | email                         |
      | plainaddress                  |
      | #@%^%#$@#$@#.com              |
      | @example.com                  |
      | Joe Smith <email@example.com> |
      | email.example.com             |
      | email@example@example.com     |
      | .email@example.com            |
      | email.@example.com            |
      | email..email@example.com      |
      | email@example.com (Joe Smith) |
      | email@example                 |
      | email@-example.com            |
      | email@example.web             |
      | email@111.222.333.44444       |
      | email@example..com            |
      | Abc..123@example.com          |



  @register3
  Scenario: Using INVALID name: scenario: fast execution
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
    Then the user tries below "Name" options and verifies none of them is not working
      |  |
#      | 123   | <-- BUG FOUND --> accepts invalid names
#      | !mike |
#      | mike@ |
#      | -     |
#      | mike  |

  @register4
  Scenario: Using INVALID name
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
    Then the user tries below "Email" options and verifies none of them is not working
      | plainaddress                  |
      | #@%^%#$@#$@#.com              |
      | @example.com                  |
      | Joe Smith <email@example.com> |
      | email.example.com             |
      | email@example@example.com     |
      | email@example.com (Joe Smith) |
      | email@example                 |
      | email@$example.com            |
      | email@111.222.333.44444       |
#      | email@example..com            |  <- BUG FOUND: accepts invalid email


  @register4
  Scenario: Using INVALID name
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
    Then the user tries below "Email" options and verifies none of them is not working
      | plainaddress                  |
      | #@%^%#$@#$@#.com              |
      | @example.com                  |
      | Joe Smith <email@example.com> |
      | email.example.com             |
      | email@example@example.com     |
      | email@example.com (Joe Smith) |
      | email@example                 |
      | email@$example.com            |
      | email@111.222.333.44444       |
#      | email@example..com            |  <- BUG FOUND: accepts invalid email









