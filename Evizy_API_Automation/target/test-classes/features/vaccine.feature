Feature: Vaccine

  Scenario Outline: POST - Create Vaccine
    Given I set an endpoint to create vaccine
    When I set vaccine's name "<name>" and send create vaccine detail
    Then I validate the status code <status_code> and message detail "<message>"

  Examples:
    |name|status_code|message|
    |newVac|201   |SUCCESS  |
    |null|400          |INVALID_INPUT|
    |Sinovac|400       |ALREADY_EXIST|


  Scenario: GET - Get specific vaccine
    Given I set get specific vaccine endpoint
    When I send get specific vaccine request
    Then I validate the status code is 200 and i validate the vaccine detail for get vaccine

  Scenario: DELETE - Delete specific vaccine
    Given I set delete specific vaccine endpoint
    When I send delete specific vaccine request
    Then I validate the status code is 200 and i validate the message "SUCCESS" after send vaccine req

  Scenario: PUT - Update vaccine name
    Given I set update vaccine name endpoint
    When I set new name for vaccine and send update request
    Then I validate the status code is 200 and i validate the vaccine detail


  Scenario: GET- Get all vaccine
    Given I set get all vaccine endpoint
    When I send get all vaccine request
    Then I validate the status code is 200 and i validate the message "SUCCESS" after send vaccine req


  Scenario: POST - Distribute vaccine to health facility
    #coba stock dikasih 0
    Given I set distribute vaccine to health facility endpoint
    When I send post request to distribute vaccine
    Then I validate the status code is 200 and i validate the message "SUCCESS" after send vaccine req

  Scenario: GET - vaccine stocks of health facility
    Given I set endpoint to get vaccine stock of health facility
    When I send get vaccine stock of health facility request
    Then I validate the status code is 200 and i validate the message "SUCCESS" after send vaccine req