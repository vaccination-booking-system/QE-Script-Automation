Feature: Vaccination Pass

  Scenario: POST - Create vaccination Pass
    Given I set vaccination pass endpoint
    When I set vaccination pass detail and send post request
    Then I validate the status code and vaccination pass detail


  Scenario: GET - Get all vaccination pass
    Given I set an endpoint to get all vaccination pass
    When I send get all vaccination pass request
    Then I validate the status code is 200 and validate the message for vaccination pass


  Scenario: GET - Get specific vaccination pass
    Given I set an endpoint to get specific vaccination
    When I send get specific vaccination request
    Then I validate the status code is 200 and validate the message for vaccination pass

  Scenario: DELETE - Delete specific vaccination pass
    Given I set an endpoint to delete specific vaccination pass
    When I send delete specific vaccination pass request
    Then I validate the status code is 200 and validate the message for vaccination pass

  Scenario: PUT - Update vaccination pass detail
     Given I set an endpoint to update vaccination pass detail
     When I send update vaccination pass detail request
     Then I validate the status code is 200 and validate the message for vaccination pass

  Scenario: PUT - Update vaccination status_true
     Given I set an endpoint for update vaccination status
     When I change the vaccination status to true
     Then I validate the status code is 200 and validate the message for vaccination pass

  Scenario: PUT - Update vaccination status_false
     Given I set an endpoint for update vaccination status
     When I change the vaccination status to false
     Then I validate the status code is 200 and validate the message for vaccination pass