Feature: Admin

  Scenario Outline: POST - Admin
    Given I set endpoint for login as an admin
    When I set username "<username>", "<name>", "<password>" and i send post request
    Then I validate the status code <status_code> and message after send post request

    Examples:
    |username|name|password|status_code|
    |pertaJaya|Rs Pertamina Jaya|Pertamina_321|201|
    |pertaJaya|Rs Pertamina Jaya|Healthyfirst67|400|
    |mentengmitra|Rs Menteng Mitra|adminforsmitra321|400|
    |mentengmitra|Rs Menteng Mitra|rsMitramenteng   |400|
    | mentengdalam_1|Puskes. Mentang Dalam 1|puskesMentang_D1|400|
    |               |                       |                |400|
#
#
#  Scenario:  GET - All admins
#    Given I set endpoint for get all admins
#    When I send get request
#    Then I validate the status code is 200 and i validate the message
#
#
#  Scenario Outline: GET- Admin detail using id
#    Given I set endpoint for get admin detail using <id>
#    When I send get admin detail request
#    Then I validate the status code <status_code> and validate the "<message>" after send get request
#
#    Examples:
#    |id|status_code|message|
#    |5 |200        |SUCCESS|
#    |100|400       |BAD_REQUEST|
#
#
#
#  Scenario: Delete - Delete Admin
#    Given I set endpoint for delete specific admin
#    When I send delete request
#    Then I validate the status code is 200 and i validate the message
#
#  Scenario: PUT - Update admin's username using id
#    Given I set endpoint for update admin's name using id
#    When I set name with new name and send PUT request
#    Then I validate the status code is 200 and validate the name has changed
