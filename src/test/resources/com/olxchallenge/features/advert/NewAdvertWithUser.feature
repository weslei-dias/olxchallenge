Feature: Create a new Advert with user
  As a logged user
  I want to create a new advert
  For rent a new room

  Scenario: Create a new advert
    Given I logged in Otobom page
    When I click to add a new advert
    And Create a new rent room advert with the follow values:
      | tytu? og?oszenia     | Test Title                                          |
      | Cena                 | 100                                                 |
      | Dodatkowe op?aty     | 100                                                 |
      | Kaucja               | 100                                                 |
      | Liczba osób w pokoju | jednoosobowy                                        |
      | Powierzchnia         | 100                                                 |
      | Typ og?oszeniodawcy  | w?a?ciciel nieruchomo?ci                            |
      | miejscowo??          | Trablice, radomski, mazowieckie                     |
      | opis                 | Vestibulum ac diam sit amet quam vehicula elementum |
      | Imi? i nazwisko      | Weslei Dias                                         |
      | E-mail               | dias.weslei@dias.com                                |
    Then I see my advert on pending adverts

