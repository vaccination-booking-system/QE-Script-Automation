package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.citizen.family_Member;

public class familyMemberSteps {

    @Steps
    family_Member fam_member;

    @Given("I set an endpoint for add family member")
    public void setEndpointForAddFamilyMember(){
        fam_member.setAddFamilyMemberEndpoint();

    }

    @When("I set {string}, {string}, {string}, {string}, {string} and send post request")
    public void iSetAndSendPostRequest(String arg0, String arg1, String arg2, String arg3, String arg4) throws Exception {
        fam_member.setFamilyMemberDetail(arg0, arg1, arg2, arg3, arg4);
    }

    @Then("I validate the {int} and details")
    public void iValidateTheStatus_codeAndDetails(int code) {
        fam_member.validateStatusCodeAfterAddFamilyMember(code);
    }

    @Given("I set an endpoint for get specific user's family members")
    public void iSetAnEndpointForGetSpecificUserSFamilyMembers() {
        fam_member.getFamilyMemOfSpecificUser();
    }

    @When("I send get specific user's family members request")
    public void iSendGetSpecificUserSFamilyMembersRequest() throws Exception {
        fam_member.sendGetFamMemOfSpecUserRequest();
    }

    @Then("I validate the status code is {int} and validate the message after request")
    public void iValidateTheStatusCodeIsAndValidateTheMessageAfterRequest(int arg0) {
        fam_member.validateStatusCodeforFamMem(arg0);
    }

    @Given("I set an endpoint for get specific family member")
    public void iSetAnEndpointForGetSpecificFamilyMember() {
        fam_member.setGetSpecMember();
    }

    @When("I send get specific family member request")
    public void iSendGetSpecificFamilyMemberRequest() throws Exception {
        fam_member.sendGetSpecMemberRequest();
    }

    @Given("I set an endpoint for delete family member")
    public void iSetAnEndpointForDeleteFamilyMember() {
        fam_member.setDeleteFamMemberEndpoint();
    }

    @When("I send delete family member request")
    public void iSendDeleteFamilyMemberRequest() throws Exception {
        fam_member.sendDeleteFamMemberRequest();
    }

    @Given("I set an endpoint for update family data")
    public void iSetAnEndpointForUpdateFamilyData() {
        fam_member.setUpdateFamMemberEndpoint();
    }

    @When("I set update family data details")
    public void iSetUpdateFamilyDataDetails() throws Exception {
        fam_member.sendUpdateFamilyMemberDetail();

    }
}
