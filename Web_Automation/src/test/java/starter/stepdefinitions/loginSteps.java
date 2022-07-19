package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.dashboardPage;
import starter.pages.loginPage;

public class loginSteps {

    @Steps
    loginPage loginpage;
    dashboardPage dashboardpage;


    @Given("I am on Evizy login page")
    public void iAmOnEvizyLoginPage() {
        loginpage.openUrl();
    }

    @When("I input {string}")
    public void iInput(String NIK) {
        loginpage.inputNikForLogin(NIK);
    }

    @And("Input {string}")
    public void input(String Pass) {
        loginpage.inputPasswordForLogin(Pass);
    }

    @And("I click sign in  button")
    public void iClickSignInButton() {
        loginpage.clickLoginButton();
    }

    @Then("I get {string}")
    public void iGet(String Result) throws Exception {
        if(Result.equals("dashboard_page")){
            dashboardpage.menuOnDashboardDisplayed();
        } else if(Result.equals("NIK Tidak Boleh Kosong")){
            loginpage.nikTidakKosongDisplayed();
        } else if (Result.equals("Password Tidak Boleh Kosong")){
            loginpage.passTidakKosongDisplayed();
        } else if (Result.equals("both alert message show up")){
            loginpage.nikTidakKosongDisplayed();
            loginpage.passTidakKosongDisplayed();
        } else if (Result.equals("NIK atau Password Salah")){
            Thread.sleep(1000);
            loginpage.nikAtauPassSalahDisplayed();
        } else if (Result.equals("NIK Tidak Valid")){
            Thread.sleep(800);
            loginpage.nikTidakValidDisplayed();
        } else{
            Thread.sleep(800);
            loginpage.nikAtauPassSalahDisplayed();
        }
    }

}
