package ApiTestExample.Market_dfs;

import ApiTestExample.Market_dfs.Models.FinalSubCat;
import ApiTestExample.Market_dfs.Models.MarketCategory;
import ApiTestExample.Market_dfs.Models.MarketProduct;
import ApiTestExample.Utils.RestMarket;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;

public class Dfs {
    private static AtomicInteger n = new AtomicInteger(0);  // counting count of items

    public static void dfs(MarketCategory category) {
        //  Here we exclude "All products" subcategory
        if (category.name.equals("Все товары")) {
            return;
        }

        if (category.hasChildren) {
            ArrayList<MarketCategory> subCatList = RestMarket.getSubCut(category.id);
            subCatList.parallelStream().forEach(Dfs::dfs);
            return;
        }
        int totalPages = RestMarket.getProductTotalPages(category.id);
        IntStream.range(0, totalPages).parallel().forEach(page -> {
            ArrayList<FinalSubCat> finalCats = RestMarket.getProductList(category.id, page, 10);

            finalCats.parallelStream().forEach(finalCat -> {
                //  Trying to call final endpoint, in catch we're sending report to telegram bot
                try {
                    MarketProduct marketProduct = RestMarket.getProductInfo(finalCat.id);
                    System.out.println(n.getAndIncrement() + ") " + finalCat.id + " " + category.name + ": " + marketProduct.name);
                } catch (Exception | Error e) {
                    String text = String.format(
                            "Category name: %s\nCategory id: %s\nfinal category name: %s\n final category id: %s",
                            category.name, category.id, finalCat.name, finalCat.id
                    );

                    given()
                            .when()
                            .queryParam("chat_id", Config.chatId)
                            .queryParam("text", text)
                            .get(Config.tgBot + "/sendMessage");
                }
            });
        });
    }
}
