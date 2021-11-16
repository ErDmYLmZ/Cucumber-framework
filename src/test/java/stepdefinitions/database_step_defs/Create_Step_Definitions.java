package stepdefinitions.database_step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

public class Create_Step_Definitions {

    @When("user creates a new hotel with this values {string}")
    public void user_creates_a_new_hotel_with_this_values(String hotelData) {
        String query ="INSERT INTO tHOTEL (Code,Name,Address,Phone,Email,CreateDate,CreateUser) " +
                "VALUES ("+hotelData+");";

        DBUtils.executeQuery(query);
    }


    @Then("verify the creation is successful")
    public void verify_the_creation_is_successful() {
        //Asserting if tHOTEL table Name column contains Royal King Hotel - the one that we just created
        DBUtils.getColumnData("SELECT Name FROM tHOTEL","Name").toString().contains("Royal King Hotel");
    }
//    @When("user creates a new hotel with {string}")
//    public void user_creates_a_new_hotel_with(String values) {
//        String query = "INSERT INTO tHOTEL (Code,   Name,        Address,    Phone,     Email,    CreateDate    CreateUser)"+"VALUES"+values;
//        DBUtils.executeQuery(query);
//    }
//
//
//    @Then("user verifies the succesfully saved")
//    public void userVerifiesTheSuccesfullySaved() {
////        List<Object>SuccesfullySavedData = DBUtils.getColumnData("Select Name from tHOTEL", "Name");
////        Assert.assertTrue(SuccesfullySavedData.toString().contains("Hotel California"));
//   DBUtils.getColumnData("SELECT Name FROM tHOTEL", "Name").toString().contains("Hotel California");
//
//    }
}