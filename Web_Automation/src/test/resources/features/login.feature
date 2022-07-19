#Feature: Login
#  As a user
#  I want to login to my account
#  So that I can book vaccination session
#
#  Scenario Outline: Login
#    Given I am on Evizy login page
#    When I input "<NIK>"
#    And Input "<Password>"
#    And I click sign in  button
#    Then I get "<Result>"
#
#    Examples:
#    |NIK|Password|Result|
#    |5719348816440007|Password321|dashboard_page|
#    |7489462587164955|Passwordtest11|NIK atau Password Salah|
#    |5719348816440007|Ayobermain12  |NIK atau Password Salah|
#    |7489462587164955|Password321   |NIK atau Password Salah|
#    |                |Password321   |NIK Tidak Boleh Kosong|
#    |5719348816440007|              |Password Tidak Boleh Kosong|
#    |                |              |both alert message show up|
#    |716485awf4441689|Password321   |NIK Tidak Valid|
#    |788943156491    |Passwordtest321|NIK Tidak Valid|
#    |788943156491^&13|Passwordtest321|NIK Tidak Valid|






