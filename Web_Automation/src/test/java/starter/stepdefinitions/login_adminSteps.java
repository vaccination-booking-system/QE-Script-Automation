package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.admin.login_admin;
import starter.pages.dashboardPage;

public class login_adminSteps {

    @Steps
    login_admin loginadmin;

    dashboardPage dashpage;

    @Given("I am on Evizy login admin page")
    public void iAmOnEvizyLoginAdminPage() {
        loginadmin.openAdminUrlPage();
    }

    @When("I input admin username {string}")
    public void iInputAdminUsername(String arg0) {
        loginadmin.inputUsernameForLogin(arg0);
    }

    @And("I input admin password {string}")
    public void iInputAdminPassword(String arg0) {
        loginadmin.inputAdminPasswordForLogin(arg0);
    }

    @And("I click admin's login button")
    public void iClickAdminSLoginButton() {
        loginadmin.clickAdminLoginButton();
    }

    @Then("I get the admin result {string}")
    public void iGetTheAdminResult(String arg0) throws Exception {
        if (arg0.equals("dashboard_page")){
            Thread.sleep(500);
            dashpage.menuOnDashboardDisplayed();
        } else if (arg0.equals("username atau password salah")){
            Thread.sleep(500);
            loginadmin.usernameAtauPassSalahDisplayed();
        } else if(arg0.equals("stay on login page")){
            Thread.sleep(500);
            loginadmin.passwordTidakKosongDisplayed();
            loginadmin.usernameTidakBolehKosongDisplayed();
        }
    }
}
