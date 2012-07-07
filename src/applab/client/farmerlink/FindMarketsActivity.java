package applab.client.farmerlink;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class FindMarketsActivity extends ListActivity {
    
    List<MarketPrices> marketPrices;
    private String commodityName = "Commodity Price for ";
    String crop;
    String district;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
                
        // Get data from intent
        /*Bundle bundle = getIntent().getExtras();
        crop = bundle.getString(GlobalConstants.CROP);
        district = bundle.getString(GlobalConstants.DISTRICT); */
        district = MarketSaleObject.getMarketObject().getDistrictName();
        crop = MarketSaleObject.getMarketObject().getCropName();
            
        commodityName += crop;
        
        marketPrices = Repository.getMarketPricesByDistrictAndCrop(crop, district); 
                
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_markets);
        setListAdapter(new PricesAdapter());
        
        TextView commodityTextView = (TextView) findViewById(R.id.commodity_name);
        commodityTextView.setText(commodityName);
        
        Button findBuyersButton = (Button) findViewById(R.id.next_find_buyer);
        findBuyersButton.setOnClickListener(new Button.OnClickListener() {
            
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PotentialBuyersActivity.class);
                startActivity(intent);
                
            }
        });
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	
        MarketPrices market = marketPrices.get(position);
        Intent intent = new Intent(getApplicationContext(), TransportEstimatorActivity.class);
        MarketSaleObject.getMarketObject().setMarketPrices(market);
        //intent.putExtra(GlobalConstants.CROP, crop);
        startActivity(intent);
    }
    
    class PricesAdapter extends ArrayAdapter<MarketPrices> {
        
        PricesAdapter() {
            super(FindMarketsActivity.this, R.layout.market_prices_list, R.id.market_name, marketPrices);
        }
        
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            
            View row = inflater.inflate(R.layout.market_prices_list, parent, false);
            TextView marketView = (TextView) row.findViewById(R.id.market_name);
            marketView.setText("Market Name : " + marketPrices.get(position).getMarketName());
           
            TextView retailPriceView = (TextView) row.findViewById(R.id.retail_price);
            retailPriceView.setText("Retail Price : " + marketPrices.get(position).getRetailPrice());
            
            TextView wholesalePriceView = (TextView) row.findViewById(R.id.wholesale_price);
            wholesalePriceView.setText("Wholesale Price : " + marketPrices.get(position).getWholesalePrice());
            
            return row;
        }        
    }

}
