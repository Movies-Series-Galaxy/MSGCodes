package com.msg.msgalaxy.MVCOfTopRated;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.msg.msgalaxy.R;

import java.util.ArrayList;
import java.util.List;

public class TopRatedMoviesFragment extends Fragment {
    private View view;
    private RecyclerView recyclerViewOfMovies;
    private AdapterOfTopRatedMovies adapter;
    private List<ModelOfTopRatedMovies> topRatedMoviesList;
    //Firebase
    private DatabaseReference myReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tablayout_toprated_movies_fragment, container , false);

        //Initialize the variables
        recyclerViewOfMovies = view.findViewById(R.id.tablayoutTopRatedMoviesFragment_recyclerViewId);
        recyclerViewOfMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewOfMovies.setHasFixedSize(true);

        getDataFromFirebase();

        return view;
    }

    private void getDataFromFirebase() {

        topRatedMoviesList = new ArrayList<>();

        myReference = FirebaseDatabase.getInstance().getReference();

        Query query = myReference.child("topimdbrating");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ModelOfTopRatedMovies modelOfFireFragment = new ModelOfTopRatedMovies();

                    modelOfFireFragment.setPicture(snapshot.child("Picture").getValue().toString());
                    modelOfFireFragment.setRank(snapshot.child("Rank").getValue().toString());
                    modelOfFireFragment.setName(snapshot.child("Name").getValue().toString());
                    modelOfFireFragment.setYear(snapshot.child("Year").getValue().toString());
                    modelOfFireFragment.setDuration(snapshot.child("Duration").getValue().toString());
                    modelOfFireFragment.setRating(snapshot.child("Rating").getValue().toString());
                    modelOfFireFragment.setDirectorName(snapshot.child("Director").getValue().toString());
                    modelOfFireFragment.setDescription(snapshot.child("Description").getValue().toString());
                    modelOfFireFragment.setType(snapshot.child("Type").getValue().toString());
                    modelOfFireFragment.setTrailerUrl(snapshot.child("Trailer").getValue().toString());

                    topRatedMoviesList.add(modelOfFireFragment);
                }

                adapter = new AdapterOfTopRatedMovies(getContext() , topRatedMoviesList);
                recyclerViewOfMovies.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}
