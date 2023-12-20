package com.msg.msgalaxy.MVCOfTopRated;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.msg.msgalaxy.AboutMovieOrSerieActivity;
import com.msg.msgalaxy.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterOfTopRatedMovies extends RecyclerView.Adapter<AdapterOfTopRatedMovies.MyViewHolder> {
    private Context context;
    private List<ModelOfTopRatedMovies> topRatedMoviesList;

    public AdapterOfTopRatedMovies(Context context, List<ModelOfTopRatedMovies> topRatedMoviesList) {
        this.context = context;
        this.topRatedMoviesList = topRatedMoviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.toprated_fragment_toprated_movies_card_item, parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelOfTopRatedMovies topRatedMovies = topRatedMoviesList.get(position);

        String rank = topRatedMovies.getRank();
        holder.movieName.setText(rank+ ". " +topRatedMovies.getName());
        holder.movieRating.setText(topRatedMovies.getRating());
        holder.movieYear.setText(topRatedMovies.getYear());
        holder.movieDuration.setText(topRatedMovies.getDuration() + " min");

        Picasso.get().load(topRatedMovies.getPicture()).into(holder.moviePicture, new Callback() {
            @Override
            public void onSuccess() {
                holder.moviePicture.setVisibility(View.VISIBLE);
                holder.loadingAnimation.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return topRatedMoviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CardView showButton;
        private ImageView moviePicture;
        private TextView movieName;
        private TextView movieRating;
        private TextView movieYear;
        private TextView movieDuration;
        private LottieAnimationView loadingAnimation;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            showButton = itemView.findViewById(R.id.topRatedFragment_topRatedMovies_showButtonId);
            moviePicture = itemView.findViewById(R.id.topRatedFragment_topRatedMovies_pictureId);
            movieName = itemView.findViewById(R.id.topRatedFragment_topRatedMovies_nameId);
            movieRating = itemView.findViewById(R.id.topRatedFragment_topRatedMovies_ratingId);
            movieYear = itemView.findViewById(R.id.topRatedFragment_topRatedMovies_yearId);
            movieDuration = itemView.findViewById(R.id.topRatedFragment_topRatedMovies_durationId);

            loadingAnimation = itemView.findViewById(R.id.topRatedFragment_topRatedMovies_loadingLottie);

            showButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context , AboutMovieOrSerieActivity.class);
            //The position of each movie
            int position = getLayoutPosition();
            ModelOfTopRatedMovies modelOfTopRatedMovies = topRatedMoviesList.get(position);
            intent.putExtra("Picture" , modelOfTopRatedMovies.getPicture());
            intent.putExtra("Name", modelOfTopRatedMovies.getName());
            intent.putExtra("Year" , modelOfTopRatedMovies.getYear());
            intent.putExtra("Duration" , modelOfTopRatedMovies.getDuration());
            intent.putExtra("Rating" , modelOfTopRatedMovies.getRating());
            intent.putExtra("Director" , modelOfTopRatedMovies.getDirectorName());
            intent.putExtra("Description" , modelOfTopRatedMovies.getDescription());
            intent.putExtra("Type" , modelOfTopRatedMovies.getType());
            intent.putExtra("Trailer" , modelOfTopRatedMovies.getTrailerUrl());
            context.startActivity(intent);
        }
    }
}
