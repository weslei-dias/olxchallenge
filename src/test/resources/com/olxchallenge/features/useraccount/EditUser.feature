Feature: Edit user data
  As A user logged
  I want to change my informations

  Scenario: Edit User Details
    Given I logged in Otobom page
    And Click in configurations
    When I fill my password informations
    Then I see the confirmation page