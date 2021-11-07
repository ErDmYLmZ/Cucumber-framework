package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EditorPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Hw_Create_New_Data_Step_Definitions {
    EditorPage editorPage = new EditorPage();
    ExcelUtil excelUtil;
    List<Map<String, String>> testData;


    @Given("user go to https://editor.datatables.net/")
    public void userGoToHttpsEditorDatatablesNet() {
        Driver.getDriver().get(ConfigReader.getProperty("editor_datatables_url"));
    }

    @Then("user clicks on the new button")
    public void user_clicks_on_the_new_button() {
        ReusableMethods.waitFor(1);
        editorPage.newButton.click();

    }

        @Then("user enters First name {string}")
    public void user_enters_first_name(String firstName) {
        editorPage.firstNameField.sendKeys(firstName);
    }

    @Then("user enters last name {string}")
    public void user_enters_last_name(String lastName) {
        editorPage.lastNameField.sendKeys(lastName);
    }

    @Then("user enters position  {string}")
    public void user_enters_position(String posit) {
        editorPage.positionField.sendKeys(posit);
    }

    @Then("user enters office  {string}")
    public void user_enters_office(String office) {
        editorPage.officeField.sendKeys(office);
    }

    @Then("user enters extension {string}")
    public void user_enters_extension(String extn) {
        editorPage.extensionField.sendKeys(extn);
    }

    @Then("user enters start date {string}")
    public void user_enters_start_date(String sDate) {
        editorPage.startDateField.sendKeys(sDate);
    }

    @Then("user enters salary {string}")
    public void user_enters_salary(String salary) {
        editorPage.salaryField.sendKeys(salary);
    }

    @Then("user clicks on the create button")
    public void user_clicks_on_the_create_button() {
        editorPage.createButton.click();
    }

    @And("search for the first name {string} and last name {string}")
    public void searchForTheFirstNameAndLastName(String firstName, String lastName) {
        editorPage.searchBox.sendKeys((firstName + " " + lastName));
    }

    @Then("verify the name fields contains first name {string} and last name {string}")
    public void verifyTheNameFieldsContainsFirstNameAndLastName(String firstName, String lastName) {
        Assert.assertEquals((firstName + " " + lastName), editorPage.tdBox.getText());
    }


    @And("user enters all required fields with excel")
    public void userEntersAllRequiredFieldsWithExcel() throws InterruptedException {
        String path = "./src/test/resources/testdata/createNewData.xlsx";
        String sheetName = "create_new_user";
        excelUtil = new ExcelUtil(path, sheetName);
        testData = excelUtil.getDataList();
        System.out.println(testData);
        for (Map<String, String> fieldEach : testData) {
            editorPage.firstNameField.sendKeys(fieldEach.get("First name"));
            editorPage.lastNameField.sendKeys(fieldEach.get("Last name"));
            editorPage.positionField.sendKeys(fieldEach.get("Position"));
            editorPage.officeField.sendKeys(fieldEach.get("Office"));
            editorPage.extensionField.sendKeys(fieldEach.get("Extension"));
            editorPage.startDateField.sendKeys(fieldEach.get("Start date"));
            editorPage.salaryField.sendKeys(fieldEach.get("Salary"));
        }
    }

    @And("search for the first name and last name")
    public void searchForTheFirstNameAndLastName() throws InterruptedException {

        String path = "./src/test/resources/testdata/createNewData.xlsx";
        String sheetName = "create_new_user";
        excelUtil = new ExcelUtil(path, sheetName);
        testData = excelUtil.getDataList();
        for (Map<String, String> fieldEach : testData) {
            editorPage.searchBox.sendKeys(fieldEach.get("First name") + " " + fieldEach.get("Last name"));
        }
    }

    @Then("verify the name fields contains first name and last name")
    public void verifyTheNameFieldsContainsFirstNameAndLastName() {
        String path = "./src/test/resources/testdata/createNewData.xlsx";
        String sheetName = "create_new_user";
        excelUtil = new ExcelUtil(path, sheetName);
        testData = excelUtil.getDataList();

        for (Map<String, String> fieldEach : testData) {
            Assert.assertTrue(editorPage.tdBox.getText().equals(fieldEach.get("First name") + " " + fieldEach.get("Last name")));
        }
    }


    @Then("user enters all required fields with data_tables")
    public void user_enters_all_required_fields_with_data_tables(DataTable userData) {
        List<Map<String, String>> newUserData = userData.asMaps(String.class, String.class);
        for (Map<String, String> eachData : newUserData) {
            System.out.println(eachData);
            editorPage.firstNameField.sendKeys(eachData.get("First name"));
            editorPage.lastNameField.sendKeys(eachData.get("Last name"));
            editorPage.positionField.sendKeys(eachData.get(("Position")));
            editorPage.officeField.sendKeys(eachData.get("Office"));
            editorPage.extensionField.sendKeys(eachData.get("Extension"));
            editorPage.startDateField.sendKeys(eachData.get("Start date"));
            editorPage.salaryField.sendKeys(eachData.get("Salary"));
        }
    }

    @Then("search for the first_name and last_name")
    public void search_for_the_first_name_and_last_name(DataTable dataTable) {
        List<Map<String, String>> newUserData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> eachData : newUserData){
            editorPage.searchBox.sendKeys(eachData.get("First name")+" "+eachData.get("Last name"));
        }
    }
    @Then("verify the name fields contains first_name and last_name")
    public void verify_the_name_fields_contains_first_name_and_last_name(DataTable dataTable) {
        List<Map<String, String>> newUserData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> eachData : newUserData) {
            Assert.assertEquals(eachData.get("First name") + " " + eachData.get("Last name"), editorPage.tdBox.getText());
        }


    }


}

