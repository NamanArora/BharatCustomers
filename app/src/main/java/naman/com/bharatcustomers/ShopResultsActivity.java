package naman.com.bharatcustomers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ShopResultsActivity extends AppCompatActivity {

    RecyclerView recycler;
    GridLayoutManager gridLayoutManager;
    ShopGridAdapter gridAdapter;
    ArrayList<Shop> shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_results);

        shops = new ArrayList<Shop>();
        recycler = (RecyclerView) findViewById(R.id.recycler);
        gridLayoutManager = new GridLayoutManager(this,1);
        gridAdapter = new ShopGridAdapter(shops);
        recycler.setLayoutManager(gridLayoutManager);
        recycler.setAdapter(gridAdapter);
        populateItems();
    }

    private void populateItems() {

        shops.add(new Shop("yolo book store", "any random address", 1234, 10));
        shops.add(new Shop("abcd book store", "any random address", 3215, 101));
        shops.add(new Shop("efgh book store", "any random address", 453, 1024));
        shops.add(new Shop("jk book store", "any random address", 654, 150));
        gridAdapter.notifyDataSetChanged();
    }
}
