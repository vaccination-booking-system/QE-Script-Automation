package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.citizen.login_citizen;

public class loginSteps {

    @Steps
    login_citizen logcitizen;


    @Given("I set login endpoint")
    public void iSetLoginEndpoint() {
        logcitizen.setLoginEndpoint();
    }

    @When("I set NIK {string} and password {string} for login")
    public void iSetNIKAndPasswordForLogin(String arg0, String arg1) {
        logcitizen.setNIKForLogin(arg0, arg1);
    }

    @Then("I validate the status code after login is {int}")
    public void iValidateTheStatusCodeAfterLoginIsStatus_code(int arg0) {
        logcitizen.validataLoginStatusCode(arg0);
    }

}
