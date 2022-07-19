#Feature: Session Availability
#
#  Scenario Outline: Make Vaccination Session
#    Given I am on Evizy login admin page for vaccination session
#    When I enter my username and password for vaccination session and click login button
#    And I directed to dashboard and i click session availability button
#    And I click my health facility
#    And I click add session buttom
#    And I input date "<date>" for vaccination
#    And I select type of vaccine "<type>"
#    And I set the start time "<start>"
#    And I set the finish time "<finish>"
#    And I set the vaccine quota "<quota>"
#    And I click add session button
#    And I get the result for make vaccination session "<result>"
#
#    Examples:
#    |date|type|start|finish|quota|result|
#    |03092022|Pfizer|10:00|12:00|11|success|
#    |01082022|Pfizer|15:00|17:00|0 |failed |
#    |31082022|Nusantara|15:00|11:00|8|failed|
#    |        |         |     |     | |failed|

#  Scenario Outline: Update Vaccination Session
#    Given I am on Evizy login admin page for vaccination session
#    When I enter my username and password for vaccination session and click login button
#    And I directed to dashboard and i click session availability button
#    And I click my health facility
#    And I click edit vaccination session button
#    And I edit the vaccination detail "<detail>"
#    And I click edit button
#    And I get the update vaccination session result "<result>"
#
#    Examples:
#    |detail|result|
#    |05052016|failed|
#    |3       |success|


#  Scenario: Try to delete vaccination session
#    Given I am on Evizy login admin page for vaccination session
#    When I enter my username and password for vaccination session and click login button
#    And I directed to dashboard and i click session availability button
#    And I click my health facility
#    And I click delete button on vaccination session
#    Then I success delete the vaccination session






