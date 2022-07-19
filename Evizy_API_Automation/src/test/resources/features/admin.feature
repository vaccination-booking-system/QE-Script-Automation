Feature: Admin

#  Scenario Outline: POST - Admin
#    Given I set endpoint for create  an admin
#    When I set username "<username>", "<name>", "<password>" and i send request for post admin
#    Then I validate the status code <status_code> and message "<message>" after send post request
#
#    Examples:
#      |username|name|password|status_code|message|
#      #harus diganti
#      |kebonJeruk|Rs Kebon Jeruk|KebonJeruk01|201|SUCCESS|
#      |pertaJaya|Rs Pertamina Jaya|Healthyfirst67|400|ALREADY_EXIST|
#      |mentengmitra|Rs Menteng Mitra|adminforsmitra321|400|INVALID_INPUT|
#      |mentengmitra|Rs Menteng Mitra|rsMitramenteng   |400|INVALID_INPUT|
#      #harus diganti
#      |pramitaclinicc|Pramita Clinic|Pramitac_5|201|SUCCESS                  |
#      | |  |  |400                               |INVALID_INPUT               |


  Scenario: GET- All Admin
    Given I set endpoint for Get all Admin
    When I send get all admin request
    Then I validate the status code is 200 and the message is "SUCCESS"


  Scenario Outline: GET - Specific Admin using id
    Given I set endpoint for Get admin using id
    When I send get admin using id request <id>
    Then I validate the <status_code> and i validate the message "<message>"

    Examples:
    |id|status_code|message|
    |6 |200        |SUCCESS|
    |200|400       |BAD_REQUEST|

#  Scenario: DELETE- Delete Specific Admin
#    #harus diganti lagi idnya
#    Given I set endpoint for delete specific admin using id
#    When I send delete specific admin request
#    Then I validate the status code is 200 and the message is "SUCCESS"
#
#  Scenario Outline: PUT - Update admin's data
#    Given I set endpoint for update admin's data
#    When I set "<username>", "<name>", "<password>" and send put request
#    Then I validate status code is 200 and validate the detail
#
#  Examples:
#    |username|name|password|
#    |TemengguRS|RS TEmenggu|temenggu_Rs_0101|
#    |TemengguRS|RSUD Temenggu Gergaji|temenggu_Rs_0101|
#    |TemengguRS|RSUD Temenggu Gergaji|rsUD_temenggu!02|
#
  Scenario: POST - Login Admin
    Given I set an endpoint for login as an admin
    When I set admin username and password
    Then I validate the status code is 200 and i get the access token
