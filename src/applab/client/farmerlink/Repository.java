package applab.client.farmerlink;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    
    public static ArrayList<String> getFarmersByDistrictAndCrop(String district, String crop) {
        ArrayList<String> farmers = new ArrayList<String>();
        
        // Add some dummy farmers to use in the autocomplete
        farmers.add("james Onyango");
        farmers.add("james Pombe");
        farmers.add("phillip Banya");
        farmers.add("andrew Makanya");
        farmers.add("billy Blanks");
        
        return farmers;
    }

    public static List<MarketPrices> getMarketPricesByDistrictAndCrop(String crop, String district) {
        
        ArrayList<MarketPrices> marketPrices = new ArrayList<MarketPrices>();
        marketPrices.add(new MarketPrices("First Market", "6000", "4000"));
        marketPrices.add(new MarketPrices("Second Market", "6000", "4000"));
        marketPrices.add(new MarketPrices("Third Market", "6000", "2000"));
        marketPrices.add(new MarketPrices("Fourth Market", "5000", "4000"));
        marketPrices.add(new MarketPrices("Fifth Market", "7000", "4000"));
        marketPrices.add(new MarketPrices("First Market", "6000", "4000"));
        marketPrices.add(new MarketPrices("Second Market", "6000", "4000"));
        marketPrices.add(new MarketPrices("Third Market", "6000", "2000"));
        marketPrices.add(new MarketPrices("Fourth Market", "5000", "4000"));
        marketPrices.add(new MarketPrices("Fifth Market", "7000", "4000"));
        
        return marketPrices;
    }
}
