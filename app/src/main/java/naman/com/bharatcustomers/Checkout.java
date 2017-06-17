package naman.com.bharatcustomers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Intent intent = getIntent();
        String contact = intent.getStringExtra("contact");
        int qty = Integer.parseInt(intent.getStringExtra("qty"));
        String item = intent.getStringExtra("item");

        ApiHead.decrement(contact, qty, item);
    }
}
