package ApiTestExample.Market_dfs.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FinalSubCat {
    public String id;
    public String name;
    public Integer totalPages;
    public Integer total;
}
