package com.msg.msgalaxy.MVCOfCategories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.msg.msgalaxy.R;
import com.squareup.picasso.Picasso;

public class CategorieMoviesAndSeries extends AppCompatActivity {

    private ImageView categorieBackgroundImageView;
//    private TextView categorieNameTextView;
    private CardView arrowBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categorie_movies_and_series);

        collapsingFunc();


        arrowBackButton = (CardView) findViewById(R.id.categorieMoviesAndSeriesActivity_arrowBackId);
        arrowBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Back From this Activity to LoginActivity
                CategorieMoviesAndSeries.super.onBackPressed();
            }
        });
    }
    private void collapsingFunc() {
        categorieBackgroundImageView = (ImageView) findViewById(R.id.categorieMoviesAndSeriesActivity_categorieBackgroundId);
//        categorieNameTextView = (TextView) findViewById(R.id.categorieMoviesAndSeriesActivity_categorieNameId);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String categorieName = bundle.getString("categorieName");
            String categorieBackground = bundle.getString("categorieBackground");
//            categorieNameTextView.setText(categorieName);
            Picasso.get().load(categorieBackground).into(categorieBackgroundImageView);
        }
    }

}