package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.citizen.register_citizen;

public class registerSteps {

    @Steps
    register_citizen reqcitizen;


    @Given("I set register endpoint")
    public void iSetRegisterEndpoint() {
        reqcitizen.registerEndpoint();
    }

    @When("I set nama {string} nik {string} and password {string} for register")
    public void iSetNamaNikAndPasswordForRegister(String arg0, String arg1, String arg2) {
        reqcitizen.SetNamaNIKandPasswordForRegist(arg0, arg1, arg2);
    }

    @Then("I validate the status code for register and the message {string}")
    public void iValidateTheStatusCodeForRegisterAndTheMessage(String arg0) {
        reqcitizen.validateMessageAndStatusCode(arg0);
    }

}
