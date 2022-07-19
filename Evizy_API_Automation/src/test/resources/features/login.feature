Feature: Login
  As a citizen
  I should be able to login
  So that i can access the features

  Scenario Outline: Login
    Given I set login endpoint
    When I set NIK "<NIK>" and password "<Password>" for login
    Then I validate the status code after login is <status_code>

    Examples:
    |NIK|Password|status_code|
    |5719348816440007|Password321|200|
    |7489462587164955|Passwordtest11|400|
    |5719348816440007|Ayobermain12  |400|
    |7489462587164955|Password321   |400|
    |                |Password321   |400|
    |5719348816440007|              |400|
    |               |                |400|
    |716485awf4441689|Password321   |400|
    |788943156491    |Password321   |400|
    |788943156491^&13|Password321   |400|
    |5719348816440007|password456   |400|
    |5719348816440007|passworddd    |400|
    |5719348816440007|passS13       |400|
