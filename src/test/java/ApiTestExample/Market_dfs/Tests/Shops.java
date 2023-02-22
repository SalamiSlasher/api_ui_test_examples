package ApiTestExample.Market_dfs.Tests;

import ApiTestExample.Market_dfs.Dfs;
import ApiTestExample.Market_dfs.EdgeRunner;
import ApiTestExample.Market_dfs.Models.MarketGenerator;
import ApiTestExample.SecretGitIgnore;
import ApiTestExample.Utils.RestMarket;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static ApiTestExample.Utils.TypeRequest.tokenExtractor;

@Tag("Market")
public class Shops extends EdgeRunner {
    @Test
    @DisplayName("Магазины")
    void ShopsTest() {
        Dfs.dfs(MarketGenerator.catGen("32591", "Shops"));
    }
}
