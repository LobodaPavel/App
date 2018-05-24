package com.example.pavel.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private List<Movie> movieList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment,
                container, false);
        mRecyclerView = view.findViewById(R.id.recycler);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MoviesAdapter(movieList);
        mRecyclerView.setAdapter(mAdapter);

        prepareMovieData();

        return view;
    }
    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road");
        movieList.add(movie);

        movie = new Movie("Inside Out");
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep Animation 2015");
        movieList.add(movie);

        movie = new Movie("The Martian");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep Animation 2015");
        movieList.add(movie);

        movie = new Movie("The Martian");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep Animation 2015");
        movieList.add(movie);

        movie = new Movie("The Martxedrtxian");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation");
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep Animation 2015");
        movieList.add(movie);

        movie = new Movie("The Martian");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
