#Feature: Register
#  As an user
#  I should be able to do register
#  So that I can book vaccination session
#
#  Scenario Outline: Register
#    Given I am on Evizy register page
#    When I input nama "<nama>" for register
#    And I input NIK "<nik>" for register
#    And I input Nomor Telepon "<notelp>" for register
#    And I input Password "<Password>" for register
#    Then i get the register "<result>"
#    Examples:
#    |nama|nik|notelp|Password|result|
#    |Lisa Blackpink|2493368652215107|088841645931|Lalalalisa27|dashboard_page|
#    |Angeline      |4879116481234856|0876419845112|Passwordd456|NIK Sudah Terdaftar|
#    |Roseanne      |8947114651234984|0847519843153|Password66  |NIK Tidak Valid|
#    |Johnny        |8974553321648976|081245334981 |JackSparrow |User tetap berada di regis page|
#    |Johnny        |5549781345974415|0813o984315123|Katasandii45|User tetap berada di regis page|
#    |              |2497881453459416|084613221462  |qwertY09    |User tetap berada di regis page|
#    |John          |                |0854531584912 |iLoveCat23  |User tetap berada di regis page|
#    |John          |0852879513049216|2497881453459416|          |User tetap berada di regis page|
#    |Alicia        |2497881453459416|                |Twiceee12 |User tetap berada di regis page|
#    |Jihyo         |8794311678w9713016|08946216498o  |Passwordd345|User tetap berada di regis page|
#    |              |5549781348974415  |081246511662  |SpaceTest16 |User tetap berada di regis page|
#    |Rioo          |9280131313016048|088841645931  |Passwordbuattest909|dashboard_page|
#    |Awan          |2497881453459616|08534951!16213|Test12123          |User tetap berada di regis page|
#    |Ridwan        |3114168635028523|0894621346183 |Password%$001      |dashboard_page                 |
#    |              |                |              |                   |User tetap berada di regis page|
#    |Faizz :)      |7231456789461145|081345698713  |KeepSmile76^        |User tetap berada di regis page|


