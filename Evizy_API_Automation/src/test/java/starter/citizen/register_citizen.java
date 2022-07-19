package starter.citizen;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

public class register_citizen {

    private static String base_url = "http://50.19.175.143/api/v1";

    @Step("set register endpoint")
    public String registerEndpoint(){
        return base_url + "/auth/register";
    }

    @Step("Set NIK and Password")
    public void SetNamaNIKandPasswordForRegist(String name,String NIK, String Password){
        JSONObject reqdata = new JSONObject();

        reqdata.put("name",name);
        reqdata.put("nik", NIK);
        reqdata.put("password",Password);

        SerenityRest.given().header("Content-Type", "application/json").body(reqdata.toJSONString());
        SerenityRest.when().post(registerEndpoint());
    }
    @Step("validate message and status code")
    public void validateMessageAndStatusCode(String message){
        SerenityRest.then().body("message",equalTo(message));
        if(message.equals("SUCCESS")){
            SerenityRest.then().statusCode(equalTo(200));
            Response response = SerenityRest.lastResponse();
            String token =response.body().path("data.accessToken");
            try(FileWriter file = new FileWriter("src/test/resources/filejson/token.json")){
                file.write(token);
                file.flush();
            } catch(IOException e){
                e.printStackTrace();
            }
        } else if(message.equals("ALREADY_EXIST")){
            SerenityRest.then().statusCode(equalTo(400));
        } else if(message.equals("INVALID_NIK")){
            SerenityRest.then().statusCode(equalTo(400));
        } else {
            SerenityRest.then().statusCode(equalTo(400));
        }
    }
}
