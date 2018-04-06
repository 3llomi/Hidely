package com.devlomi.hidelysample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.devlomi.hidely.hidelyviews.HidelyImageView;

import java.util.ArrayList;
import java.util.List;

public class ChooseExample extends AppCompatActivity {


    private RecyclerView rvChoose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_example);

        getSupportActionBar().setTitle("Choose Contacts");
        rvChoose = findViewById(R.id.rv_choose);
        List<String> users = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            users.add("User " + (i + 1));
        }


        ChooseAdapter adapter = new ChooseAdapter(users, new ChooseAdapter.OnItemClick() {
            @Override
            public void onClick(View view) {
                if (view instanceof HidelyImageView) {
                    HidelyImageView hidelyView = (HidelyImageView) view;


                    if (hidelyView.isShowing()) {
                        hidelyView.hide();
                    } else {
                        hidelyView.show();
                    }
                }
            }
        });




        rvChoose.setLayoutManager(new LinearLayoutManager(this));
        rvChoose.setAdapter(adapter);

    }
}
