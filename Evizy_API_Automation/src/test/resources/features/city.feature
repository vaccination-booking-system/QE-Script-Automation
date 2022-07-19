Feature: City

  Scenario Outline: POST- Create new city
    Given I set endpoint for create city
    When I set name "<name>" and send post request for create new city
    Then I validate the <status_code> and validate city detail "<message>"

  Examples:
    |name|status_code|message|
    |Denpasar|201    |SUCCESS|
    |Jakarta |400    |ALREADY_EXIST|
    |5680    |400    |INVALID_INPUT|
    |  |500         |INTERNAL_SERVER_ERROR|


  Scenario: GET- Get all city
    Given I set endpoint for get all city
    When I send get request for get all city
    Then I validate status code for city is 200 and message is "SUCCESS"

  Scenario: GET - Get specific city using id
    Given I set endpoint for get specific city using id
    When I send get specific city request
    Then I validate the status code is 200 and i validate the city's detail


  Scenario: DELETE - Delete specific city
    Given I set endpoint for delete specific city
    When I send delete specific city request
    Then I validate status code is 200 and message is "SUCCESS"


  Scenario: UPDATE - Update specific city
    Given I set endpoint for update specific city
    When I set update specific city request
    Then I validate the status code is 200 validate update detail
