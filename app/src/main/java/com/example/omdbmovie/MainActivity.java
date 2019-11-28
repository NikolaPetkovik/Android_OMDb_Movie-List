package com.example.omdbmovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.omdbmovie.adapters.MovieAdapter;
import com.example.omdbmovie.models.MovieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

        List<MovieModel> movelist;
        MovieAdapter     movieAdapter;

        JsonObjectRequest ObjectRequest;
        RequestQueue      requestQueue;

        RecyclerView recyclerView;

        String URL_JSON;
        String url_API      = "http://www.omdbapi.com/";
        String search_QERY  = "?s=";
        String id           = "Batman";
        String pageNum      = "2";
        String key_API      = "apikey=779d4917";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        setComponents();

        jsoncall();
    }

    private void initComponents() {
        movelist     = new ArrayList<>();
        movieAdapter = new MovieAdapter(movelist);
        recyclerView = findViewById(R.id.recyclerview_list);

        URL_JSON     = url_API + search_QERY + id + "&" + "page=" + pageNum + "&" + key_API;
    }

    private void setComponents() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(movieAdapter);
    }

    private void jsoncall() {

        ObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_JSON, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("Search");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < jsonArray.length(); i++) {

                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        MovieModel movie = new MovieModel();

                        movie.setSlika(jsonObject.getString("Poster"));
                        movie.setNaslov(jsonObject.getString("Title"));
                        movie.setGodina(jsonObject.getString("Year"));
                        movie.setMoviid(jsonObject.getString("imdbID"));

                        movelist.add(movie);
                        if(i== jsonArray.length()-1)
                            movieAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("onErrorResponse", error.toString());
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(ObjectRequest);
    }

}
