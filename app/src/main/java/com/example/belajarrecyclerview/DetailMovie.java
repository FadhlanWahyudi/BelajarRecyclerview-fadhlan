package com.example.belajarrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DetailMovie extends AppCompatActivity {

    public static final String KEY_MOVIE = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
getSupportActionBar().setDisplayShowHomeEnabled(true);
        String idDetail = getIntent().getStringExtra(KEY_MOVIE);

        Toast.makeText(this, idDetail, Toast.LENGTH_SHORT).show();
    }
}
