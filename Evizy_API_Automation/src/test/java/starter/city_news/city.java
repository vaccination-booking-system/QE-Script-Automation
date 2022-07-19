package starter.city_news;

import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import starter.utils.randomString;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class city {

    private static String base_url = "http://50.19.175.143";

    randomString rand_string = new randomString();
    String cityname;

    @Step
    public String setCreateCityEndpoint(){
        return base_url + "/api/v1/cities";
    }

    @Step
    public void setCreateCityDetail(String name) throws Exception{
        JSONObject requestdata = new JSONObject();

        if(name.equals("Denpasar")){
            this.cityname = rand_string.randomWords();
        } else if(name.equals("Jakarta")){
            this.cityname = "Jakarta";
        } else if(name.equals(" ")){
            this.cityname = "   ";
        } else if(name.equals("5680")){
            this.cityname = "5680";
        }

        requestdata.put("name",this.cityname);



        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .body(requestdata).when().post(setCreateCityEndpoint());
    }
    @Step
    public void validateStatusCodeandCityDetail(int code,String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));
    }

    public String setGetAllCityEndpoint(){
        return base_url + "/api/v1/cities";
    }
    public void sendGetAllCityRequest() throws  Exception{
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().get(setGetAllCityEndpoint());

    }
    public void validateCityStatusCodeAndMessage(int code, String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));
    }

    public String setEndpointForGetSpecificCity(){
        return base_url + "/api/v1/cities/14";
    }
    public void sendGetSpecificCityRequest() throws Exception{
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().get(setEndpointForGetSpecificCity());


    }
    public void validateStatusCodeForSpecificCityDetail(int code){
        then().statusCode(equalTo(code));
        then().body("message",equalTo("SUCCESS"));
        then().body("data.name",equalTo("Manado"));
    }

    public String setEndpointForDeleteSpecificCity(){
        return base_url + "/api/v1/admin/7";
    }
    public void sendDeleteSpecificRequest() throws Exception{
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().delete(setEndpointForDeleteSpecificCity());

    }

    public String setUpdateCityEndpoint(){
        return base_url + "/api/v1/cities/12";
    }
    public void sendUpdateRequestDetail() throws Exception{
        JSONObject reqdata = new JSONObject();

        reqdata.put("name","Kuta");

        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .body(reqdata).when().put(setUpdateCityEndpoint());

    }
    public void validateUpdateStatusCodeAndDetail(int code){
        then().statusCode(equalTo(code));
        then().body("data.name",equalTo("Kuta"));
    }

}
