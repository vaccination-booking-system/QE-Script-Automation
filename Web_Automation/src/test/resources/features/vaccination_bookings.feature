Feature: Vaccination Bookings

  Scenario Outline: Update vaccination booking's status
    Given I am on Evizy login admin page for vaccination session
    When I enter my username and password for vaccination session and click login button
    And I directed to dashboard
    And I click vaccination bookings
    And I click my health facility
    And I click edit status button
    And I click choose vaccination status "<status>"
    And I click update button
    And I success update vaccination status "<result>"

    Examples:
    |status|result|
    |vaccinated|vaccinated|
    |not_yet   |not_yet   |