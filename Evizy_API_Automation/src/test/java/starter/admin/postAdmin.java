package starter.admin;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class postAdmin {

    private static String base_url = "http://50.19.175.143";

    @Step
    public String setpostAdminEndpoint(){
        return base_url + "/api/v1/admin";
    }

    @Step
    public void setAdminPostDetails(String username,String name,String password)throws Exception{
        JSONObject requestdata = new JSONObject();

        requestdata.put("username",username);
        requestdata.put("name",name);
        requestdata.put("password",password);

        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .body(requestdata).when().post(setpostAdminEndpoint());
    }
    @Step
    public void validateStatusCodeAfterPostAdminRequest(int code,String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));

    }

    @Step
    public String setLoginAdminEndpoint(){
        return base_url + "/api/v1/admin/login";
    }

    @Step
    public void sendLoginAdminRequest(){
        JSONObject requestdata = new JSONObject();

        requestdata.put("username","kebonJeruk");
        requestdata.put("password","KebonJeruk01");

        SerenityRest.given().header("Content-Type","application/json").body(requestdata.toJSONString());
        SerenityRest.when().post(setLoginAdminEndpoint());

    }

    @Step
    public void validateStatusCodeAndGetAccessToken(int code){
        then().statusCode(equalTo(code));

        Response response =SerenityRest.lastResponse();

        String adminAccessToken = response.body().path("data.accessToken");

        try(FileWriter file = new FileWriter("src/test/resources/filejson/adminAccessToken.json")) {
            file.write(adminAccessToken);
            System.out.println(adminAccessToken);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }




}
