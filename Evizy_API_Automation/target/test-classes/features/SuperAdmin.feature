Feature: Login Super Admin

  Scenario: Login Super Admin
    Given I set endpoint login for admin
    When I set username and password with super admin credentials and i send POST Request
    Then I validate the status code 200
    And  get the access token
