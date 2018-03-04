Feature: Logout at the system
  As a Logged user
  I want to log out of the system


  Scenario: Logout
    Given I am logged in the system
    When I click to logout
    Then I see the Otodom home page