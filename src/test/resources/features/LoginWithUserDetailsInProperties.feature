@Chrome
Feature: Login

  Scenario: Login
   Given I enter valid login details
    When I click a board
    Then I can see the correct board

  Scenario: invalid Login details
    Given I enter invalid details
    When I click submit
    Then I can see the error message

    ####################Failed test since user needs to click logout a second time####################
  Scenario: I log out
    Given I enter valid login details
    When I click on my profile
    And I click log out
    Then I am sent back to Trello home page
  ####################Failed test since user needs to click logout a second time####################
