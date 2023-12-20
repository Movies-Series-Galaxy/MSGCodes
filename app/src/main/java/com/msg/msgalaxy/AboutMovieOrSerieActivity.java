package com.msg.msgalaxy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutMovieOrSerieActivity extends AppCompatActivity {

    private ImageView moviePicture;
    private TextView movieName , movieType , movieYear , movieDuration;
    private CardView playTrailerBtn , myListBtn;
    private ImageView unselectedFireBtn , selectedFireBtn;
    private ImageView unselectedDislikeBtn , selectedDislikeBtn;
    private TextView numberOfFireTxtView , numberOfDislikeTxtView;
    private int numOfFire , numOfDislike;
    private TextView movieRating;
    private TextView movieDescription;
    private CircleImageView directorPicture , star1Picture , star2Picture , star3Picture;
    private TextView directorName , star1Name , star2Name , star3Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // Transparent status bar
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_about_movie_or_serie);

        //get the data from the other activities
        getDataFromActivitiesAndSetItHere();

        addToMyListProcess();

        fireAndDislikeProcess();

    }

    private void getDataFromActivitiesAndSetItHere() {
        //Initialize the variables
        moviePicture = findViewById(R.id.aboutMovieOrSerieActivity_pictureId);
        movieName = findViewById(R.id.aboutMovieOrSerieActivity_nameId);
        movieYear = findViewById(R.id.aboutMovieOrSerieActivity_yearId);
        movieDuration = findViewById(R.id.aboutMovieOrSerieActivity_durationId);
        movieRating = findViewById(R.id.aboutMovieOrSerieActivity_ratingId);
        directorName = findViewById(R.id.aboutMovieOrSerieActivity_directorNameId);
        movieDescription = findViewById(R.id.aboutMovieOrSerieActivity_descriptionId);
        movieType = findViewById(R.id.aboutMovieOrSerieActivity_typeId);
        String trailerUrl = "";
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String picture = bundle.getString("Picture");
            String name = bundle.getString("Name");
            String year = bundle.getString("Year");
            String duration = bundle.getString("Duration");
            String rating = bundle.getString("Rating");
            String director = bundle.getString("Director");
            String description = bundle.getString("Description");
            String type = bundle.getString("Type");
            trailerUrl = bundle.getString("Trailer");

            //Setting the data into the activity
            Picasso.get().load(picture).into(moviePicture);
            movieName.setText(name);
            movieYear.setText(year);
            movieDuration.setText(duration + " min");
            movieRating.setText(rating);
            directorName.setText(director);
            movieDescription.setText(description);
            movieType.setText(type);
        }
        //Play the Trailer Button and the func will take the Url as String
        playTrailerProcess(trailerUrl);
    }

    private void playTrailerProcess(String trailerUrl) {
        playTrailerBtn = findViewById(R.id.aboutMovieOrSerieActivity_playTrailerButtonId);
        playTrailerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Must remove the the first link (http://www.youtube.com/watch?v=) to get just the Id and For that we used Substring
                String url = "";
                if (trailerUrl.contains("https://www.youtube.com/")) {
                    // Extract the video ID using substring
                    int startIndex = "https://www.youtube.com/watch?v=".length();
                    url = trailerUrl.substring(startIndex);
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + url));
                // If the YouTube app is not installed, open the link in a web browser
                if (intent.resolveActivity(getPackageManager()) == null) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + url));
                }
                startActivity(intent);
            }
        });
    }

    private void addToMyListProcess() {
        myListBtn = findViewById(R.id.aboutMovieOrSerieActivity_myListButtonId);
        myListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void fireAndDislikeProcess() {
        //for Fire Button
        unselectedFireBtn = findViewById(R.id.aboutMovieOrSerieActivity_unselectedFireButtonId);
        selectedFireBtn = findViewById(R.id.aboutMovieOrSerieActivity_selectedFireButtonId);
        numberOfFireTxtView = findViewById(R.id.aboutMovieOrSerieActivity_numberOfFireId);
        numOfFire = 0;

        unselectedFireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Selection of Fire Button
                unselectedFireBtn.setVisibility(View.GONE);
                selectedFireBtn.setVisibility(View.VISIBLE);

                // Increase numOfFire by 1
                numOfFire++;
                // Update the text view with the new value of numOfFire
                numberOfFireTxtView.setText(String.valueOf(numOfFire));

                //Set Selection of Dislike Button
                unselectedDislikeBtn.setVisibility(View.VISIBLE);
                selectedDislikeBtn.setVisibility(View.GONE);
            }
        });
        selectedFireBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Selection of Fire Button
                unselectedFireBtn.setVisibility(View.VISIBLE);
                selectedFireBtn.setVisibility(View.GONE);

                // Decrease  numOfFire by 1
                numOfFire--;
                // Update the text view with the new value of numOfFire
                numberOfFireTxtView.setText(String.valueOf(numOfFire));

            }
        });

        //for Dislike Button
        unselectedDislikeBtn = findViewById(R.id.aboutMovieOrSerieActivity_unselectedDislikeButtonId);
        selectedDislikeBtn = findViewById(R.id.aboutMovieOrSerieActivity_selectedDislikeButtonId);
        numberOfDislikeTxtView = findViewById(R.id.aboutMovieOrSerieActivity_numberOfDislikeId);
        numOfDislike = 0;

        unselectedDislikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Selection of Dislike Button
                unselectedDislikeBtn.setVisibility(View.GONE);
                selectedDislikeBtn.setVisibility(View.VISIBLE);

                // Increase numOfDislike by 1
                numOfDislike++;
                // Update the text view with the new value of numOfDislike
                numberOfDislikeTxtView.setText(String.valueOf(numOfDislike));

                //Set Selection of Fire Button
                unselectedFireBtn.setVisibility(View.VISIBLE);
                selectedFireBtn.setVisibility(View.GONE);
            }
        });
        selectedDislikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set Selection of Dislike Button
                unselectedDislikeBtn.setVisibility(View.VISIBLE);
                selectedDislikeBtn.setVisibility(View.GONE);

                // Decrease  numOfDislike by 1
                numOfDislike--;
                // Update the text view with the new value of numOfDislike
                numberOfDislikeTxtView.setText(String.valueOf(numOfDislike));
            }
        });
    }


}