package Base;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;
@Component
public class GetallCustRecords {
    public static Response getdetails(String url, String userName, String password) {
        String token = BaseApi.getAuthToken("http://13.126.80.194:8080/authenticate", userName, password).getBody().jsonPath().get("token");
        Response response = RestAssured.given().header("Authorization", "Bearer " + token).
        get(url).then().extract().response();
        return response;
    }
    public static Response VerifyWithEmptyToken(String url, String userName, String password) {
        String token = BaseApi.getAuthToken("http://13.126.80.194:8080/authenticate", userName, password).getBody().jsonPath().get("token");
        Response response = RestAssured.given().header("Authorization", "Bearer " + "").
        get(url).then().extract().response();
        return response;
    }
}