package ApiTestExample.Utils;

import ApiTestExample.Market_dfs.Models.FinalSubCat;
import ApiTestExample.Market_dfs.Models.MarketCategory;
import ApiTestExample.Market_dfs.Models.MarketProduct;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

import ApiTestExample.Market_dfs.Config;
import static ApiTestExample.Utils.TypeRequest.tokenExtractor;
import static io.restassured.RestAssured.given;
import ApiTestExample.SecretGitIgnore;

public class RestMarket {
    private static final String TOKEN = tokenExtractor(Config.phone, Config.password);

    static private RequestSpecification Auth() {
        return given().auth().oauth2(TOKEN);
    }

    public static ArrayList<MarketCategory> getCatalog() {
        Response response = given()
                .spec(Auth())
                .when()
                .header("Accept-Language", "ru")
                .queryParam("cityId", "2")
                .get(SecretGitIgnore.getMarketCategoryEndpoint())
                .then()
                .statusCode(200)
                .extract().response();
        return new ArrayList<>(response.jsonPath().getList("list", MarketCategory.class));
    }

    public static ArrayList<MarketCategory> getSubCut(String id) {
        Response response = given()
                .spec(Auth())
                .when()
                .header("Accept-Language", "ru")
                .get(SecretGitIgnore.getSubCategoryEndpoint() + id)
                .then()
                .statusCode(200)
                .extract().response();
        return new ArrayList<>(response.jsonPath().getList("list", MarketCategory.class));
    }

    public static ArrayList<FinalSubCat> getProductList(String id, int page, int size) {
        Response response = given()
                .spec(Auth())
                .when()
                .header("Accept-Language", "ru")
                .queryParam("cityId", "2")
                .queryParam("catId", id)
                .queryParam("status", "PUBLISHED")
                .queryParam("page", page)
                .queryParam("size", size)
                .get(SecretGitIgnore.getProductListEndpoint())
                .then()
                .statusCode(200)
                .extract().response();
        return new ArrayList<>(response.jsonPath().getList("content", FinalSubCat.class));
    }

    public static int getProductTotalPages(String id) {
        Response response = given()
                .spec(Auth())
                .when()
                .header("Accept-Language", "ru")
                .queryParam("cityId", "2")
                .queryParam("catId", id)
                .queryParam("status", "PUBLISHED")
                .queryParam("page", 0)
                .queryParam("size", 10)
                .get(SecretGitIgnore.getTotalPagesEndpoint())
                .then()
                .statusCode(200)
                .extract().response();
        return response.path("totalPages");
    }

    public static MarketProduct getProductInfo(String id) {
        return given()
                .spec(Auth())
                .when()
                .header("Accept-Language", "ru")
                .queryParam("cityId", "2")
                .get(SecretGitIgnore.getProductInfoEndpoint() + id)
                .then()
                .statusCode(200)
                .extract().as(MarketProduct.class);
    }
}
