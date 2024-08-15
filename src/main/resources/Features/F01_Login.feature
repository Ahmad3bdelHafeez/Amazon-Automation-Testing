@smoke
Feature: F02_Login | Users could use login functionality to use their accounts
  Scenario: Verify that user cannot login with valid but not registered email
  Given user go to Amazon website
  When  user clicks on the login button in the navigation bar
  And   user login with valid email
  And   user press on continue button
  Then  user can't login by displaying an error message

