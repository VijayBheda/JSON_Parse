package com.example.vij.jsonparse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends AppCompatActivity implements View.OnClickListener{

    int counter;
    Button inc, dec;
    TextView result;

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
        Intent inte = getIntent();
        // Get the result of rank
        rank = inte.getStringExtra("rank");
        // Get the result of country
        country = inte.getStringExtra("country");
        // Get the result of population
        population = inte.getStringExtra("population");
        // Get the result of flag
        flag = inte.getStringExtra("flag");

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

        counter = 0;
        inc =(Button)findViewById(R.id.inc);
        dec = (Button)findViewById(R.id.dec);

        result = (TextView)findViewById(R.id.result);
        inc.setOnClickListener(this);
        dec.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        boolean showText = false;

        switch(v.getId())
        {
            case R.id.inc:
                counter++;
                showText = true;
                break;
            case R.id.dec:
                counter--;
                showText = true;
                break;

        }
        if (showText)
            result.setText("Q :"+ counter);
    }
}
