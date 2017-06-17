package naman.com.bharatcustomers;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Naman on 17-06-2017.
 */

public class ApiHead {
    //private static final String hitpoint="http://192.178.5.30:3000/getvendor";
    private static String hitpoint="http://192.178.5.30:3000/getvendor?item=";
    private static final String decrementhitpoint="http://192.178.5.30:3000/dec";
    public static Context context;

    public ApiHead(Context c)
    {
        this.context = c;
    }
    public static void sendQuery(String query, Context c)
    {
        RequestQueue queue = Volley.newRequestQueue(c);
        hitpoint = hitpoint.concat("[\"" + query + "\"]");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, hitpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("api", response);
                        ArrayList<Shop> shops= new ArrayList<>();
                        try {
                            JSONArray json = new JSONArray(response);
                            for(int i=0; i< json.length(); i++)
                            {
                                JSONObject obj = json.getJSONObject(i);
                                Shop shop = new Shop(obj.getString("name").replace("\"",""),obj.getString("address").replace("\"",""),obj.getString("contact").replace("\"",""),Integer.parseInt(obj.getString("price").replace("[","").replace("]","")));
                                shops.add(shop);
                            }
                            ShopResultsActivity.addItems(shops);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest);
    }

    public static void decrement(String contactnum, int n, String item)
    {

    }
}
