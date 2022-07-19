#Feature: Login Admin
#
#
#  Scenario Outline: Login Admin
#    Given I am on Evizy login admin page
#    When I input admin username "<username>"
#    And I input admin password "<password>"
#    And I click admin's login button
#    Then I get the admin result "<result>"
#
#    Examples:
#    |username|password|result|
#    |kebonJeruk|KebonJeruk01|dashboard_page|
#    |pertaJaya|adminforperta123|username atau password salah|
#    |         |                |stay on login page          |
