package starter.citizen;

import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class family_Member {

    private static String base_url = "http://50.19.175.143";

    @Step
    public String setAddFamilyMemberEndpoint(){
        return base_url + "/api/v1/family-members";
    }

    public void setFamilyMemberDetail(String nik,String name,String dot,String gender,String rs) throws Exception{
        JSONObject requestdata = new JSONObject();

        requestdata.put("nik",nik);
        requestdata.put("name",name);
        requestdata.put("date_of_birth",dot);
        requestdata.put("gender",gender);
        requestdata.put("relationship",rs);

        String token = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/token.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + token)
                .body(requestdata).when().post(setAddFamilyMemberEndpoint());
    }

    public void validateStatusCodeAfterAddFamilyMember(int code){
        then().statusCode(equalTo(code));

        if (code==200){
            then().body("message",equalTo("SUCCESS"));
        } else if (code==400){
            then().body("message",equalTo("INVALID_NIK"));
        }

    }

    public String getFamilyMemOfSpecificUser(){
        return base_url + "/api/v1/family-members?user_id=16";
    }
    public void sendGetFamMemOfSpecUserRequest() throws Exception{
        String token = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/token.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + token)
                .when().get(getFamilyMemOfSpecificUser());

    }

    public void validateStatusCodeforFamMem(int code){
        then().statusCode(equalTo(code));
        then().body("message",equalTo("SUCCESS"));
    }

   public String setGetSpecMember(){
        return base_url + "/api/v1/family-members/28";
   }
   public void sendGetSpecMemberRequest() throws Exception{
       String token = FileUtils.readFileToString(new File(System.getProperty("user.dir")
               + "/src/test/resources/filejson/token.json"), StandardCharsets.UTF_8);

       given()
               .header("Content-Type","application/json")
               .header("Authorization","Bearer " + token)
               .when().get(setGetSpecMember());
   }

  public String setDeleteFamMemberEndpoint(){
        return base_url + "/api/v1/family-members/14";
  }
  public void sendDeleteFamMemberRequest() throws Exception{
      String token = FileUtils.readFileToString(new File(System.getProperty("user.dir")
              + "/src/test/resources/filejson/token.json"), StandardCharsets.UTF_8);

      given()
              .header("Content-Type","application/json")
              .header("Authorization","Bearer " + token)
              .when().delete(setDeleteFamMemberEndpoint());
  }
  public String setUpdateFamMemberEndpoint(){
        return base_url + "/api/v1/family-members/13";
  }
  public void sendUpdateFamilyMemberDetail() throws Exception{
        JSONObject reqdata = new JSONObject();

        reqdata.put("nik","5719348816440007");
        reqdata.put("name","Diana");
        reqdata.put("date_of_birth","1999-06-03");
        reqdata.put("gender","F");
        reqdata.put("relationship","cousin");

      String token = FileUtils.readFileToString(new File(System.getProperty("user.dir")
              + "/src/test/resources/filejson/token.json"), StandardCharsets.UTF_8);

      given()
              .header("Content-Type","application/json")
              .header("Authorization","Bearer " + token)
              .body(reqdata).when().put(setUpdateFamMemberEndpoint());
  }
}
