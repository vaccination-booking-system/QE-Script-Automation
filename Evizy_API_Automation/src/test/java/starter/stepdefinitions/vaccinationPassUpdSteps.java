package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.vaccination.vaccination_pass_update;

public class vaccinationPassUpdSteps {

    @Steps
    vaccination_pass_update vacPass_Upd;

    @Given("I set vaccination pass endpoint")
    public void iSetVaccinationPassEndpoint() {
        vacPass_Upd.setVaccinationPassEndpoint();
    }

    @When("I set vaccination pass detail and send post request")
    public void iSetVaccinationPassDetailAndSendPostRequest() throws Exception {
        vacPass_Upd.sendCreateVaccinationPassEndpoint();
    }

    @Then("I validate the status code and vaccination pass detail")
    public void iValidateTheStatusCodeAndVaccinationPassDetail() {
        vacPass_Upd.validateAfterCreateVaccinationPass();
    }

    @Given("I set an endpoint to get all vaccination pass")
    public void iSetAnEndpointToGetAllVaccinationPass() {
        vacPass_Upd.setVaccinationPassEndpoint();
    }

    @When("I send get all vaccination pass request")
    public void iSendGetAllVaccinationPassRequest() throws Exception {
        vacPass_Upd.sendGetAllVaccinationPassReq();
    }

    @Then("I validate the status code is {int} and validate the message for vaccination pass")
    public void iValidateTheStatusCodeIsAndValidateTheMessageForVaccinationPass(int arg0) {
        vacPass_Upd.validateStatusCodeAndMesssageForVaccPass(arg0);
    }

    @Given("I set an endpoint to get specific vaccination")
    public void iSetAnEndpointToGetSpecificVaccination() {
        vacPass_Upd.setGetSpecificVaccPassEndpoint();
    }

    @When("I send get specific vaccination request")
    public void iSendGetSpecificVaccinationRequest() throws Exception {
        vacPass_Upd.sendGetSpecificVaccPassReq();
    }

    @Given("I set an endpoint to delete specific vaccination pass")
    public void iSetAnEndpointToDeleteSpecificVaccinationPass() {
        vacPass_Upd.setDeleteVaccinationPassEndpoint();
    }

    @When("I send delete specific vaccination pass request")
    public void iSendDeleteSpecificVaccinationPassRequest() throws Exception {
        vacPass_Upd.sendDeleteVaccinePassReq();
    }

    @Given("I set an endpoint to update vaccination pass detail")
    public void iSetAnEndpointToUpdateVaccinationPassDetail() throws Exception {
        vacPass_Upd.sendUpdateVaccinationPassEndpoint();
    }

    @When("I send update vaccination pass detail request")
    public void iSendUpdateVaccinationPassDetailRequest() throws Exception {
        vacPass_Upd.sendUpdateVaccinationPassEndpoint();
    }

    @Given("I set an endpoint for update vaccination status")
    public void iSetAnEndpointForUpdateVaccinationStatus() {
        vacPass_Upd.setUpdateVaccStatusEndpoint();
    }

    @When("I change the vaccination status to true")
    public void iChangeTheVaccinationStatusToTrue() throws Exception {
        vacPass_Upd.sendVaccStatusTrue();
    }


    @When("I change the vaccination status to false")
    public void iChangeTheVaccinationStatusToFalse() throws Exception {
        vacPass_Upd.sendVaccStatusFalse();
    }
}
