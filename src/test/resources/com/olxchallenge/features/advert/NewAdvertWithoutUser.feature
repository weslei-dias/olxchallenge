Feature: Create a new Advert without sign in
  As a user without credencials
  I want to create a new advert
  For Rent a new room

  Scenario: Access Advert Page
    Given I access Otobom home page
    When I click on the New Advert button
    Then I see the new advert page

  Scenario: Create a new Rent Advert
    Given I access new advert page
    When I click for rent a room
    Then I see the rent room advert page
    Given I fill the follow fields:
      | tytu? og?oszenia     | Test Title                                          |
      | Cena                 | 100                                                 |
      | Dodatkowe op?aty     | 100                                                 |
      | Kaucja               | 100                                                 |
      | Liczba osób w pokoju | jednoosobowy                                        |
      | Powierzchnia         | 100                                                 |
      | Typ og?oszeniodawcy  | w?a?ciciel nieruchomo?ci                            |
      | miejscowo??          | Brzeg, brzeski, opolskie                            |
      | opis                 | Vestibulum ac diam sit amet quam vehicula elementum |
      | Imi? i nazwisko      | Weslei Dias                                         |
      | E-mail               | dias.weslei@dias.com                                |
    When I click to see the previous
    Then I want to see and submit my advert
    And The confirmation link to activate the advert