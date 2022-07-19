package starter.vaccination;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class vaccination_pass_update {

    String userToken;

    private static String base_url = "http://50.19.175.143";

    @Step
    public String setVaccinationPassEndpoint(){
        return base_url + "/api/v1/vaccination-pass";
    }
    public JSONObject setVaccinationPassDetail(){
        Map<Object, Object> map = new HashMap<>();
        JSONObject reqdata = new JSONObject();
        //id healthfac = 3
        //id city = 3
        //id admin = 2
        //id vac session = 16

        map.put("id",16);


        reqdata.put("age_category","dewasa");
        reqdata.put("is_pregnant",false);
        reqdata.put("id_address","Jl.Bung Karno");
        reqdata.put("id_sub_district","Kec Palung");
        reqdata.put("id_urban_village","Kel Merdeka");
        reqdata.put("id_city","Surabaya");

        reqdata.put("id_province","Jawa Timur");
        reqdata.put("curr_address","Jl.Bung Karno");
        reqdata.put("curr_urban_village","Kel Merdeka");
        reqdata.put("curr_sub_district","Kec Palung");
        reqdata.put("curr_city","Surabaya");
        reqdata.put("curr_province","Jawa Timur");



        reqdata.put("vaccination_session",map);





        return reqdata;
    }
    public void sendCreateVaccinationPassEndpoint() throws Exception{
        this.userToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/token.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.userToken)
                .body(setVaccinationPassDetail());
        when().post(setVaccinationPassEndpoint());
    }

    public void validateAfterCreateVaccinationPass(){
        then().statusCode(equalTo(201));
        then().body("message",equalTo("SUCCESS"));

            Response response = SerenityRest.lastResponse();

            int vaccPass = response.body().path("data.id");
            String vaccinePass_id = String.valueOf(vaccPass);

            try (FileWriter file = new FileWriter("src/test/resources/filejson/vaccPassId.json")) {

                file.write(vaccinePass_id);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }

    public void sendGetAllVaccinationPassReq() throws Exception{
        String superAdminToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);
        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + superAdminToken)
                .when().get(setVaccinationPassEndpoint());

    }

    public void validateStatusCodeAndMesssageForVaccPass(int code){
        then().statusCode(equalTo(code));
        then().body("message",equalTo("SUCCESS"));
    }
    public String setGetSpecificVaccPassEndpoint(){
        return base_url + "/api/v1/vaccination-pass/9";
    }

    public void sendGetSpecificVaccPassReq() throws Exception{
        String superAdminToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);
        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + superAdminToken)
                .when().get(setGetSpecificVaccPassEndpoint());
    }
    public String setDeleteVaccinationPassEndpoint(){
        return base_url + "/api/v1/vaccination-pass/{id}";

    }
    public void sendDeleteVaccinePassReq() throws Exception{
        String vaccinepass_id = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/vaccPassId.json")
                , StandardCharsets.UTF_8);

        String userToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/token.json"), StandardCharsets.UTF_8);

        given()
                .pathParam("id",vaccinepass_id)
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + userToken)
                .when().delete(setDeleteVaccinationPassEndpoint());
    }

    public String setUpdateVaccPassEndpoint(){
        return base_url + "/api/v1/vaccination-pass/17";
    }
    public JSONObject setVaccinationUpdatePassDetail() {
        Map<Object, Object> map = new HashMap<>();
        JSONObject reqdata = new JSONObject();
        //id healthfac = 3
        //id city = 3
        //id admin = 2
        //id vac session = 16

        map.put("id",16);


        reqdata.put("age_category", "dewasa");
        reqdata.put("is_pregnant", false);
        reqdata.put("id_address", "Jl.Bung Karno");
        reqdata.put("id_sub_district", "Kec Palung");
        reqdata.put("id_urban_village", "Kel Merdeka");
        reqdata.put("id_city", "Surabaya");
        reqdata.put("id_province", "Jawa Timur");
        reqdata.put("curr_address", "Jl.Bung Karno");
        reqdata.put("curr_urban_village", "Kel Merdeka");
        reqdata.put("curr_sub_district", "Kec Palung");
        reqdata.put("curr_city", "Bogor");
        reqdata.put("curr_province", "Jawa Barat");


        reqdata.put("vaccination_session", map);

        return reqdata;
    }
    public void sendUpdateVaccinationPassEndpoint() throws Exception{
        this.userToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/token.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.userToken)
                .body(setVaccinationUpdatePassDetail());
        when().put(setUpdateVaccPassEndpoint());
    }

    public String setUpdateVaccStatusEndpoint(){
        return base_url + "/api/v1/vaccination-pass/17/vaccinated-status";
    }

    public void sendVaccStatusTrue() throws Exception{
        JSONObject reqdata = new JSONObject();

        reqdata.put("is_vaccinated",true);

        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .body(reqdata).when().put(setUpdateVaccStatusEndpoint());
    }
    public void sendVaccStatusFalse() throws Exception {
        JSONObject reqdata = new JSONObject();

        reqdata.put("is_vaccinated",false);

        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + superAdminAccessToken)
                .body(reqdata).when().put(setUpdateVaccStatusEndpoint());
    }

}
