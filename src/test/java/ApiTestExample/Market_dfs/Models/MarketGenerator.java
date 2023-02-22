package ApiTestExample.Market_dfs.Models;

public class MarketGenerator {
    public static MarketCategory catGen(String id, String name) {
        MarketCategory category = new MarketCategory();
        category.id = id;
        category.name = name;
        category.hasChildren = true;
        return  category;
    }
}
