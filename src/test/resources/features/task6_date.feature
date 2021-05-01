@date
Feature: Date

  Scenario: Set Date 1 mounth future
    Given the user is in the main page
    When the user navigates to "Widgets" -- "Date Picker"
    When the user fills "Select Date" as "1 mounth forward"
    And the user fills "Date And Time" as "1 mounth forward"
    Then the user verifies dates are set to 1 mount forward