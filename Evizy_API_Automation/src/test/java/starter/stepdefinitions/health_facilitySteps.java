package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.health_facility.postHealthFacility;

public class health_facilitySteps {

    @Steps
    postHealthFacility posthealthfac;

    @Given("I set endpoint for create health facility")
    public void setEndpointForCreateHealthFac(){
        posthealthfac.setPostHealthFacEndpoint();

    }

    @When("I set post detail and send post request fot health facility")
    public void iSetPostDetail() throws Exception {
        posthealthfac.sendPostReqToCreateHealthFac();
    }



    @Then("I validate status code is {int} and message is {string} afer post health fac req")
    public void iValidateStatusCodeIsAndMessageIsAferPostHealthFacReq(int arg0, String arg1) {
        posthealthfac.validateStatusCodeAndDetailAfterPostHealthFac(arg0, arg1);
    }

    @Given("I set endpoint for get specific health facility")
    public void iSetEndpointForGetSpecificHealthFacility() {
        posthealthfac.setGetSpecificHealthFacEndpoint();
    }

    @When("I send get specific health facility request")
    public void iSendGetSpecificHealthFacilityRequest() throws Exception {
        posthealthfac.sendGetSpecHealthFacReq();
    }

    @Then("I validate the status code and health facility's detail")
    public void iValidateTheStatusCodeAndHealthFacilitySDetail() {
        posthealthfac.validateDetailForSpecHealthFac();
    }

    @Given("I set endpoint for get all health facilities")
    public void iSetEndpointForGetAllHealthFacilities() {
        posthealthfac.setGetAllHealthFacEndpoint();
    }

    @When("I send get all health facilities request")
    public void iSendGetAllHealthFacilitiesRequest() throws Exception {
        posthealthfac.sendGetAllHealthFacReq();
    }

    @Then("I validate the status code is {int} and i validate the message is {string} for health facility")
    public void iValidateTheStatusCodeIsAndIValidateTheMessageIsForHealthFacility(int arg0, String arg1) {
        posthealthfac.validateAfterSendRequestForHealthFacility(arg0, arg1);
    }

    @Given("I set endpoint for delete specific health facility")
    public void iSetEndpointForDeleteSpecificHealthFacility() {
        posthealthfac.setDeleteHealthFacEndpoint();
    }

    @When("I send delete health facility request")
    public void iSendDeleteHealthFacilityRequest() throws Exception {
        posthealthfac.sendDeleteHealthFacReq();
    }
}
