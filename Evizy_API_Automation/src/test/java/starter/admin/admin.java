package starter.admin;

import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.*;

public class admin {

    private static String base_url = "http://50.19.175.143";

   @Step
    public String getAllAdmin() {
        return base_url + "/api/v1/admin";
    }

    @Step
    public void sendGetAllAdminRequest()throws Exception{

        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().get(getAllAdmin());

    }

    @Step
    public void validateStatusCodeAndMessageForAdmin(int code, String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));
    }

    @Step
    public String setGetSpecificAdminEndpoint(){
       return base_url + "/api/v1/admin/{id}";
    }

    @Step
    public void sendGetSpecificAdminRequest(int id) throws Exception{
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .pathParam("id",id)
                .when().get(setGetSpecificAdminEndpoint());
    }
    @Step
    public String setEndpointForDeleteAdmin(){
       return base_url + "/api/v1/admin/7";
    }

    public void sendDeleteAdminRequest() throws Exception{
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().delete(setEndpointForDeleteAdmin());

    }
    public String setEndpointForUpdateAdmin(){
       return base_url + "/api/v1/admin/6";
    }

    public void  setUpdateDataDetails(String username,String name,String pass) throws Exception{
       JSONObject map = new JSONObject();

//        Map<String, String> map = new HashMap<String, String>();



        map.put("username",username);
        map.put("name",name);
        map.put("password",pass);


        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .body(map)
                .when().put(setEndpointForUpdateAdmin());

    }
    public void validatestatusCodeAndDetailAfteUpdate(int code){
       then().statusCode(equalTo(code));
       then().body("message",equalTo("SUCCESS"));
    }



}
