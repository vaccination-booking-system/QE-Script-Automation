package starter.city_news;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class news {

    private static String base_url = "http://50.19.175.143";

    @Step
    public String setPostNewsEndpoint(){
        return base_url + "/api/v1/news";
    }

    public void setNewsDetail(String title, String desc, String content) throws Exception{
        JSONObject reqdata = new JSONObject();

        reqdata.put("title",title);
        reqdata.put("description",desc);
        reqdata.put("content",content);


        String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + superAdminAccessToken)
                .body(reqdata).when().post(setPostNewsEndpoint());
    }

    public void validateAfterCreateNewsdetail(int code, String message) {

        if (message.equals("SUCCESS")) {

            then().statusCode(equalTo(code));
            then().body("message",equalTo(message));

            Response response = SerenityRest.lastResponse();

            int newsId = response.body().path("data.id");
            String news_id = String.valueOf(newsId);

            try (FileWriter file = new FileWriter("src/test/resources/filejson/newsId.json")) {

                file.write(news_id);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (message.equals("INVALID_INPUT")) {
            then().statusCode(equalTo(code));
            then().body("message",equalTo(message));
        }
    }

    public void setNewsDetailUsingRegAdmin() throws Exception{
        JSONObject data = new JSONObject();
        data.put("title","Vaksin Sinovac");
        data.put("description","Vaksin Sinovac tersisa 5 botol");
        data.put("content","Update stock Sinovac");

        String regulerAdminAccToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + "/src/test/resources/filejson/adminAccessToken.json"), StandardCharsets.UTF_8);


        given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + regulerAdminAccToken)
                .body(data).when().post(setPostNewsEndpoint());


    }

   public void validateStatusCodeAndDetailAfterSendPostReq(int code, String message){
            then().statusCode(equalTo(code));
//            then().body("message",equalTo(message));
   }

   public void sendGetAllNewsReq() throws Exception{


       String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
               + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

       given()
               .header("Content-Type","application/json")
               .header("Authorization","Bearer " + superAdminAccessToken)
               .when().get(setPostNewsEndpoint());

   }

   public void validateStatusCodeAndDetailForNews(int code, String message){
        then().statusCode(equalTo(code));
        then().body("message",equalTo(message));
   }

   public String setEndpointForFindSpecNews(){
        return base_url + "/api/v1/news/14";
   }

   public void sendFindSpecNewsReq() throws Exception{
       String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
               + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

       given()
               .header("Content-Type","application/json")
               .header("Authorization","Bearer " + superAdminAccessToken)
               .when().get(setEndpointForFindSpecNews());
   }

   public String deleteSpecNewsEndpoint(){
        return base_url + "/api/v1/news/{id}";
   }

   public void sendDeleteSpecNewsReq() throws Exception{
       String newsId = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/newsId.json")
               , StandardCharsets.UTF_8);

       String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
               + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);

       given()
               .pathParam("id",newsId)
               .header("Content-Type","application/json")
               .header("Authorization","Bearer " + superAdminAccessToken)
               .when().delete(deleteSpecNewsEndpoint());
   }

   public void setUpdateNewsDetail() throws Exception{
        JSONObject req = new JSONObject();

       req.put("title","Vaksin Sinovac");
       req.put("description","Vaksin Sinovac tersisa 5 botol");
       req.put("content","Update stock Sinovac");

       String superAdminAccessToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
               + "/src/test/resources/filejson/superAdminToken.json"), StandardCharsets.UTF_8);


       given()
               .header("Content-Type","application/json")
               .header("Authorization","Bearer " + superAdminAccessToken)
               .body(req).when().put(setEndpointForFindSpecNews());
   }


}
