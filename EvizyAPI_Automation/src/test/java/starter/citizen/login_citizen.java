package starter.citizen;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class login_citizen {

    private static String base_url = "http://50.19.175.143/api/v1";

    @Step("set endpoint for login")
    public String setLoginEndpoint(){
        return base_url + "/auth/login";
    }
    @Step("set login NIK and Password")
    public void setNIKForLogin(String NIK, String Password){
        JSONObject reqdata = new JSONObject();

        reqdata.put("nik",NIK);
        reqdata.put("password",Password);

        SerenityRest.given().header("Content-Type", "application/json").body(reqdata.toJSONString());
        SerenityRest.when().post(setLoginEndpoint());
    }

    @Step("validate status code")
    public void validataLoginStatusCode(int code){
        SerenityRest.then().statusCode(code);
        if (code == 200){
            SerenityRest.then().body("message",equalTo("SUCCESS"));
            Response response = SerenityRest.lastResponse();
            String token = response.body().path("data.accessToken");
            System.out.println(token);
            try(FileWriter file = new FileWriter("src/test/resources/filejson/token.json")){
                file.write(token);
                file.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            SerenityRest.then().body("message",containsString("INVALID_CREDENTIALS"));
        }
    }
}
