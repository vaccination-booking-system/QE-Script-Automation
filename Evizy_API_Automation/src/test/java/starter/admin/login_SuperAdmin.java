package starter.admin;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

public class login_SuperAdmin {

    private static String base_url = "http://50.19.175.143";

    @Step
    public String setEndpointForSuperAdmin(){
        return base_url + "/api/v1/admin/login";
    }

    @Step
    public void setSuperAdminDetails(){
        JSONObject requestdata = new JSONObject();

        requestdata.put("username","admin");
        requestdata.put("password","123456");

        SerenityRest.given().header("Content-Type","application/json").body(requestdata.toJSONString());
        SerenityRest.when().post(setEndpointForSuperAdmin());

    }

    @Step
    public void validateStatusCodeForSuperAdmin(int code){
        SerenityRest.then().statusCode(equalTo(code));
    }

    @Step
    public void getAccessToken(){
        Response response =SerenityRest.lastResponse();

        String accessTokenSuperAdmin = response.body().path("data.accessToken");

        try(FileWriter file = new FileWriter("src/test/resources/filejson/superAdminToken.json")) {
            file.write(accessTokenSuperAdmin);
            System.out.println(accessTokenSuperAdmin);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
