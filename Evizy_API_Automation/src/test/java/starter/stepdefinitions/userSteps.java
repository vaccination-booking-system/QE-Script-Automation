package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.user;

public class userSteps {

    @Steps
    user user;
    @Given("I set get all users endpoint")
    public void iSetGetAllUsersEndpoint() {
        user.setEndpointForGetAllUsers();
    }

    @When("I send get all users request")
    public void iSendGetAllUsersRequest() throws Exception {
        user.sendGetAllUsersRequest();
    }

    @Then("I validate the status code is {int} and validate the message is {string} for user")
    public void iValidateTheStatusCodeIsAndValidateTheMessageIsForUser(int arg0, String arg1) {
        user.validateStatusCodeAfterSendGetAllUsers(arg0, arg1);
    }

    @Given("I set get specififc user endpoint")
    public void iSetGetSpecififcUserEndpoint() {
        user.setGetSpecificUserEndpoint();
    }

    @When("I send get specific user request")
    public void iSendGetSpecificUserRequest() throws Exception {
        user.sendGetSpecificUserReq();
    }

    @Then("I validate the status code is {int} and validate user detail")
    public void iValidateTheStatusCodeIsAndValidateUserDetail(int arg0) {
        user.validateStatusCodeAndDetailForSpecUser(arg0);
    }
}
