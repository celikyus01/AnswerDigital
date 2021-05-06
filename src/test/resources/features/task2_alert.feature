@alert @all @t2
Feature: Alert

Scenario: Accept Alert and verify alert is disappeared
  Given the user is in the main page
  When the user navigates to "Alerts, Frame & Windows" -- "Alerts"
  When the student clicks on "On button click, alert will appear after 5 seconds" "Click me" button
  When the user waits for the alert to be popped up
  When the user accepts alert
  Then the user verifies alert is disappeared

