#Feature: Register a new user
#  As a user
#  I want to create new access credentials
#  For create my personal adverts
#
#  Scenario: Register a new user
#    Given I access Otobom page
#    When I click in My Account
#    Then I can register a new user
#    When I click to register a new user
#    Then I see the reasons for create a user on Otobom
#    Given I click to create an account
#    And Fill the foolow user fields:
#      | Email         | qachallengept051217@gmail.com |
#      | Has?o         | inicial051217                 |
#      | Powtórz has?o | inicial051217                 |
#    And Accept the terms
#    When I click for register a new user
#    Then I see a resgistration confirmation message
#
#  Scenario: Activate the new User
#    Given I access Gmail
#    When I acess my email for activate the user
#    And Accces the sent email of Otobom
#    When I click in the sent link
#    Then I see the confirmation message of activation