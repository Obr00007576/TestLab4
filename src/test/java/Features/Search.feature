Feature: Search keyword

  Scenario: Search keyword in google
    Given I launch chrome browser
    When I open google homepage
    Then I verify that the google homepage is showed in the browser
    And I input the "godot" to search
    And I verify the "godot" is in the text box
    And I close the chrome browser