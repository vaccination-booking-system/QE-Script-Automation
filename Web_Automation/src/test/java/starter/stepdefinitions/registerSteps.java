package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.dashboardPage;
import starter.pages.registerPage;

public class registerSteps {

    registerPage registpage;
    dashboardPage dashpage;

    @Given("I am on Evizy register page")
    public void iAmOnEvizyRegisterPage() {
        registpage.openRegistUrl();
    }

    @When("I input nama {string} for register")
    public void iInputForRegister(String arg0) {
        registpage.inputNama(arg0);
    }
    @And("I input NIK {string} for register")
    public void inputNikForRegist(String nik){
        registpage.inputNikforRegist(nik);

    }
    @And("I input Nomor Telepon {string} for register")
    public void inputNoTelpForRegist(String nomor){
        registpage.inputNoTelp(nomor);

    }
    @And("I input Password {string} for register")
    public void inputPasswordForRegist(String pass){
        registpage.inputPassword(pass);
    }

    @Then("i get the register {string}")
    public void iGetTheRegister(String result) throws Exception {
        if (result.equals("dashboard_page")){
            registpage.clickRegistButton();
            Thread.sleep(800);
            dashpage.menuOnDashboardDisplayed();
        } else if(result.equals("NIK Sudah Terdaftar")){
            registpage.clickRegistButton();
            Thread.sleep(800);
            registpage.nikSudahTerdaftarDisplayed();
        } else if(result.equals("NIK Tidak Valid")){
            Thread.sleep(800);
            registpage.clickRegistButton();
            registpage.nikTidakValidDisplayed();
        } else{
            registpage.verifyOnRegistPage();
            Thread.sleep(800);
            registpage.verirfyCannotClickRegistButton();
        }
    }
}
