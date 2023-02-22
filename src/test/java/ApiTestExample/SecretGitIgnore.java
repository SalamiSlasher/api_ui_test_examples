package ApiTestExample;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SecretGitIgnore {
    //  The best way is to use env var or something like vault, but here i will use gitignored json file ^_^

    private static final File jsonFileSecrets = new File("src/test/resources/secrets.json");
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final HashMap<String, String> secrets;

    static {
        try {
            secrets = objectMapper.readValue(jsonFileSecrets, HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String authEndpoint = secrets.get("authEndpoint");
    private static final String marketCategoryEndpoint = secrets.get("marketCategoryEndpoint");
    private static final String subCategoryEndpoint = secrets.get("subCategoryEndpoint");
    private static final String productListEndpoint = secrets.get("productListEndpoint");
    private static final String totalPagesEndpoint = secrets.get("totalPagesEndpoint");
    private static final String productInfoEndpoint = secrets.get("productInfoEndpoint");

    private static String phoneTest = secrets.get("phoneTest");
    private static String passwordTest = secrets.get("passwordTest");
    private static String phoneProd = secrets.get("phoneProd");
    private static String passwordProd = secrets.get("passwordProd");

    private static String apiTest = secrets.get("apiTest");
    private static String apiProd = secrets.get("apiProd");

    private static String testToken = secrets.get("testToken");
    private static String testChatId = secrets.get("testChatId");
    private static String prodToken = secrets.get("prodToken");
    private static String prodChatId = secrets.get("prodChatId");


    public static String getPhoneTest() {
        return phoneTest;
    }

    public static String getPasswordTest() {
        return passwordTest;
    }

    public static String getPhoneProd() {
        return phoneProd;
    }

    public static String getPasswordProd() {
        return passwordProd;
    }

    public static String getApiTest() {
        return apiTest;
    }

    public static String getApiProd() {
        return apiProd;
    }

    public static String getAuthEndpoint() {
        return authEndpoint;
    }

    public static String getMarketCategoryEndpoint() {
        return marketCategoryEndpoint;
    }

    public static String getSubCategoryEndpoint() {
        return subCategoryEndpoint;
    }

    public static String getProductListEndpoint() {
        return productListEndpoint;
    }

    public static String getTotalPagesEndpoint() {
        return totalPagesEndpoint;
    }

    public static String getProductInfoEndpoint() {
        return productInfoEndpoint;
    }

    public static String getTestToken() {
        return testToken;
    }

    public static String getTestChatId() {
        return testChatId;
    }

    public static String getProdToken() {
        return prodToken;
    }

    public static String getProdChatId() {
        return prodChatId;
    }
}
