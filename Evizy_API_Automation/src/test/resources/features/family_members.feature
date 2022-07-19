Feature: Family Member

  Scenario Outline: POST- add family member
    Given I set an endpoint for add family member
    When I set "<nik>", "<name>", "<date_of_birth>", "<gender>", "<relationship>" and send post request
    Then I validate the <status_code> and details

  Examples:
    |nik|name|date_of_birth|gender|relationship|status_code|
    |2867068365157346|Inggrit|2016-08-08|F|Sister|201      |
    |4264026422189380|Leo    |1993-11-19|M|Father|400      |

  Scenario: GET - get specific user's family members
    Given I set an endpoint for get specific user's family members
    When I send get specific user's family members request
    Then I validate the status code is 200 and validate the message after request


  Scenario: GET- Specific family member of user
    Given I set an endpoint for get specific family member
    When I send get specific family member request
    Then I validate the status code is 200 and validate the message after request


#  Scenario: DELETE - delete family member
#    #harus diganti id
#    Given I set an endpoint for delete family member
#    When I send delete family member request
#    Then I validate the status code is 200 and validate the message after request


#  Scenario: PUT - Update Family member
#    Given I set an endpoint for update family data
#    When I set update family data details
#    Then I validate the status code is 200 and validate the message after request

