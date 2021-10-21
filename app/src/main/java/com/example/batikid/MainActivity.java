package com.example.molyst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.molyst.api.MovieModel;
import com.example.molyst.api.ResultsItem;
import com.example.molyst.source.ApiConfig;
import com.example.molyst.source.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {

    private RecyclerView scroll;
    private ArrayList<ResultsItem> resultsItems;
    private Molyst molyst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
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
                            scroll.setAdapter(molyst);
                            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                            llm.setOrientation(LinearLayoutManager.HORIZONTAL);
                            scroll.setLayoutManager(llm);
                            }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {

                    }
                });
    }

    private void initView() {
        scroll = findViewById(R.id.scroll);
    }
}