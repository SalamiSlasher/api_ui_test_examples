package ApiTestExample.Market_dfs.Tests;

import ApiTestExample.Market_dfs.Dfs;
import ApiTestExample.Market_dfs.EdgeRunner;
import ApiTestExample.Market_dfs.Models.MarketGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Market")
public class SportsTourism extends EdgeRunner {
    @Test
    @DisplayName("Спорт и туризм")
    void SportsTourismTest() {
        Dfs.dfs(MarketGenerator.catGen("31297", "SportsTourism"));
    }
}
