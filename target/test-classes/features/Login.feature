@Chrome
Feature: Login

  Scenario: Login
    Given I enter username "abdullah.darsot@roq.co.uk" and password "Trello123!"
    When I click a board
    Then I can see the correct board

  Scenario: invalid Login details
    Given I enter invalid username "dfdfdfdfd" and password "Test"
    When I click submit
    Then I can see the error message

    ####################Failed test since user needs to click logout a second time####################
  Scenario: I log out
    Given I enter username "abdullah.darsot@roq.co.uk" and password "Trello123!"
    When I click on my profile
    And I click log out
    Then I am sent back to Trello home page
  ####################Failed test since user needs to click logout a second time####################
