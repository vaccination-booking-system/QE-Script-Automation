Feature: Vaccine Stock

  Scenario: Update Vaccination Stock
    Given I am on Evizy login admin page for vaccination session
    When I enter my username and password for vaccination session and click login button
    And I directed to dashboard
    And I click vaccine stock section
    And I click my health facility
    And I input new value of vaccination stock
    And I click add stock button
    And I success update vaccine stock

