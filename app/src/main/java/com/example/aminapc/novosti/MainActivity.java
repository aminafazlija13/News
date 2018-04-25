package com.example.aminapc.novosti;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String URL_novosti="http://192.168.0.12/products/novosti.php";
    List<Novosti> novostList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        novostList=new ArrayList<>();

        loadnovosti();
    }
    private void loadnovosti(){
        StringRequest stringRequest= new StringRequest (Request.Method.GET, URL_novosti,
                new Response.Listener<String>(){
                @Override
                    public  void  onResponse(String response){
                    try {
                        JSONArray array=new JSONArray(response);
                        for (int i=0;i<array.length();i++) {
                            JSONObject novost=array.getJSONObject(i);

                            novostList.add(new Novosti (
                                    novost.getInt("id"),
                                    novost.getString("naslov"),
                                    novost.getString("slika"),
                                    novost.getString("opis")

                            ));
                        }
                        Adapter adapter=new Adapter(MainActivity.this, novostList);
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                },
        new Response.ErrorListener(){
            @Override
            public void onErrorResponse (VolleyError error){

            }
        });
    Volley.newRequestQueue(this).add(stringRequest);
    }
}
