package starter.admin;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class login_superAdmin {
    private static String base_url = "http://50.19.175.143";


    @Step(" set endpoint for login using superadmin")
    public String setEndpointForSuperAdminLogin(){
        return base_url + "/api/v1/admin/login";
    }
    @Step("set superadmin details")
    public void setSuperAdminDetails(){
        JSONObject reqdata = new JSONObject();

        reqdata.put("username","admin");
        reqdata.put("password","123456");

        SerenityRest.given().header("Content-Type", "application/json").body(reqdata.toJSONString());
        SerenityRest.when().post(setEndpointForSuperAdminLogin());
    }

    @Step("validate status code")
    public void vallidateStatusCodeAfterSendPostReq(int code){
        SerenityRest.then().statusCode(code);
    }
    @Step("get super admin's access token")
    public void getSuperAdminAccessToken(){
        Response response = SerenityRest.lastResponse();
        String accestokenSuperAdmin = response.body().path("data.accessToken");

        try (FileWriter file = new FileWriter("src/test/resources/filejson/SuperAdminToken.json")) {
            file.write(accestokenSuperAdmin);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
