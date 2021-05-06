@date @all @t6
Feature: Date

  Scenario: Set Date 1 mounth future
    Given the user is in the main page
    When the user navigates to "Widgets" -- "Date Picker"
    When the user fills date "Select Date" as "1 mounth forward"
    And the user fills date "Date And Time" as "1 mounth forward"
    Then the user verifies dates are set to 1 mount forward