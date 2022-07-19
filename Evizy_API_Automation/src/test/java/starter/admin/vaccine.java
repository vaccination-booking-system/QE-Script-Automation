package starter.admin;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import starter.utils.randomString;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class vaccine {

    randomString rand_string = new randomString();

    String tokenSuperAdmin;

    String vaccname;

    private static String base_url = "http://50.19.175.143";

    @Step
    public String setCreateVaccineEndpoint(){
        return base_url + "/api/v1/vaccines";
    }

    public void sendCreateVaccineDetail(String name) throws Exception{
        JSONObject reqdata = new JSONObject();

        if(name.equals("newVac")) {
            this.vaccname = rand_string.randomWords();

            try (FileWriter file = new FileWriter("src//test//resources//filejson//vaccine_name.json")) {
                file.write(this.vaccname);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if(name.equals("null")){
            this.vaccname = " ";
        } else if(name.equals("Sinovac")){
            this.vaccname = "Sinovac";
        }

        reqdata.put("name",this.vaccname);

        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .body(reqdata).when().post(setCreateVaccineEndpoint());
    }
    public void validateStatusCodeAndDetailAfterCreateVaccine(int code,String message){

        if (message.equals("SUCCESS")){
            SerenityRest.then().statusCode(equalTo(code));
            SerenityRest.then().body("message",equalTo("SUCCESS"));
            Response response = SerenityRest.lastResponse();

            int vaccineId = response.body().path("data.id");
            String vaccine_id = String.valueOf(vaccineId);

            try(FileWriter file = new FileWriter("src/test/resources/filejson/vaccineId.json")) {

                file.write(vaccine_id);
                file.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        } else if(message.equals("INVALID_INPUT")){
            SerenityRest.then().statusCode(equalTo(code));
            SerenityRest.then().body("message",equalTo("INVALID_INPUT"));
        } else if(message.equals("ALREADY_EXIST")){
            SerenityRest.then().statusCode(equalTo(code));
            SerenityRest.then().body("message",equalTo("ALREADY_EXIST"));
        }
    }

    public String setGetAllVaccineEndpoint(){
        return base_url + "/api/v1/vaccines";
    }
    public void sendGetAllVaccineRequest() throws Exception{

        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().get(setGetAllVaccineEndpoint());
    }
    public void validateAfterSendVaccineDetail(int code,String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));
    }

    public String setGetSpecificVaccineEndpoint(){
        return base_url + "/api/v1/vaccines/12";
    }
    public void sendGetSpecificVaccineReq() throws Exception{
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().get(setGetSpecificVaccineEndpoint());

    }

    public void validateAfterSendGetSpecificVaccineReq(int code){
        then().statusCode(equalTo(code));
        then().body("data.name",equalTo("CoronaVac"));
    }

    public String setDeleteVaccineEndpoint(){
        return base_url + "/api/v1/vaccines/{id}";
    }
    public void sendDeleteVaccineRequest() throws Exception{
        String vaccine_id = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/vaccineId.json")
                , StandardCharsets.UTF_8);
        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .pathParam("id",vaccine_id)
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .when().delete(setDeleteVaccineEndpoint());

    }
    public String setUpdateVaccineEndpoint(){
        return base_url + "/api/v1/vaccines/13";
    }

    public void sendUpdateVaccineReq() throws Exception{
        JSONObject reqdata = new JSONObject();

        reqdata.put("name","Nusantara");


        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .body(reqdata).when().put(setUpdateVaccineEndpoint());

    }
    public void validateAfterUpdateDetail(int code){
        then().statusCode(equalTo(code));
        then().body("data.name",equalTo("Nusantara"));
    }

    public String setVaccineStockEndpoint(){
        return base_url + "/api/v1/health-facilities/6/vaccines";
    }

    public JSONObject setDistributeVaccineStockDetail(){
        Map<Object, Object> data = new HashMap<>();
        JSONObject request = new JSONObject();

        request.put("quantity",3);

        data.put("id",2);

        request.put("vaccine",data);

        return request;

    }

    public void sendDistributeVaccineReq() throws Exception{
        this.tokenSuperAdmin = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.tokenSuperAdmin)
                .body(setDistributeVaccineStockDetail());
        when().post(setVaccineStockEndpoint());

    }

    public void sendGetHealthFacVaccineStock() throws Exception{
        this.tokenSuperAdmin = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.tokenSuperAdmin)
                .when().get(setVaccineStockEndpoint());
    }


}
