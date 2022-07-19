package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.vaccine;

public class vaccineSteps {

    @Steps
    vaccine vaccine;

    @Given("I set an endpoint to create vaccine")
    public void iSetCreateVaccineEndpoint(){
        vaccine.setCreateVaccineEndpoint();

    }

    @When("I set vaccine's name {string} and send create vaccine detail")
    public void iSetVaccineSNameAndSendCreateVaccineDetail(String arg0) throws Exception {
        vaccine.sendCreateVaccineDetail(arg0);
    }

    @Then("I validate the status code {int} and message detail {string}")
    public void iValidateTheStatusCodeStatus_codeAndDetailAfterCreateVaccine(int code, String arg0) {
        vaccine.validateStatusCodeAndDetailAfterCreateVaccine(code,arg0);
    }

    @Given("I set get all vaccine endpoint")
    public void iSetGetAllVaccineEndpoint() {
        vaccine.setGetAllVaccineEndpoint();
    }

    @When("I send get all vaccine request")
    public void iSendGetAllVaccineRequest() throws Exception {
        vaccine.sendGetAllVaccineRequest();
    }

    @Then("I validate the status code is {int} and i validate the message {string} after send vaccine req")
    public void iValidateTheStatusCodeIsAndIValidateTheMessageAfterSendVaccineReq(int arg0, String arg1) {
        vaccine.validateAfterSendVaccineDetail(arg0, arg1);
    }

    @Given("I set get specific vaccine endpoint")
    public void iSetGetSpecificVaccineEndpoint() {
        vaccine.setGetSpecificVaccineEndpoint();
    }

    @When("I send get specific vaccine request")
    public void iSendGetSpecificVaccineRequest() throws Exception {
        vaccine.sendGetSpecificVaccineReq();
    }

    @Then("I validate the status code is {int} and i validate the vaccine detail for get vaccine")
    public void iValidateTheStatusCodeIsAndIValidateTheVaccineDetailForGetVaccine(int arg0) {
        vaccine.validateAfterSendGetSpecificVaccineReq(arg0);
    }

    @Given("I set delete specific vaccine endpoint")
    public void iSetDeleteSpecificVaccineEndpoint() {
        vaccine.setDeleteVaccineEndpoint();
    }

    @When("I send delete specific vaccine request")
    public void iSendDeleteSpecificVaccineRequest()throws Exception {
        vaccine.sendDeleteVaccineRequest();
    }

    @Given("I set update vaccine name endpoint")
    public void iSetUpdateVaccineNameEndpoint() {
        vaccine.setUpdateVaccineEndpoint();
    }

    @When("I set new name for vaccine and send update request")
    public void iSetNewNameForVaccineAndSendUpdateRequest() throws Exception {
        vaccine.sendUpdateVaccineReq();
    }

    @Then("I validate the status code is {int} and i validate the vaccine detail")
    public void iValidateTheStatusCodeIsAndIValidateTheVaccineDetail(int arg0) {
        vaccine.validateAfterUpdateDetail(arg0);
    }

    @Given("I set distribute vaccine to health facility endpoint")
    public void iSetDistributeVaccineToHealthFacilityEndpoint() {
        vaccine.setVaccineStockEndpoint();
    }

    @When("I send post request to distribute vaccine")
    public void iSendPostRequestToDistributeVaccine() throws Exception {
        vaccine.sendDistributeVaccineReq();
    }

    @Given("I set endpoint to get vaccine stock of health facility")
    public void iSetEndpointToGetVaccineStockOfHealthFacility() {
        vaccine.setVaccineStockEndpoint();
    }

    @When("I send get vaccine stock of health facility request")
    public void iSendGetVaccineStockOfHealthFacilityRequest() throws Exception {
        vaccine.sendGetHealthFacVaccineStock();
    }
}
