package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.addFamMember;
import starter.pages.dashboardPage;
import starter.pages.loginPage;

public class addFamilyMemSteps {

    @Steps
    addFamMember addfam;

    @Steps
    loginPage loginPage;

    @Steps
    dashboardPage dashboardpage;

    @Given("I am on login page to do login")
    public void iAmOnLoginPageToDoLogin() {
        loginPage.openUrl();
    }

    @When("I enter my username and password and click login button")
    public void iEnterMyNikAndPassword() throws Exception {
        addfam.inputNikForAddFamMember();
        addfam.inputPassForAddFamMember();
        Thread.sleep(800);
        loginPage.clickLoginButton();
    }

    @And("I directed to dashboard")
    public void iDirectedToDashboard() {
        dashboardpage.menuOnDashboardDisplayed();
    }

    @And("I click add family member section")
    public void iClickAddFamilyMemberSection() {
        addfam.clickAddFamilyMemberSection();
    }

    @And("I click add family member button")
    public void iClickAddFamilyMemberButton() {
        addfam.clickAddFamilyMemberButton();
        addfam.verifyOnAddFamilyMemberFormPage();
    }

    @And("I enter family member's fullname {string}")
    public void iEnterFamilyMemberSFullname(String arg0) throws Exception {
        addfam.inputFullname(arg0);
    }

    @And("I enter date of birth {string}")
    public void iEnterDateOfBirth(String arg0) throws Exception {
        addfam.inputDot(arg0);
    }
    @And("I enter family member's nik {string}")
    public void iEnterFamilyMemberSNik(String arg0) throws Exception {
        addfam.inputFamMemberNik(arg0);
    }

    @And("I enter family member's phone number {string}")
    public void iEnterFamilyMemberSPhoneNumber(String arg0) throws Exception {
        addfam.inputPhoneNumber(arg0);
    }

    @And("I select gender {string}")
    public void iSelectGender(String arg0) throws Exception {
        if (arg0.equals("Perempuan")){
            addfam.selectGender();
        }else if(arg0.equals("Laki-Laki")){
            addfam.clickMale();
        }else{
            addfam.verifyOnAddFamilyMemberFormPage();
        }
    }

    @And("I select status {string}")
    public void iSelectStatus(String arg0) throws Exception {
        if (arg0.equals("Saudara")){
            addfam.selectRelation();
        }else if(arg0.equals("Lain-Lain")){
            addfam.clickOtherRelation();
        }
        else {
            addfam.verifyOnAddFamilyMemberFormPage();
        }
    }

    @And("I click add family member button {string}")
    public void iClickAddFamilyMemberButton(String arg0) throws Exception {
        if (arg0.equals("clickable")) {
            addfam.scrollTo();
            addfam.clickFinalAddFamButton();
            addfam.verifySuccessAddFamMember();
        } else if (arg0.equals("error message for name")) {
            addfam.invalidNameDisplayed();
        } else if (arg0.equals("error meesage for nik")) {
            Thread.sleep(600);
            addfam.invalidNikDisplayed();
        } else if (arg0.equals("error message for phonenum")) {
            addfam.invalidPhoneNumberDispalyed();
        } else if (arg0.equals("data not valid")) {
            addfam.clickFinalAddFamButton();
            addfam.verifyStillOnFamAddMemPage();

        }
    }

}
