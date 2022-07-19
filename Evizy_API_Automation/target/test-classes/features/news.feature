Feature: News


  Scenario Outline: POST - Create News
    Given I set an endpoint for create news
    When I set news detail "<title>", "<description>" and content "<content>" and send post request
    Then I validate news status code is <status_code> and message "<message>"

    Examples:
    |title|description|content|status_code|message|
    |Masuk vaksin moderna|mendapat tambahan vaksin moderna sebanyak 5 botol|vaksin update|201|SUCCESS|
    |                    |                                                 |             |400|INVALID_INPUT|


  Scenario: POST - Create news using regular admin
    Given I set an endpoint for create news
    When I set news detail and send request
    Then I validate news status code is 401 and the message is "UNAUTHORIZED"


  Scenario: GET - Find all news
    Given I set get all news endpoint
    When I send get all news request
    Then I validate the status code is 200 and message is "SUCCESS" for news

  Scenario: GET - Find specific news
    Given I set find specific news endpoint
    When I send get request to find specific news
    Then I validate the status code is 200 and message is "SUCCESS" for news

  Scenario: DELETE - Delete specific news
    Given I set endpoint to delete specific news
    When I send delete specific news request
    Then I validate the status code is 200 and message is "SUCCESS" for news

  Scenario: UPDATE - Put request to update specific news
    Given I set update news endpoint
    When I set update news detail and send put request
    Then I validate the status code is 200 and message is "SUCCESS" for news