package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.vaccination.vaccination_session;

public class Vaccination_sessionSteps {

    @Steps
    vaccination_session vacSession;

    @Given("I set endpoint for create vaccination session")
    public void iSetEndpointForCreateVaccinationSession() {
        vacSession.setCreateVaccinationSessionEndpoint();
    }

    @When("I set vaccination session detail and send post request")
    public void iSetVaccinationSessionDetailAndSendPostRequest() throws Exception {
        vacSession.sendCreateVaccinationSessionReq();
    }

    @Then("I validate the status code for create vaccination session is {int} and validate the detail")
    public void iValidateTheStatusCodeForCreateVaccinationSessionIsAndValidateTheDetail(int arg0) {
        vacSession.validateStatusCodeAndSessionDetail(arg0);
    }

    @Given("I set endpoint for get vaccination session of specific city")
    public void iSetEndpointForGetVaccinationSessionOfSpecificCity() {
        vacSession.setEndpointForFindVacSesByCity();
    }

    @When("I set get request for vaccination session of specfic city")
    public void iSetGetRequestForVaccinationSessionOfSpecficCity() throws Exception {
        vacSession.sendFindVacSesByCityReq();
    }

    @Then("I validate the status code for vaccination is {int} and message is {string}")
    public void iValidateTheStatusCodeForVaccinationIsAndMessageIs(int arg0, String arg1) {
        vacSession.validateStatusCodeForVacSession(arg0, arg1);
    }

    @Given("I set endpoint for get specific vaccination session")
    public void iSetEndpointForGetSpecificVaccinationSession() {
        vacSession.setGetSpecificVacSessionEndpoint();
    }

    @When("I set get request for specific vaccination session")
    public void iSetGetRequestForSpecificVaccinationSession() throws Exception {
        vacSession.sendGetSpecVacSessionReq();
    }

    @Given("I set endpoint for delete specific vaccination session")
    public void iSetEndpointForDeleteSpecificVaccinationSession() {
        vacSession.setDeleteVaccinationSesEndpoint();
    }

    @When("I send delete specific vaccination session request")
    public void iSendDeleteSpecificVaccinationSessionRequest() throws Exception {
        vacSession.sendDeleteVaccinationSessionreq();
    }

    @Given("I set endpoint for update vaccination session of health facility")
    public void iSetEndpointForUpdateVaccinationSessionOfHealthFacility() {
        vacSession.setGetSpecificVacSessionEndpoint();
    }

    @When("I set vaccination session update detail and send put request")
    public void iSetVaccinationSessionUpdateDetailAndSendPutRequest()throws Exception {
        vacSession.setUpdateVaccinationSessionDetail();
    }
}
