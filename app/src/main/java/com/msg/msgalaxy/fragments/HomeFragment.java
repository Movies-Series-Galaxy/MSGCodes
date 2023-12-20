package com.msg.msgalaxy.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.msg.msgalaxy.R;
import com.msg.msgalaxy.MVCOfTopMSG_homeFragment.AdapterOfTopMSG;
import com.msg.msgalaxy.MVCOfTopMSG_homeFragment.ModelOfTopMSG;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    private View view;

    private List<ModelOfTopMSG> topMSGList;
    private CardView playTrailerButton;
    private AdapterOfTopMSG adapter;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Transparent status bar
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        view = inflater.inflate(R.layout.home_fragment , container , false);


        viewPager = view.findViewById(R.id.homeFragment_viewPagerId);

        listFunc();

        circleIndicator = (CircleIndicator) view.findViewById(R.id.homeFragment_indicatorId);
        circleIndicator.setViewPager(viewPager);

        return view;
    }
    private void listFunc() {
        topMSGList = new ArrayList<>();

        String topMSGPicUrl[] = {
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/fightclub.bmp?alt=media&token=d33eafb5-aa9b-4be2-95e0-28393dbda370",
                "https://pbs.twimg.com/media/GBOAKPSXYAAMeuX?format=jpg&name=large",
                "https://pbs.twimg.com/media/GBOAKOCWUAArsFr?format=jpg&name=large",
                "https://pbs.twimg.com/media/GBOAKN7XkAAmCrq?format=jpg&name=medium",
                "https://pbs.twimg.com/media/GBOAMx5WkAAF-Df?format=jpg&name=large"

        };
        String topMSGTrailerUrl[] = {
                "watch?v=MCb13lbVGE0&t=79s&ab_channel=lordlook",
                "watch?v=Q0eCiCinc4E&ab_channel=RottenTomatoesClassicTrailers",
                "watch?v=kVrqfYjkTdQ&ab_channel=RottenTomatoesTrailers",
                "watch?v=LV-nazLVmgo&ab_channel=BRASStv",
                "watch?v=MCb13lbVGE0&t=79s&ab_channel=lordlook"
        };
        String topMSGType[] = {
                "Movie",
                "Movie",
                "Movie",
                "Serie",
                "Movie"
        };
        String topMSGYear[] = {
                "1999",
                "2019",
                "2011",
                "1999-...",
                "2006"
        };
        String topMSGImdbRating[] = {
                "8.8",
                "9.8",
                "9.0",
                "9.9",
                "9.5"
        };

        for(int i = 0 ; i <topMSGPicUrl.length ; i++) {
            ModelOfTopMSG modelOfTopMSG = new ModelOfTopMSG(topMSGPicUrl[i] , topMSGTrailerUrl[i] ,topMSGType[i], topMSGYear[i] , topMSGImdbRating[i]);
            topMSGList.add(modelOfTopMSG);
        }

        playTrailerButton = (CardView) view.findViewById(R.id.homeFragment_playTrailerButtonId);
        // Set a general click listener for the playTrailerButton
        playTrailerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the position of the clicked item
                int position = viewPager.getCurrentItem();
                // Handle the click for the item at the captured position
                playTrailer(topMSGList.get(position).getTopMSGTrailerUrl());
            }
        });

        adapter = new AdapterOfTopMSG(getContext() , topMSGList);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(0 , 0 , 0 , 0);

    }

    // Method to handle trailer playback
    private void playTrailer(String trailerUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + trailerUrl));
        // If the YouTube app is not installed, open the link in a web browser
        if (intent.resolveActivity(getContext().getPackageManager()) == null) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + trailerUrl));
        }
        startActivity(intent);
    }
}
