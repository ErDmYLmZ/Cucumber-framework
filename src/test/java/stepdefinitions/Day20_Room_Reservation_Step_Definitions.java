package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.RoomReservationPage;

import java.util.List;
import java.util.Map;

public class Day20_Room_Reservation_Step_Definitions {

    DefaultPage defaultPage = new DefaultPage();
    RoomReservationPage roomReservationPage = new RoomReservationPage();

    @Given("user navigates to the create_room_reservation page")
    public void user_navigates_to_the_create_room_reservation_page() {
        defaultPage.hotelManagementLink.click();
        defaultPage.roomReservationsLink.click();
        roomReservationPage.addRoomReservationButton.click();

    }

    @Given("user enters all required fields")
    public void user_enters_all_required_fields(DataTable roomData) {
//        List<String> testData = roomData.row(1);
//        System.out.println(testData);//[manager, Ayse, 500, 11/08/2021, 11/12/2021, 2, 3, test, (999) 999-9999, test@gmail.com, test note]
//
//        //idUser is a dropdown
//        Select selectIdUser=new Select(roomReservationPage.idUser);
//        selectIdUser.selectByVisibleText(testData.get(0));
//
//        //idHotel is a dropdown
//        Select selectIdHotel= new Select(roomReservationPage.idHotelRoom);
//        selectIdHotel.selectByVisibleText(testData.get(1));
//
//        //price
//        roomReservationPage.price.sendKeys(testData.get(2));
//        //dateStart
//        roomReservationPage.dateStart.sendKeys(testData.get(3));
//        //dateEnd
//        roomReservationPage.dateEnd.sendKeys(testData.get(4));
//        //adultAmount
//        roomReservationPage.adultAmount.sendKeys(testData.get(5));
//        //childrenAmount
//        roomReservationPage.childrenAmount.sendKeys(testData.get(6));
//        //contactNameSurname
//        roomReservationPage.contactNameSurname.sendKeys(testData.get(7));
//        //contactPhone
//        roomReservationPage.contactPhone.sendKeys(testData.get(8));
//        //contactEmail
//        roomReservationPage.contactEmail.sendKeys(testData.get(9));
//        //notes
//        roomReservationPage.notes.sendKeys(testData.get(10));


        // }
        // 2. Getting the data as List<List<String>>
//        List<List<String>> userCredentials = roomData.asLists();
//        for (List<String> eachCredentials : userCredentials) {
//            if (!eachCredentials.get(0).equals("idUser")) {
//                Select selectIdUser = new Select(roomReservationPage.idUser);
//                selectIdUser.selectByVisibleText(eachCredentials.get(0));
//
//                Select selectIdHotelRoom = new Select(roomReservationPage.idHotelRoom);
//                selectIdHotelRoom.selectByVisibleText(eachCredentials.get(1));
//
//                roomReservationPage.price.sendKeys(eachCredentials.get(2));
//                roomReservationPage.dateStart.sendKeys(eachCredentials.get(3));
//                roomReservationPage.dateEnd.sendKeys(eachCredentials.get(4));
//                roomReservationPage.adultAmount.sendKeys(eachCredentials.get(5));
//                roomReservationPage.childrenAmount.sendKeys(eachCredentials.get(6));
//                roomReservationPage.contactNameSurname.sendKeys(eachCredentials.get(7));
//                roomReservationPage.contactPhone.sendKeys(eachCredentials.get(8));
//                roomReservationPage.contactEmail.sendKeys(eachCredentials.get(9));
//                roomReservationPage.notes.sendKeys(eachCredentials.get(10));
//
//
//            }
//        }
        // 3. List<Map<String,String>>
        List<Map<String,String>> userCredentials= roomData.asMaps(String.class,String.class);
        for (Map<String,String> eachCredentials:userCredentials){
            System.out.println(eachCredentials);

            Select selectIdUser = new Select(roomReservationPage.idUser);
            selectIdUser.selectByVisibleText(eachCredentials.get("idUser"));

            Select selectIdHotelRoom = new Select(roomReservationPage.idHotelRoom);
            selectIdHotelRoom.selectByVisibleText(eachCredentials.get("idHotelRoom"));

            roomReservationPage.price.sendKeys(eachCredentials.get("price"));
            roomReservationPage.dateStart.sendKeys(eachCredentials.get("dateStart"));
            roomReservationPage.dateEnd.sendKeys(eachCredentials.get("dateEnd"));
            roomReservationPage.adultAmount.sendKeys(eachCredentials.get("adultAmount"));
            roomReservationPage.childrenAmount.sendKeys(eachCredentials.get("childrenAmount"));
            roomReservationPage.contactNameSurname.sendKeys(eachCredentials.get("contactNameSurname"));
            roomReservationPage.contactPhone.sendKeys(eachCredentials.get("contactPhone"));
            roomReservationPage.contactEmail.sendKeys(eachCredentials.get("contactEmail"));
            roomReservationPage.notes.sendKeys(eachCredentials.get("notes"));
        }
    }
    @And("user clicks on the approved_checkbox")
    public void user_clicks_on_the_approved_checkbox() {
        roomReservationPage.isApproved.click();
    }
    @Given("user clicks on the paid_checkbox")
    public void user_clicks_on_the_paid_checkbox() {
        roomReservationPage.isPaid.click();
    }
    @Given("user clicks on the save_button")
    public void user_clicks_on_the_save_button() {
        roomReservationPage.submitButton.click();
    }
//    @Then("user verifies the success_message")
//    public void user_verifies_the_success_message() throws InterruptedException {
//        Thread.sleep(1000);
//        String successMessage = roomReservationPage.successMessage.getText();
//        String expectedSuccessMessage="RoomReservation was inserted successfully";
//        Assert.assertEquals(expectedSuccessMessage,successMessage);
//        roomReservationPage.okButton.click();
//    }

    }
