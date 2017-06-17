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

import java.util.ArrayList;

/**
 * Created by Naman on 17-06-2017.
 */

public class ApiHead {
    //private static final String hitpoint="http://192.178.5.30:3000/getvendor";
    private static final String hitpoint="http://192.178.5.30:3000/getvendor?item=lays";
    private static final String decrementhitpoint="http://192.178.5.30:3000/dec";
    public static Context context;

    public ApiHead(Context c)
    {
        this.context = c;
    }
    public static ArrayList<Shop> sendQuery(String query, Context c)
    {
        //AsyncHttpClient client = new AsyncHttpClient();
        RequestQueue queue = Volley.newRequestQueue(c);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, hitpoint,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("api", response);
                        try {
                            JSONArray json = new JSONArray(response);




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

        ArrayList<Shop> shops = new ArrayList<>();

        return shops;
    }

    public static void decrement(String contactnum, int n, String item)
    {

    }
}
