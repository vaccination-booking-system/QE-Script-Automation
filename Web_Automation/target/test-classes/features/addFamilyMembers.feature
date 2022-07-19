#Feature: Add Family Members
#  As a user
#  I Should be able to add my family members
#  So that i can book vaccination session for them
#
#  Scenario Outline: Add family member
#    Given I am on login page to do login
#    When  I enter my username and password and click login button
#    And I directed to dashboard
#    And I click add family member section
#    And I click add family member button
#    And I enter family member's fullname "<nama_lengkap>"
#    And I enter date of birth "<dob>"
#    And I enter family member's nik "<nik>"
#    And I enter family member's phone number "<nomor_telepon>"
#    And I select gender "<gender>"
#    And I select status "<status>"
#    And I click add family member button "<result>"
#    Examples:
#    |nama_lengkap|dob|nik|nomor_telepon|gender|status|result|
#    |Jessica Sheva|16071997|7390284903604270|085431941246|Perempuan|Saudara|clickable|
#    |Jess1ca |16071997     |7390284903604270|085431941246|Perempuan|Saudara|error message for name|
#    |Jessica Sheva |16071997|7390284903604t70|085431941246|Perempuan|Saudara|error meesage for nik|
#    |Jessica Sheva |16071997|7390284903604270|08543194t246|Perempuan|Saudara|error message for phonenum|
#    |              |          |                |            |         |       |data not valid       |
#    |Bayu Dwijo     |07082008 |7789461301679513  |0852164997891|Laki-Laki|Lain-Lain|data not valid |

    #nik = 3534518716226907
    #password = jennieRubyjane16