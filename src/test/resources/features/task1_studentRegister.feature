@register @all @t1
Feature: Student can register

  @succesful_register
  Scenario: Succesful registration
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user selects below subjects
      | Maths    |
      | English |
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
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

  @register_invalid_input_quick_check_up
  Scenario: User prints defect emails in the console
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
    Then the user tries below "Email" options and verifies none of below is not working
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



  @register_invalid_input_quick_check_up
  Scenario: User prints defect emails in the console
    Given the user is in the main page
    When the user navigates to "Forms" -- "Practice Form"
    When the user fills in all fields with random valid data
    And the user select "hobbies" radio button as "Reading"
    And the user select "gender" radio button as "Female"
    And the user "State" dropdown as "NCR"
    And the user "City" dropdown as "Delhi"
    Then the user tries below "Name" options and verifies none of below is not working
      | 123   |
      | !mike |
      | mike@ |
      | -     |
      | mike  |




