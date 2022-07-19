package starter.stepdefinitions;

import io.cucumber.java.en.And;
import starter.pages.admin.vaccination_booking;

public class vaccinationBookingSteps {

    vaccination_booking vaccbook;
    @And("I click vaccination bookings")
    public void iClickVaccinationBookings() {
        vaccbook.clickVaccinationBookingButton();
    }

    @And("I click edit status button")
    public void iClickEditStatusButton() {
        vaccbook.clickEditStatusButton();
    }

    @And("I click choose vaccination status {string}")
    public void iClickChooseVaccinationStatus(String arg0) throws Exception {
        if(arg0.equals("vaccinated")){
            Thread.sleep(600);
            vaccbook.scrollTo();
            vaccbook.clickVaccinatedButton();
        } else if(arg0.equals("not_yet")) {
            Thread.sleep(600);
            vaccbook.scrollTo();
            vaccbook.clickNotYetButton();
        }
    }

    @And("I click update button")
    public void iClickUpdateButton() {
        vaccbook.clickUpdateStatusButton();
    }

    @And("I success update vaccination status {string}")
    public void iSuccessUpdateVaccinationStatus(String arg0) throws Exception {
        if(arg0.equals("vaccinated")){
            Thread.sleep(2000);
            vaccbook.successUpdateVaccinatedStatus();
        } else if (arg0.equals("not_yet")){
            vaccbook.successUpdateNotYetStatus();
        }
    }
}
