package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.city_news.news;

public class newsSteps {

    @Steps
    news news;
    @Given("I set an endpoint for create news")
    public void iSetAnEndpointForCreateNews() {
        news.setPostNewsEndpoint();
    }

    @When("I set news detail {string}, {string} and content {string} and send post request")
    public void iSetNewsDetailAndContentAndSendPostRequest(String arg0, String arg1, String arg2)throws Exception {
        news.setNewsDetail(arg0, arg1, arg2);
    }

    @Then("I validate news status code is {int} and message {string}")
    public void iValidateNewsStatusCodeIsStatus_codeAndMessage(int code, String arg0) {
        news.validateAfterCreateNewsdetail(code,arg0);
    }

    @When("I set news detail and send request")
    public void iSetNewsDetailAndSendRequest() throws Exception {
        news.setNewsDetailUsingRegAdmin();
    }

    @Then("I validate news status code is {int} and the message is {string}")
    public void iValidateNewsStatusCodeIsAndTheMessageIs(int arg0, String arg1) {
        news.validateStatusCodeAndDetailAfterSendPostReq(arg0, arg1);
    }

    @Given("I set get all news endpoint")
    public void iSetGetAllNewsEndpoint() {
        news.setPostNewsEndpoint();
    }

    @When("I send get all news request")
    public void iSendGetAllNewsRequest() throws Exception {
        news.sendGetAllNewsReq();
    }

    @Then("I validate the status code is {int} and message is {string} for news")
    public void iValidateTheStatusCodeIsAndMessageIsForNews(int arg0, String arg1) {
        news.validateStatusCodeAndDetailForNews(arg0, arg1);
    }

    @Given("I set find specific news endpoint")
    public void iSetFindSpecificNewsEndpoint() {
        news.setEndpointForFindSpecNews();
    }

    @When("I send get request to find specific news")
    public void iSendGetRequestToFindSpecificNews() throws Exception {
        news.sendFindSpecNewsReq();
    }

    @Given("I set endpoint to delete specific news")
    public void iSetEndpointToDeleteSpecificNews() {
        news.deleteSpecNewsEndpoint();
    }

    @When("I send delete specific news request")
    public void iSendDeleteSpecificNewsRequest() throws Exception {
        news.sendDeleteSpecNewsReq();
    }

    @Given("I set update news endpoint")
    public void iSetUpdateNewsEndpoint() {
        news.setEndpointForFindSpecNews();
    }

    @When("I set update news detail and send put request")
    public void iSetUpdateNewsDetailAndSendPutRequest() throws Exception  {
        news.setUpdateNewsDetail();
    }
}
