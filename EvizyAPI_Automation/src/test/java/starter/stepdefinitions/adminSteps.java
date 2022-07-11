package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.admin.post_admin;

public class adminSteps {

    post_admin postadmin;

    @Given("I set endpoint for login as an admin")
    public void iSetEndpointForLoginAsAnAdmin() {
        postadmin.setPostAdminEndpoint();
    }

    @When("I set username {string}, {string}, {string} and i send post request")
    public void iSetUsernameAndISendPostRequest(String arg0, String arg1, String arg2)throws Exception {
        postadmin.setPostAdminDetail(arg0, arg1, arg2);
    }

    @Then("I validate the status code {int} and message after send post request")
    public void iValidateTheStatusCodeStatus_codeAndAfterSendPostRequest(int arg0) {
        postadmin.validateStatusCodeAndDetailAfterPostAdmin(arg0);
    }

//    @Given("I set endpoint for get all admins")
//    public void iSetEndpointForGetAllAdmins() {
//    }
//
//    @When("I send get request")
//    public void iSendGetRequest() {
//    }
//
//    @Then("I validate the status code is {int} and i validate the message")
//    public void iValidateTheStatusCodeIsAndIValidateTheMessage(int arg0) {
//    }
//
//    @Given("I set endpoint for get admin detail using {int}")
//    public void iSetEndpointForGetAdminDetailUsingId() {
//    }
//
//    @When("I send get admin detail request")
//    public void iSendGetAdminDetailRequest() {
//    }
//
//    @Then("I validate the status code {int} and validate the {string} after send get request")
//    public void iValidateTheStatusCodeStatus_codeAndValidateTheAfterSendGetRequest(String arg0) {
//    }
//
//    @Given("I set endpoint for delete specific admin")
//    public void iSetEndpointForDeleteSpecificAdmin() {
//    }
//
//    @When("I send delete request")
//    public void iSendDeleteRequest() {
//    }
//
//    @Given("I set endpoint for update admin's name using id")
//    public void iSetEndpointForUpdateAdminSNameUsingId() {
//    }
//
//    @When("I set name with new name and send PUT request")
//    public void iSetNameWithNewNameAndSendPUTRequest() {
//    }
//
//    @Then("I validate the status code is {int} and validate the name has changed")
//    public void iValidateTheStatusCodeIsAndValidateTheNameHasChanged(int arg0) {
//    }
}
