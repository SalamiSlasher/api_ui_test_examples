package ApiTestExample.Utils;

import ApiTestExample.Utils.Models.UserLogin;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ApiTestExample.SecretGitIgnore;

import static io.restassured.RestAssured.given;

public class TypeRequest {
    protected static RequestSpecification LoginSpec(Object userLogin) {
        return given()
                .header("Accept-Language", "ru")
                .contentType(ContentType.JSON)
                .body(userLogin);
    }

    public static String tokenExtractor(String phone, String password) {
        UserLogin userLogin = new UserLogin(phone, password);
        Response response = given()
                .spec(LoginSpec(userLogin))
                .when()
                .post(SecretGitIgnore.getAuthEndpoint())
                .then()
                //.log().body()
                .statusCode(200)
                .extract()
                .response();
        return response.path("accessToken");
    }
}
