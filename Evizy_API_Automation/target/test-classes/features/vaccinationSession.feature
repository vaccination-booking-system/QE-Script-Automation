Feature: Vaccination Session

  Scenario: POST - Create Vaccination Session
    Given I set endpoint for create vaccination session
    When I set vaccination session detail and send post request
    Then I validate the status code for create vaccination session is 201 and validate the detail


  Scenario: GET - Vaccination Session of specific city
    Given I set endpoint for get vaccination session of specific city
    When I set get request for vaccination session of specfic city
    Then I validate the status code for vaccination is 200 and message is "SUCCESS"


  Scenario: GET - Get specific Vaccination Session
    Given I set endpoint for get specific vaccination session
    When I set get request for specific vaccination session
    Then I validate the status code for vaccination is 200 and message is "SUCCESS"


  Scenario: DELETE - Delete Specific Vaccination Session
    Given I set endpoint for delete specific vaccination session
    When I send delete specific vaccination session request
    Then I validate the status code for vaccination is 200 and message is "SUCCESS"

#
#  Scenario: PUT - Update specific health facility's vaccination session
#    Given I set endpoint for update vaccination session of health facility
#    When I set vaccination session update detail and send put request
#    Then I validate the status code for vaccination is 200 and message is "SUCCESS"