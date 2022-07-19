package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.postAdmin;

public class postAdminSteps {

    @Steps
    postAdmin postadmin;

    @Given("I set endpoint for create  an admin")
    public void iSetEndpointForCreateAdmin() {
        postadmin.setpostAdminEndpoint();
    }

    @When("I set username {string}, {string}, {string} and i send request for post admin")
    public void iSetUsername(String arg0, String arg1, String arg2) throws Exception {
        postadmin.setAdminPostDetails(arg0, arg1, arg2);
    }


    @Then("I validate the status code {int} and message {string} after send post request")
    public void iValidateTheStatusCodeStatus_codeAndMessageAfterSendPostRequest(int code,String message) {
        postadmin.validateStatusCodeAfterPostAdminRequest(code,message);

    }

    @Given("I set an endpoint for login as an admin")
    public void iSetAnEndpointForLoginAsAnAdmin() {
        postadmin.setLoginAdminEndpoint();
    }

    @When("I set admin username and password")
    public void iSetAndAndSendPostRequest() {
        postadmin.sendLoginAdminRequest();
    }

    @Then("I validate the status code is {int} and i get the access token")
    public void iValidateTheStatusCodeIsAndIGetTheAccessToken(int arg0) {
        postadmin.validateStatusCodeAndGetAccessToken(arg0);
    }
}
