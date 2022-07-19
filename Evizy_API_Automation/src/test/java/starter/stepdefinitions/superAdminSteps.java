package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.admin.login_SuperAdmin;

public class superAdminSteps {

    @Steps
    login_SuperAdmin logsuper;

    @Given("I set endpoint login for admin")
    public void iSetEndpointLoginForAdmin() {
        logsuper.setEndpointForSuperAdmin();
    }

    @When("I set username and password with super admin credentials and i send POST Request")
    public void iSetUsernameAndPasswordWithSuperAdminCredentialsAndISendPOSTRequest() {
        logsuper.setSuperAdminDetails();
    }

    @Then("I validate the status code {int}")
    public void iValidateTheStatusCode(int arg0) {
        logsuper.validateStatusCodeForSuperAdmin(arg0);
    }
    @And("get the access token")
    public void getTheAccessToken() {
        logsuper.getAccessToken();
    }


}
