@modal @all @t5
Feature: Alert

  Scenario: Accept Alert and verify alert is disappeared
    Given the user is in the main page
    When the user navigates to "Alerts, Frame & Windows" -- "Modal Dialogs"
    When the student clicks on "Small modal" button
    Then the user verifies the modal title as "Small Modal"
    Then the user verifies the modal text as "This is a small modal. It has very less content"
    When the student clicks on "Close" button
    Then the user verifies the modal window is disappeared

