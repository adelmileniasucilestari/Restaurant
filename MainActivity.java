package com.example.molyst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> title = new LinkedList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=1; i<=5; i++) {
            title.add("Judul " + i);
        }

        recyclerView = findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        Molyst molystadapter = new Molyst(this, title);
        recyclerView.setAdapter(molystadapter);
    }

    public void Lihat(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}