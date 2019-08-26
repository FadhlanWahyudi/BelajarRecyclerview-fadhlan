package com.example.belajarrecyclerview;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvmain;
    private MovieAdapter movieAdapter;
    Toolbar toolbar;

    ArrayList<ModelMovie> arrayList;

    private  String[] id        = {"1001","1002","1003"};
    private  String[] judul     = {"Seribu satu orang hebat","Temukan jati diri di sini","siapa saya ini"};
    private  String[] subjudul  = {"orang Hevat","Pejuang Dakwah","Petani Kodok"};
    private  int[]    gambar    = {R.drawable.tv,R.drawable.tv,R.drawable.tv};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolar);
        setSupportActionBar(toolbar);
        arrayList = new ArrayList<>();
        rvmain = findViewById(R.id.rvmain);
        setData();
        movieAdapter = new MovieAdapter(arrayList);
        rvmain.setAdapter(movieAdapter);
        rvmain.setLayoutManager(new LinearLayoutManager(this));
        rvmain.setAdapter(movieAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        search(searchView);

        return true;
    }

    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (movieAdapter != null)movieAdapter.getFilter().filter(s);
                return true;
            }
        });
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.changelanguage:
            Intent i = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(i);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void setData () {
        int count = 0;
        for (String id: id)
        arrayList.add(new ModelMovie(id, judul[count],subjudul[count],gambar[count]));
        count++;
    }
}
