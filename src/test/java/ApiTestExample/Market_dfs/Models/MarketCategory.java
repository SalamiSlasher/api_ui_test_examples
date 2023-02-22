package ApiTestExample.Market_dfs.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketCategory {
    public String id;
    public String name;
    public Boolean hasChildren;
}
