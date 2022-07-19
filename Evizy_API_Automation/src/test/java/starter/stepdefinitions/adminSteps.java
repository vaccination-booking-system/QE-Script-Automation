package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.admin;

public class adminSteps {

    @Steps
    admin admin;

    @Given("I set endpoint for Get all Admin")
    public void setEndpointToGetAllAdmin(){
        admin.getAllAdmin();

    }

    @When("I send get all admin request")
    public void iSendGetAllAdminRequest() throws Exception {
        admin.sendGetAllAdminRequest();
    }

    @Then("I validate the status code is {int} and the message is {string}")
    public void iValidateTheStatusCodeIsAndTheMessageIs(int arg0, String arg1) {
        admin.validateStatusCodeAndMessageForAdmin(arg0, arg1);
    }

    @Given("I set endpoint for Get admin using id")
    public void iSetEndpointForGetAdminUsingIdId() {
        admin.setGetSpecificAdminEndpoint();
    }

    @When("I send get admin using id request {int}")
    public void iSendGetAdminUsingIdRequest(int id) throws Exception {
        admin.sendGetSpecificAdminRequest(id);
    }

    @Then("I validate the {int} and i validate the message {string}")
    public void iValidateTheStatus_codeAndIValidateTheMessage(int code,String arg0) {
        admin.validateStatusCodeAndMessageForAdmin(code, arg0);
    }

    @Given("I set endpoint for delete specific admin using id")
    public void iSetEndpointForDeleteSpecificAdminUsingId() {
        admin.setEndpointForDeleteAdmin();
    }

    @When("I send delete specific admin request")
    public void iSendDeleteSpecificAdminRequest() throws Exception {
        admin.sendDeleteAdminRequest();
    }

    @Given("I set endpoint for update admin's data")
    public void iSetEndpointForUpdateAdminSData() {
        admin.setEndpointForUpdateAdmin();
    }

    @When("I set {string}, {string}, {string} and send put request")
    public void iSetAndSendPutRequest(String arg0, String arg1, String arg2) throws Exception {
        admin.setUpdateDataDetails(arg0, arg1, arg2);
    }


    @Then("I validate status code is {int} and validate the detail")
    public void iValidateStatusCodeIsAndValidateTheDetail(int arg0) {
        admin.validatestatusCodeAndDetailAfteUpdate(arg0);
    }


}
