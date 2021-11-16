Feature: create_new_hotel
  Scenario: TC01_Create_Hotel_Test
    Given user connects to the database
    When user creates a new hotel with this values "'3000','Royal King Hotel','LA Downtown','8889900','royalla@testemail.com','2021-10-10 19:40:47.597', 4"
    Then verify the creation is successful

#  Feature: create_new_hotel
#    @db_create_hotel
#    Scenario: TC_01_Create_Hotel_Record
#      Given user connects to the database
#      When user creates a new hotel with "'300','Hotel California','Istanbul','4444444','realtester@test.com','2021-10-10 19:40:47.597','5'"
#      Then user verifies the succesfully saved
#      Then close the application
