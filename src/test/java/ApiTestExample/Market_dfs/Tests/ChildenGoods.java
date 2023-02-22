package ApiTestExample.Market_dfs.Tests;

import ApiTestExample.Market_dfs.Dfs;
import ApiTestExample.Market_dfs.EdgeRunner;
import ApiTestExample.Market_dfs.Models.MarketGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Market")
public class ChildenGoods extends EdgeRunner {
    @Test
    @DisplayName("Товары для детей")
    void ChildenGoodsTest() {
        Dfs.dfs(MarketGenerator.catGen("32309", "ChildenGoods"));
    }
}
