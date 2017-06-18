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
    private String hitpoint="http://192.178.5.30:3000/getvendor?item=";
    private String infoHitpoint="http://192.178.5.30:3000/getvendorinfo?contact=";
    private String updateHitpoint="http://192.178.5.30:3000/getvendorinfo?";
    private static final String decrementhitpoint="http://192.178.5.30:3000/dec";
    public static Context context;
    RequestQueue queue;

    public ApiHead(Context c)
    {
        this.context = c;
        queue = Volley.newRequestQueue(context);
    }
    public void sendQuery(String query)
    {
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

    public void getAllInfo(String contact)
    {
        infoHitpoint = infoHitpoint.concat(contact);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, infoHitpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject obj=null;
                        try {
                            JSONArray array = new JSONArray(response);
                             obj= array.getJSONObject(0);
                            updateHitpoint = updateHitpoint.concat("name=" + obj.getString("name") + "&");
                            updateHitpoint = updateHitpoint.concat("address=" + obj.getString("address") + "&");
                            updateHitpoint = updateHitpoint.concat("contact=" + obj.getString("contact") + "&");
                            updateHitpoint = updateHitpoint.concat("quantity=" + obj.get("quantity").toString().replace("[","").replace("]","").replace("\"\\","").replace("\\\"","") + "&");
                            updateHitpoint = updateHitpoint.concat("price=" + obj.get("price").toString().replace("[","").replace("]","").replace("\"\\","").replace("\\\"","") + "&");
                            updateHitpoint = updateHitpoint.concat("item=" + obj.get("item").toString().replace("[","").replace("]","").replace("\"\\","").replace("\\\"","") + "");
                            Log.d("api result", updateHitpoint);

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




        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, updateHitpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        });
        queue.add(stringRequest2);
    }
}
