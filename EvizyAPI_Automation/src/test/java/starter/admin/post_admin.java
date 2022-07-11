package starter.admin;

import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class post_admin {

    private static String base_url = "http://50.19.175.143";

    @Step("set post admin endpoint")
    public String setPostAdminEndpoint(){
        return base_url + "/api/v1/admin";
    }

    @Step("set post detail")
    public void setPostAdminDetail(String username,String name,String password) throws Exception{
        JSONObject reqdata = new JSONObject();

        reqdata.put("username",username);
        reqdata.put("name",name);
        reqdata.put("password",password);

        String SuperAdminToken = FileUtils.readFileToString(new File(System.getProperty("user.dir")
        + "src/test/resources/filejson/SuperAdminToken.json"), StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorzation","Bearer" + SuperAdminToken)
                .body(reqdata.toJSONString()).when().post(setPostAdminEndpoint());
    }

    @Step("validate status code and detail")
    public void validateStatusCodeAndDetailAfterPostAdmin(int code){
        then().statusCode(equalTo(code));

        if (code == 200 ){
            then().body("message",equalTo("SUCCESS"));
        } else if (code == 400){
            then().body("message",equalTo("ALREADY_EXIST"));
        } else if (code == 400) {
            then().body("message",equalTo("INVALID_INPUT"));
        }

    }

}
