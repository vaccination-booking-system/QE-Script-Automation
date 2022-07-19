package starter.admin;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class user {


    private static String base_url = "http://50.19.175.143";

    @Step
    public String setEndpointForGetAllUsers(){
        return base_url + "/api/v1/users";
    }

    public void sendGetAllUsersRequest() throws Exception{
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);


        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().get(setEndpointForGetAllUsers());
    }

    public void validateStatusCodeAfterSendGetAllUsers(int code, String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));

    }

    public String setGetSpecificUserEndpoint(){
        return base_url + "/api/v1/users/89";
    }

    public void sendGetSpecificUserReq() throws Exception{
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);


        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().get(setGetSpecificUserEndpoint());
    }
    public void validateStatusCodeAndDetailForSpecUser(int code){
        then().statusCode(equalTo(code));
        then().body("data.nik",equalTo("9242567429635550"));
    }
}
