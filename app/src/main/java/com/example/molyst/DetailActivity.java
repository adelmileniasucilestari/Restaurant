package com.example.molyst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.molyst.api.MovieModel;
import com.example.molyst.api.ResultsItem;
import com.example.molyst.source.ApiConfig;
import com.example.molyst.source.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView scroll2;
    private ArrayList<ResultsItem> resultsItems;
    private Molyst molyst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        scroll2 = findViewById(R.id.scroll2);
        ImageView backdrop = findViewById(R.id.poster);
        TextView judul = findViewById(R.id.title2);
        TextView genre = findViewById(R.id.genre);
        TextView rate = findViewById(R.id.rate);
        TextView date = findViewById(R.id.date);
        TextView lang = findViewById(R.id.language);
        TextView overview = findViewById(R.id.overview);

        Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w200"
                +getIntent().getStringExtra("backdrop")).into(backdrop);
        judul.setText(getIntent().getStringExtra("judul"));

        if(getIntent().getIntegerArrayListExtra("genre").contains(28)) {
            genre.append("[Action]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(878)) {
            genre.append("[Science Fiction]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(12)) {
            genre.append("[Adventure]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(18)) {
            genre.append("[Drama]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(27)) {
            genre.append("[Horror]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(53)) {
            genre.append("[Thriller]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(35)) {
            genre.append("[Comedy]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(80)) {
            genre.append("[Crime]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(16)) {
            genre.append("[Animation]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(10751)) {
            genre.append("[Family]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(14)) {
            genre.append("[Fantasy]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(16)) {
            genre.append("[Fantasy]");
        }
        if (getIntent().getIntegerArrayListExtra("genre").contains(10402)) {
            genre.append("[Music]");
        }

        rate.setText(getIntent().getStringExtra("rate")+" / 10");
        date.setText(getIntent().getStringExtra("date"));
        lang.setText(getIntent().getStringExtra("lang"));
        overview.setText(getIntent().getStringExtra("overview"));

        resultsItems = new ArrayList<>();
        getData();
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData()
                .enqueue(new Callback<MovieModel>() {
                    @Override
                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        if (response.isSuccessful()){
                            resultsItems = response.body().getResults();
                            molyst = new Molyst(resultsItems, getApplicationContext());
                            molyst.notifyDataSetChanged();
                            scroll2.setAdapter(molyst);
                            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                            llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                            scroll2.setLayoutManager(llm);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {

                    }
                });
    }
}