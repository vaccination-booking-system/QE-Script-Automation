#Feature: Register
#  As a citizen
#  I should be able to register new account
#  So that i can login and access all the features
#
#  Scenario Outline: Register
#    Given I set register endpoint
#    When I set nama "<name>" nik "<NIK>" and password "<password>" for register and i send Post Request
#    Then I validate the status code for register and the message "<message>"
#
#    Examples:
#    |name|NIK|password|message|
#    |Rubyjane    |6630924044745984|Jendeuki_123|SUCCESS|
#    |Ruby|4879116481234856|Passwordd456|ALREADY_EXIST|
#    |Faid|8947114651234984|Password66  |INVALID_NIK|
#    |Johnny|8974553321648976|JackSparrow |INVALID_INPUT|
#    |Andrew|                |iLoveCat23  |INVALID_INPUT|
#    |Peter|6040768222832439|            |INVALID_INPUT|
#    |Alfredo Boohemian|8794311678w9713016|Passwordd345|INVALID_INPUT|
#    |Ronaldo|5549887132648046|Password%$001|SUCCESS     |
#    |       |                |             |INVALID_INPUT|
#    |Leo|4291931395522993|Pass3451     |INVALID_INPUT|
#    |Kuma|4291931395522993|passwordd456 |INVALID_INPUT|
#    |hanky05|5878571798324018|Hanky_123 |INVALID_INPUT|
#    |@Hankiee|5878571798324018|Hanky_123|INVALID_INPUT|
#    |        |5878571798324018|Hanky_123|INVALID_INPUT|
