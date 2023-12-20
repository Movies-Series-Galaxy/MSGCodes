package com.msg.msgalaxy.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.msg.msgalaxy.MVCOfCategories.AdapterOfCategories;
import com.msg.msgalaxy.MVCOfCategories.ModelOfCategories;
import com.msg.msgalaxy.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private View view;
    private RecyclerView recyclerViewOfCategories;
    private AdapterOfCategories adapter;
    private List<ModelOfCategories> categoriesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //Clear the Transparent of status bar
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        view = inflater.inflate(R.layout.search_fragment , container , false);

        recyclerViewOfCategories = view.findViewById(R.id.searchFragment_recyclerViewId);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext() , 3 );
        recyclerViewOfCategories.setLayoutManager(layoutManager);
        recyclerViewOfCategories.setHasFixedSize(true);

        String[] pictures = {
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/netflix.png?alt=media&token=d5fda86b-8c18-4bf0-b0cc-bffa3727521f",    //Netflix
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/hbo.png?alt=media&token=88d6ed78-9cb9-496d-ac50-e7028158196c",    //HBO max
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/disney.png?alt=media&token=85dc4ea9-04d5-45da-94a9-90cf2bb261d2",    //Disney+
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/appletv.png?alt=media&token=291a3dc5-cd78-4995-acea-1b2e74a9bff0",    //AppleTv
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/amc.png?alt=media&token=f8c21f93-9fa9-44fb-a8ec-c94199a0c3ab",    //Amc+
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/primevideo.png?alt=media&token=85bc069d-0170-448d-bc23-6e8434d7f7dd"     //Prime video
                ,
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/dc.jpeg?alt=media&token=d038cabd-2756-434c-9771-08655b5541c7",    //DC Comics
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/Wbros.png?alt=media&token=df4e809e-5dc6-4ea1-b12b-aab66ff82903",  //WarnerBros
                "https://firebasestorage.googleapis.com/v0/b/from-firebase-to-my-app.appspot.com/o/marvel.jpeg?alt=media&token=bcc356c0-a4ae-4db5-8c0d-437ebe279b86"   //Marvel Studios
        };

        String[] names = {
                "Netflix" , "HBO Max" , "Disney+" , "Apple Tv" , "AMC+" , "Prime Video" , "DC Comics" , "Warner Bros" , "Marvel Studios"
        };

        String[] backgrounds = {
                "https://pbs.twimg.com/media/GA8ASAYXcAAhhqS?format=jpg&name=large",    //Netflix
                "https://pbs.twimg.com/media/GA7z9OVWIAAV-5f?format=jpg&name=large",    //HBO max
                "https://pbs.twimg.com/media/GA7z9N8WUAAdu94?format=jpg&name=large",    //Disney+
                "https://pbs.twimg.com/media/GA7z9NHWsAEzY5e?format=jpg&name=900x900",  //AppleTv
                "https://pbs.twimg.com/media/GA75cnHXoAAyZ8T?format=jpg&name=large",    //Amc+
                "https://pbs.twimg.com/media/GA75cnnW0AA2vFE?format=png&name=small"     //Prime video
                ,
                "https://pbs.twimg.com/media/GA75cmmWcAAsnz4?format=jpg&name=900x900",  //DC Comics
                "https://pbs.twimg.com/media/GA75cnoXIAAdwvD?format=jpg&name=medium",   //WarnerBros
                "https://pbs.twimg.com/media/GA75lHDWcAAxLFV?format=jpg&name=large"     //Marvel Studios
        };

        categoriesList = new ArrayList<>();

        for(int i=0 ; i<pictures.length ; i++) {
            ModelOfCategories modelOfCategories = new ModelOfCategories(pictures[i] , names[i] , backgrounds[i]);
            categoriesList.add(modelOfCategories);
        }

        adapter = new AdapterOfCategories(getContext() , categoriesList);
        recyclerViewOfCategories.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return view;
    }

}
