package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.city_news.city;

public class citySteps {

    @Steps
    city City;
    @Given("I set endpoint for create city")
    public void iSetEndpointForCreateCity() {
        City.setCreateCityEndpoint();
    }

    @When("I set name {string} and send post request for create new city")
    public void iSetNameAndSendPostRequestForCreateNewCity(String arg0) throws Exception {
        City.setCreateCityDetail(arg0);
    }

    @Then("I validate the {int} and validate city detail {string}")
    public void iValidateTheStatus_codeAndValidateCityDetail(int code,String arg0) {
        City.validateStatusCodeandCityDetail(code, arg0);
    }

    @Given("I set endpoint for get all city")
    public void iSetEndpointForGetAllCity() {
        City.setGetAllCityEndpoint();
    }

    @When("I send get request for get all city")
    public void iSendGetRequestForGetAllCity() throws Exception {
        City.sendGetAllCityRequest();
    }

    @Then("I validate status code for city is {int} and message is {string}")
    public void iValidateStatusCodeForCityIsAndMessageIs(int arg0, String arg1) {
        City.validateStatusCodeandCityDetail(arg0, arg1);
    }

    @Given("I set endpoint for get specific city using id")
    public void iSetEndpointForGetSpecificCityUsingId() {
        City.setEndpointForGetSpecificCity();
    }

    @When("I send get specific city request")
    public void iSendGetSpecificCityRequest() throws Exception {
        City.sendGetSpecificCityRequest();
    }

    @Then("I validate the status code is {int} and i validate the city's detail")
    public void iValidateTheStatusCodeIsAndIValidateTheCitySDetail(int arg0) {
        City.validateStatusCodeForSpecificCityDetail(arg0);
    }

    @Given("I set endpoint for delete specific city")
    public void iSetEndpointForDeleteSpecificCity() {
        City.setEndpointForDeleteSpecificCity();
    }

    @When("I send delete specific city request")
    public void iSendDeleteSpecificCityRequest() throws Exception {
        City.sendDeleteSpecificRequest();
    }

    @Then("I validate status code is {int} and message is {string}")
    public void iValidateStatusCodeIsAndMessageIs(int arg0, String arg1) {
        City.validateCityStatusCodeAndMessage(arg0, arg1);
    }

    @Given("I set endpoint for update specific city")
    public void iSetEndpointForUpdateSpecificCity() {
        City.setUpdateCityEndpoint();
    }

    @When("I set update specific city request")
    public void iSetUpdateSpecificCityRequest() throws Exception {
        City.sendUpdateRequestDetail();

    }

    @Then("I validate the status code is {int} validate update detail")
    public void iValidateTheStatusCodeIsValidateUpdateDetail(int arg0) {
        City.validateUpdateStatusCodeAndDetail(arg0);
    }
}
