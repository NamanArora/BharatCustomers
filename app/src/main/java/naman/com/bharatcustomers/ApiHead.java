package naman.com.bharatcustomers;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by Naman on 17-06-2017.
 */

public class ApiHead {
    private static final String hitpoint="http://192.178.5.30:3000/getvendor";
    private static final String decrementhitpoint="http://192.178.5.30:3000/dec";
    public static Context context;

    public ApiHead(Context c)
    {
        this.context = c;
    }
    public static ArrayList<Shop> sendQuery(String query)
    {
        //AsyncHttpClient client = new AsyncHttpClient();
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, hitpoint,
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

        ArrayList<Shop> shops = new ArrayList<>();

        return shops;
    }

    public static void decrement(String contactnum, int n, String item)
    {

    }
}
