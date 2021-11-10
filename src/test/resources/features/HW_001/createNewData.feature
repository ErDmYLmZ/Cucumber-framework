@Data_scenOut_excel_dataTable
Feature: HomeWork_Create_New_Data
  @create_new_data_outline
 Scenario Outline:User_can_create_new_user_with_scenarioOutline
   Given user go to https://editor.datatables.net/
   Then user clicks on the new button
   And user enters First name "<first_name>"
   And user enters last name "<last_name>"
   And user enters position  "<position>"
   And user enters office  "<office>"
   And user enters extension "<extension>"
   And user enters start date "<start_date>"
   And user enters salary "<salary>"
   Then user clicks on the create button
   And search for the first name "<first_name>" and last name "<last_name>"
   Then verify the name fields contains first name "<first_name>" and last name "<last_name>"
   Then close the application


   Examples: user_data
     | first_name | last_name | position | office | extension | start_date | salary     |
     | John       | Walker    | doctor   | LA     | 456       | 2022-10-10 | 78900.000  |
     | ihsan      | kim       | nurse    | TX     | 899       | 2022-10-11 | 7890000089 |
     | Jim        | cam       | QA       | AR     | 23462     | 2022-10-12 | 789000006  |
     | Betty      | york      | lawyer   | NY     | 5613      | 2022-10-13 | 6100000    |
     | Sue        | Lui       | dev      | CA     | 400       | 2022-10-14 | 10008000   |

  @create_new_data_excel
  Scenario: User_can_create_new_data_with_excel
    Given user go to https://editor.datatables.net/
    Then user clicks on the new button
    And user enters all required fields with excel
    Then user clicks on the create button
    And search for the first name and last name
    Then verify the name fields contains first name and last name
    Then close the application

    @create_new_data_dataTables
    Scenario: User_can_create_new_data_with_datatables
      Given user go to https://editor.datatables.net/
      Then user clicks on the new button
      And user enters all required fields with data_tables
        | First name | Last name | Position | Office | Extension | Start date | Salary     |
        | John       | Walker    | doctor   | LA     | 456       | 2022-10-10 | 78900.000  |
        | ihsan      | kim       | nurse    | TX     | 899       | 2022-10-11 | 7890000089 |
        | Jim        | cam       | QA       | AR     | 23462     | 2022-10-12 | 789000006  |
        | Betty      | york      | lawyer   | NY     | 5613      | 2022-10-13 | 6100000    |
        | Sue        | Lui       | dev      | CA     | 400       | 2022-10-14 | 10008000   |
      Then user clicks on the create button
      And search for the first_name and last_name
        | First name | Last name |
        | John       | Walker    |
        | ihsan      | kim       |
        | Jim        | cam       |
        | Betty      | york      |
        | Sue        | Lui       |
      Then verify the name fields contains first_name and last_name
        | First name | Last name |
        | John       | Walker    |
        | ihsan      | kim       |
        | Jim        | cam       |
        | Betty      | york      |
        | Sue        | Lui       |
      Then close the application






