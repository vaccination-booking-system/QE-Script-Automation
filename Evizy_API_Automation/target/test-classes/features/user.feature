Feature: User

  Scenario: GET - GET all users
    Given I set get all users endpoint
    When I send get all users request
    Then I validate the status code is 200 and validate the message is "SUCCESS" for user


  Scenario: GET - Get specific user using id
    Given I set get specififc user endpoint
    When I send get specific user request
    Then I validate the status code is 200 and validate user detail
