@Chrome
  Feature: Board

    Background:
      Given I enter valid login details

    Scenario: Add a list
      When I click a board
      And I add a list
      Then I can see the board title
#
    Scenario: Change visibility settings to public
      When I click settings
      And I change visibility to public
      Then I can see the correct Workspace visibility has changed

    Scenario: Change visibility settings to private
      When I click settings
      And I change visibility to private
      Then I can see the correct Workspace visibility has changed
