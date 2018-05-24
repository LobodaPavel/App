package com.example.pavel.myapplication;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder>{

    private List<Movie> moviesList;

    public Bus bus;
    public static final String TAG = "Debug_movies_click";


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }


    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);

        bus = new Bus();
        bus.register(this);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Клик по айтему");
                Toast.makeText(view.getContext(), "Clicked", Toast.LENGTH_SHORT).show();

                sendBus();
                Log.d(TAG, "Вызов метода sendBus()");
            }
        });
        holder.title.setText(movie.getTitle());
    }


    public void sendBus(){
        Log.d(TAG, "Bus.post() <- Автобус поехал");
        bus.post(new MainActivity());
    }

    @Subscribe
    public void changeFragment(MainActivity activity){

        Log.d(TAG, "Стартовала функция замены фрагмента");

        FragmentManager fragmentManager = activity.getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        Log.d(TAG, "Начинаю выполнять метод replace()");
        ft.replace(R.id.frag_container, new ProfileFragment());
        Log.d(TAG, "Закончил выполнять метод replace()");

        Log.d(TAG, "commit -> Начало");
        ft.commit(); // ВЫЛЕТ ТУТ
        Log.d(TAG, "commit -> Конец");

        Log.d(TAG, "Конец замены фрагмента");
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}