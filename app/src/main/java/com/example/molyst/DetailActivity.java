package com.example.molyst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

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
    }
}