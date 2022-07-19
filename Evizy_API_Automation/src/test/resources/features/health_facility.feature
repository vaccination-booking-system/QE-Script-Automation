Feature: Health Facilities


  Scenario: POST- Create Health Facility
    Given I set endpoint for create health facility
    When I set post detail and send post request fot health facility
    Then I validate status code is 201 and message is "SUCCESS" afer post health fac req


 Scenario: GET - Get specific Health Facility
   Given I set endpoint for get specific health facility
   When I send get specific health facility request
   Then I validate the status code and health facility's detail


 Scenario: GET - Get all health facilities
   Given I set endpoint for get all health facilities
   When I send get all health facilities request
   Then I validate the status code is 200 and i validate the message is "SUCCESS" for health facility

 Scenario: DELETE - Delete health facility
   Given I set endpoint for delete specific health facility
   When I send delete health facility request
   Then I validate the status code is 200 and i validate the message is "SUCCESS" for health facility

