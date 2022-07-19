package starter.health_facility;

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

public class postHealthFacility {

    private static String base_url = "http://50.19.175.143";

    String tokenSuperAdmin;

    randomString rand_string = new randomString();
    String newHealthName;



    @Step
    public String setPostHealthFacEndpoint(){
        return base_url + "/api/v1/health-facilities";
    }

    public JSONObject setPostHealthFacilityDetail(){
        Map<Object, Object> map = new HashMap<>();
        Map<Object, Object> map2 = new HashMap<>();
        JSONObject data = new JSONObject();

         this.newHealthName = rand_string.randomWords();

        data.put("name",this.newHealthName);
        map.put("id",1);
        map2.put("id",5);


        data.put("city",map);
        data.put("admin",map2);

        return data;
    }
    @Step
    public void sendPostReqToCreateHealthFac() throws Exception{

        this.tokenSuperAdmin = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization", "Bearer " + this.tokenSuperAdmin)
                .body(setPostHealthFacilityDetail());
        when().post(setPostHealthFacEndpoint());






    }



    public void validateStatusCodeAndDetailAfterPostHealthFac(int code, String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));


        Response response = SerenityRest.lastResponse();

        int healthfacid = response.body().path("data.id");
        String healthfac_id = String.valueOf(healthfacid);

        try(FileWriter file = new FileWriter("src/test/resources/filejson/healthfac_id.json")) {

            file.write(healthfac_id);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }



    }

  public String setGetSpecificHealthFacEndpoint(){
        return base_url + "/api/v1/health-facilities/8";
  }
  public void sendGetSpecHealthFacReq() throws Exception{
      String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
              + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);


      given()
              .header("Content-Type","application/json")
              .header("Authorization","Bearer " + superAdminAccessToken)
              .when().get(setGetSpecificHealthFacEndpoint());
  }

  public void validateAfterSendRequestForHealthFacility(int code,String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));
  }

  public void validateDetailForSpecHealthFac(){
        then().statusCode(equalTo(200));
        then().body("data.name",equalTo("RS Mitra Keluarga"));
  }

  public String setGetAllHealthFacEndpoint(){
        return base_url + "/api/v1/health-facilities";
  }
  public void sendGetAllHealthFacReq() throws Exception {
      String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
              + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);


      given()
              .header("Content-Type","application/json")
              .header("Authorization","Bearer " + superAdminAccessToken)
              .when().get(setGetAllHealthFacEndpoint());
  }

  public String setDeleteHealthFacEndpoint(){
        return base_url + "/api/v1/health-facilities/{id}";
  }

  public void sendDeleteHealthFacReq() throws Exception{

      String healthfac_id = FileUtils.readFileToString(new File(System.getProperty("user.dir")
              + "/src/test/resources/filejson/healthfac_id.json"), StandardCharsets.UTF_8);

      String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
              + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);


      given()
              .pathParam("id",healthfac_id)
              .header("Content-Type","application/json")
              .header("Authorization","Bearer " + superAdminAccessToken)
              .when().delete(setDeleteHealthFacEndpoint());

  }
}
