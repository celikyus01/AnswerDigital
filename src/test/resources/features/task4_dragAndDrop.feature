@dad @all @t4
Feature: Drag and Drop

  Scenario: Drag and Drop verify location is chaanged
    Given the user is in the main page
    When the user navigates to "Interactions" -- "Dragabble"
    When the user drags "Drag me" and drops into the special section
    Then the "Drag me" relocated correctly