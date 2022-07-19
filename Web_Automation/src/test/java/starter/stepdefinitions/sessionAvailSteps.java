package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.pages.admin.login_admin;
import starter.pages.admin.sessionAvailability;
import starter.pages.dashboardPage;

public class sessionAvailSteps {

    login_admin logadmin;

    sessionAvailability ses_avail;

    dashboardPage dashpage;
    @Given("I am on Evizy login admin page for vaccination session")
    public void iAmOnEvizyLoginAdminPageForVaccinationSession() {
        logadmin.openAdminUrlPage();
    }

    @When("I enter my username and password for vaccination session and click login button")
    public void iEnterMyUsernameAndPasswordForVaccinationSessionAndClickLoginButton() {
        ses_avail.inputAdminUsername();
        ses_avail.inputAdminPassword();
        ses_avail.clickAdminLoginButton();
    }

    @And("I directed to dashboard and i click session availability button")
    public void iDirectedToDashboardAndIClickSessionAvailabilityButton() throws Exception {
        Thread.sleep(600);
        dashpage.menuOnDashboardDisplayed();
        ses_avail.clickSessionAvailSection();


    }

    @And("I click my health facility")
    public void iClickMyHealthFacility() throws Exception {
        Thread.sleep(800);
        ses_avail.selectHealthFac();
    }

    @And("I click add session buttom")
    public void iClickAddSessionButtom() throws Exception {
        Thread.sleep(600);
        ses_avail.clickAddSessionButton();
    }

    @And("I input date {string} for vaccination")
    public void iInputDateForVaccination(String arg0) throws Exception {
        Thread.sleep(800);
        ses_avail.setSessionDate(arg0);
    }

    @And("I select type of vaccine {string}")
    public void iSelectTypeOfVaccine(String arg0) throws Exception {
        if(arg0.equals("Pfizer")){
            Thread.sleep(500);
            ses_avail.setVaccineTypeField();
            Thread.sleep(600);
            ses_avail.pickPfizer();
        } else if(arg0.equals("Nusantara")){
            Thread.sleep(800);
            ses_avail.setVaccineTypeField();
            Thread.sleep(500);
            ses_avail.pickNusantara();
        } else {
            Thread.sleep(800);
            ses_avail.stilOnAddSessionPage();
        }
    }

    @And("I set the start time {string}")
    public void iSetTheStartTime(String arg0) {
        ses_avail.setStartTime(arg0);

    }

    @And("I set the finish time {string}")
    public void iSetTheFinishTime(String arg0) {
        ses_avail.setFinishTime(arg0);
    }

    @And("I set the vaccine quota {string}")
    public void iSetTheVaccineQuota(String arg0) {
        ses_avail.setVaccineQuota(arg0);
    }
    @And("I click add session button")
    public void iClickAddSessionButton() {
        ses_avail.clickFinallAddSesionButton();
    }

    @And("I get the result for make vaccination session {string}")
    public void iGetTheResultForMakeVaccinationSession(String arg0) throws Exception {
        if ((arg0.equals("success"))){
            Thread.sleep(2000);
            ses_avail.verifyCantDeleteVaccSession();
        } else if(arg0.equals("failed")){
            ses_avail.stilOnAddSessionPage();
        }
    }

    @And("I click edit vaccination session button")
    public void iClickEditVaccinationSessionButton() throws Exception {
        Thread.sleep(800);
        ses_avail.clickEditButton();
    }

    @And("I edit the vaccination detail {string}")
    public void iEditTheVaccinationDetail(String arg0) throws Exception {
        if(arg0.equals("05052016")){
            ses_avail.editDetail1();

        } else if (arg0.equals("3")){
            Thread.sleep(600);
            ses_avail.clearvaccineQuota();
            ses_avail.editVaccineQuota();
        }
    }

    @And("I click edit button")
    public void iClickEditButton() throws Exception {
        Thread.sleep(800);
        ses_avail.clickEditButton();
    }

    @And("I get the update vaccination session result {string}")
    public void iGetTheUpdateVaccinationSessionResult(String arg0) throws Exception {
        if(arg0.equals("failed")){
            Thread.sleep(1000);
            ses_avail.stillOnEditVacPage();
        } else if(arg0.equals("success")){
            Thread.sleep(1000);
            ses_avail.verifySuccessEditSession();
        }
    }

    @And("I click delete button on vaccination session")
    public void iClickDeleteButtonOnVaccinationSessionThatAlreadyBooked() {
        ses_avail.clickDeleteVaccSessionButton();
    }

    @Then("I success delete the vaccination session")
    public void iValidateThatICanNotDeleteThatSession() {
        ses_avail.verifyCantDeleteVaccSession();
    }
}
