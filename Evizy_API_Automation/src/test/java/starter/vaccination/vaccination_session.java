package starter.vaccination;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
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

public class vaccination_session {

    String tokenSuperAdmin;

    private static String base_url = "http://50.19.175.143";

    public String setCreateVaccinationSessionEndpoint(){
        return base_url + "/api/v1/vaccination-session";
    }
    
    public JSONObject setCreateVaccinationDetail(){
        //health fac id = 3
        // vaccine id = 12

        Map<Object, Object> map = new HashMap<>();
        Map<Object, Object> map2 = new HashMap<>();
        JSONObject data = new JSONObject();

        map.put("id",3);
        map2.put("id",12);

        data.put("health_facility",map);
        data.put("vaccine",map2);
        data.put("quantity",1);
        data.put("schedule_date","2022-08-16");
        data.put("schedule_time_start","08:00");
        data.put("schedule_time_end","10:00");

        return data;


    }
    public void sendCreateVaccinationSessionReq() throws Exception{
        this.tokenSuperAdmin = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.tokenSuperAdmin)
                .body(setCreateVaccinationDetail());
        when().post(setCreateVaccinationSessionEndpoint());

    }

    public void validateStatusCodeAndSessionDetail(int code){
        then().statusCode(equalTo(code));


        if(code==201) {
            then().body("data.schedule_date",equalTo("2022-08-16"));

            Response response = SerenityRest.lastResponse();

            int vacSessionId = response.body().path("data.id");
            String vaccineSes_id = String.valueOf(vacSessionId);

            try (FileWriter file = new FileWriter("src/test/resources/filejson/vaccSession.json")) {

                file.write(vaccineSes_id);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String setEndpointForFindVacSesByCity(){
        return base_url + "/api/v1/vaccination-session?city_id=2";
    }

    public void sendFindVacSesByCityReq() throws Exception{
        this.tokenSuperAdmin = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.tokenSuperAdmin)
                .when().get(setEndpointForFindVacSesByCity());

    }

    public void validateStatusCodeForVacSession(int code,String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));
    }
    public String setGetSpecificVacSessionEndpoint(){
        return base_url + "/api/v1/vaccination-session/12";
    }
    public void sendGetSpecVacSessionReq() throws Exception{
        this.tokenSuperAdmin = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.tokenSuperAdmin)
                .when().get(setGetSpecificVacSessionEndpoint());
    }

    public String setDeleteVaccinationSesEndpoint(){
        return base_url + "/api/v1/vaccination-session/{id}";
    }

    public void sendDeleteVaccinationSessionreq() throws Exception{

        String vacSessionId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/vaccSession.json")
                , StandardCharsets.UTF_8);
        this.tokenSuperAdmin = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .pathParam("id",vacSessionId)
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.tokenSuperAdmin)
                .when().delete(setDeleteVaccinationSesEndpoint());

    }

    public JSONObject setUpdateVaccinationSessionDetail(){
        Map<Object, Object> map2 = new HashMap<>();
        JSONObject data = new JSONObject();


        map2.put("id",12);
        data.put("vaccine",map2);
        data.put("quantity",3);
        data.put("schedule_date","2022-08-01");
        data.put("schedule_time_start","09:00");
        data.put("schedule_time_end","11:00");

        return data;
    }

    public void sendUpdateVaccinationSessionReq() throws Exception{
        this.tokenSuperAdmin = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.tokenSuperAdmin)
                .body(setUpdateVaccinationSessionDetail());
        when().post(setGetSpecificVacSessionEndpoint());

    }




}
