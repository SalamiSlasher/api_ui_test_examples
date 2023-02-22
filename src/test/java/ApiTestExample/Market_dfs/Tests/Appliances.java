package ApiTestExample.Market_dfs.Tests;

import ApiTestExample.Market_dfs.Dfs;
import ApiTestExample.Market_dfs.EdgeRunner;
import ApiTestExample.Market_dfs.Models.MarketGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Market")
public class Appliances extends EdgeRunner {
    @Test
    @DisplayName("Бытовая техника")
    void AppliancesTest() {
        Dfs.dfs(MarketGenerator.catGen("30836", "Appliances"));
    }
}
