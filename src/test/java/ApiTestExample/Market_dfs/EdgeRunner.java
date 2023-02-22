package ApiTestExample.Market_dfs;

import ApiTestExample.SecretGitIgnore;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class EdgeRunner {
    @BeforeAll
    static void setUp() {
        Config.token = Config.isTestTg ? SecretGitIgnore.getTestToken() : SecretGitIgnore.getProdToken();
        Config.chatId = Config.isTestTg ? SecretGitIgnore.getTestChatId() : SecretGitIgnore.getProdChatId();
        Config.phone = Config.isTest ? SecretGitIgnore.getPhoneTest() : SecretGitIgnore.getPhoneProd();
        Config.password = Config.isTest ? SecretGitIgnore.getPasswordTest() : SecretGitIgnore.getPasswordProd();

        Config.tgBot = "https://api.telegram.org/bot" + Config.token;
        RestAssured.baseURI = Config.isTest ? SecretGitIgnore.getApiTest() : SecretGitIgnore.getApiProd();
    }

    @AfterAll
    static void report() {
        //  Here we can se wonderful allure report, but not in this example
    }
}
