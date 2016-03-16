package com.example.vij.jsonparse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleItemView extends AppCompatActivity implements View.OnClickListener{

    int counter;
    Button inc, dec;
    TextView result;

    // Declare Variables
    String pid;
    String name;
    String price;
    //String flag;
    String position;
    //ImageLoader imageLoader = new ImageLoader(this);

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
                Intent fabtoorder=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(fabtoorder);
            }
        });
        Intent inte = getIntent();
        // Get the result of rank
        pid = inte.getStringExtra("pid");
        // Get the result of country
        name = inte.getStringExtra("name");
        // Get the result of population
        price = inte.getStringExtra("price");
        // Get the result of flag
        //flag = inte.getStringExtra("flag");

        // Locate the TextViews in singleitemview.xml
        TextView txtpid = (TextView) findViewById(R.id.pid);
        TextView txtname = (TextView) findViewById(R.id.name);
        TextView txtprice = (TextView) findViewById(R.id.price);

        // Locate the ImageView in singleitemview.xml
        //ImageView imgflag = (ImageView) findViewById(R.id.flag);

        // Set results to the TextViews
        txtpid.setText(pid);
        txtname.setText(name);
        txtprice.setText(price);

        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        //imageLoader.DisplayImage(flag, imgflag);

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
