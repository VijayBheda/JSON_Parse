package com.example.vij.jsonparse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends AppCompatActivity {

    // Declare Variables
    String rank;
    String country;
    String population;
    String flag;
    String position;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent i = getIntent();
        // Get the result of rank
        rank = i.getStringExtra("rank");
        // Get the result of country
        country = i.getStringExtra("country");
        // Get the result of population
        population = i.getStringExtra("population");
        // Get the result of flag
        flag = i.getStringExtra("flag");

        // Locate the TextViews in singleitemview.xml
        TextView txtrank = (TextView) findViewById(R.id.rank);
        TextView txtcountry = (TextView) findViewById(R.id.country);
        TextView txtpopulation = (TextView) findViewById(R.id.population);

        // Locate the ImageView in singleitemview.xml
        ImageView imgflag = (ImageView) findViewById(R.id.flag);

        // Set results to the TextViews
        txtrank.setText(rank);
        txtcountry.setText(country);
        txtpopulation.setText(population);

        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(flag, imgflag);

    }

}
