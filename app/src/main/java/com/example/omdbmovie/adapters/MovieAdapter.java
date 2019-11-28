package com.example.omdbmovie.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.omdbmovie.activity.DetailsActivity;
import com.example.omdbmovie.MainActivity;
import com.example.omdbmovie.models.MovieModel;
import com.example.omdbmovie.R;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    List<MovieModel> movielist;
        public MovieAdapter(List<MovieModel> movielist) {
        this.movielist = movielist;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView   = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_movi, viewGroup, false);

        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder movieViewHolder, final int i) {

        movieViewHolder.naslov.setText(movielist.get(i).getNaslov());
        movieViewHolder.godina.setText(movielist.get(i).getGodina());

        Glide.with(movieViewHolder.slika.getContext()).load(movielist.get(i).getSlika()).into(movieViewHolder.slika);

            movieViewHolder.itemMoviLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent detailsIntent = new Intent(((MainActivity)
                            movieViewHolder.itemMoviLayout.getContext()), DetailsActivity.class);

                    detailsIntent.putExtra("MOVIID",movielist.get(i).getMoviid());

                    movieViewHolder.itemMoviLayout.getContext().startActivity(detailsIntent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView            naslov;
        TextView            godina;
        ImageView           slika;
        ConstraintLayout    itemMoviLayout;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            naslov          = itemView.findViewById(R.id.textView_title);
            godina          = itemView.findViewById(R.id.textView_godina);
            slika           = itemView.findViewById(R.id.imageView_poster);
            itemMoviLayout  = itemView.findViewById(R.id.item_movie_layout);
        }
    }

}
