package com.devlomi.hidelysample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button gotoExample1, gotoExample2,gotoExample3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoExample1 = findViewById(R.id.goto_example1);
        gotoExample2 = findViewById(R.id.goto_example2);
        gotoExample3 = findViewById(R.id.goto_example3);

        gotoExample1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScrollExample.class));
            }
        });

        gotoExample2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ChooseExample.class));
            }
        });

        gotoExample3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SimpleExample.class));
            }
        });


    }
}
