package naman.com.bharatcustomers;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Naman on 17-06-2017.
 */

public class ApiHead {




    private static final String hitpoint="http://192.178.5.30:3000/getvendors";
    private static final String decrementhitpoint="http://192.178.5.30:3000/getvendors";


    public static ArrayList<Shop> sendQuery(String query)
    {
        AsyncHttpClient client = new AsyncHttpClient();
        ArrayList<Shop> shops = new ArrayList<>();
        RequestParams params = new RequestParams();
        params.put("query",query);
        client.get(hitpoint, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                try {
                    JSONObject json = new JSONObject(responseString);
                    //parse jsonobject here to get objects and call shops.add
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Log.d("api", "called");

        shops.add(new Shop("yolo book store", "any random address", 1234, 10));
        shops.add(new Shop("abcd book store", "any random address", 3215, 101));
        shops.add(new Shop("efgh book store", "any random address", 453, 1024));
        shops.add(new Shop("jk book store", "any random address", 654, 150));
        return shops;
    }

    public void decrement(String contactnum)
    {
        RequestParams params = new RequestParams();
        params.put("contact",contactnum);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(decrementhitpoint, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200)
                    Log.d("decrement", "successful");
                else if(statusCode == 400)
                    Log.d("decrement", "failure");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
