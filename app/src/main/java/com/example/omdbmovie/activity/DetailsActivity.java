package com.example.omdbmovie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.omdbmovie.models.DetailsModel;
import com.example.omdbmovie.R;
import org.json.JSONException;
import org.json.JSONObject;


public class DetailsActivity extends AppCompatActivity {

        String  id;
        String  urlAPI      = "http://www.omdbapi.com/";
        String  api_key     = "apikey=779d4917";
        String  searchQery  = "?i=";

        JsonObjectRequest   objectRequest;
        RequestQueue        requestQueue;


        ImageView poster;
        TextView  title,      released,   runtime, genre, director,
                production, imdbRating, writer,  actors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initComponents();
        setComponents();
    }

    private void initComponents() {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("MOVIID");
            urlAPI += searchQery + id;
        }

        poster      = findViewById(R.id.imageView_poster);
        title       = findViewById(R.id.textView_title);
        released    = findViewById(R.id.textView_released);
        runtime     = findViewById(R.id.textView_runtime);
        genre       = findViewById(R.id.textView_genre);
        director    = findViewById(R.id.textView_director);
        production  = findViewById(R.id.textView_production);
        imdbRating  = findViewById(R.id.textView_imdbRating);
        writer      = findViewById(R.id.textView_writer);
        actors      = findViewById(R.id.textView_actors);

        jsoncall();
    }

    private void setComponents() {
    }

    private void jsoncall() {

        String URL_JSON = urlAPI + "&" + api_key;

        objectRequest = new JsonObjectRequest(Request.Method.GET, URL_JSON, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                DetailsModel details = new DetailsModel();

                try {
                    details.setPoster(response.getString("Poster"));
                    Glide.with(DetailsActivity.this).load(details.getPoster()).centerCrop().into(poster);

                    details.setTitle(response.getString("Title"));
                    title.setText(details.getTitle());

                    details.setReleased(response.getString("Released"));
                    released.setText(details.getReleased());

                    details.setRuntime(response.getString("Runtime"));
                    runtime.setText(details.getRuntime());

                    details.setGenre(response.getString("Genre"));
                    genre.setText(details.getGenre());

                    details.setDirector(response.getString("Director"));
                    director.setText(details.getDirector());

                    details.setProduction(response.getString("Production"));
                    production.setText(details.getProduction());

                    details.setImdbRating(response.getString("imdbRating"));
                    imdbRating.setText(details.getImdbRating());

                    details.setWriter(response.getString("Writer"));
                    writer.setText(details.getWriter());

                    details.setActors(response.optString("Actors", "/"));
                    actors.setText(details.getActors());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("onErrorResponse", error.toString());
            }
        });

        requestQueue = Volley.newRequestQueue(DetailsActivity.this);
        requestQueue.add(objectRequest);
    }

}




