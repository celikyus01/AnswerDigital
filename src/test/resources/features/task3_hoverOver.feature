@hover @all @t3
Feature: Hover Over

  Scenario: Hover over web elements and see messages is present
    Given the user is in the main page
    When the user navigates to "Widgets" -- "Tool Tips"
    When the student hover over on "Hover me to see" button
    Then the user verifies "You hoverid over the button" message
    When the student hover over on "Hover me to see" input box
    Then the user verifies "You hoverid over the text field" message
