package com.example.nacin.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    Adaptador  adaptador;
    RecyclerView recyclerView;
    ArrayList<Datos> datoses= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        adaptador = new Adaptador(this,datoses);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptador);

        CargarDatos();

    }


    public void CargarDatos() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pixabay.com/api/?key=4792335-cd8af72a09ac90bceb8bb8c63&category=nature";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject((new String(response)));
                    JSONArray jsonArray = jsonObject.optJSONArray("hits");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        String id = jsonArray.getJSONObject(i).getString("id");
                        String imagen = jsonArray.getJSONObject(i).getString("previewURL");

                        Log.e("Imagen ",imagen);

                        datoses.add(new Datos(imagen,id));

                    }
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Error " + e, Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
    }
}
