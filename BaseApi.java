package Base;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
@Component
public class BaseApi {
    public static Response getAuthToken(String testurl, String username, String password) {
        Map<String, Object> jsonAsMap = new HashMap();
        jsonAsMap.put("username", username);
        jsonAsMap.put("password", password);
        Response response = RestAssured.given().
                contentType("application/json").
                body(jsonAsMap).
                when().log().all().post(testurl).
                then().extract().response();
        return response;
    }
}