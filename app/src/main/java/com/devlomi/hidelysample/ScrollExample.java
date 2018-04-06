package com.devlomi.hidelysample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.devlomi.hidely.hidelyviews.HidelyImageButton;


public class ScrollExample extends AppCompatActivity {
    private RecyclerView rv;
    HidelyImageButton btnScroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_example);
        rv = findViewById(R.id.rv);
        btnScroll = findViewById(R.id.btn_scroll);

        getSupportActionBar().setTitle("Scrooooll..");

        final String[] dummy = {"The sky", "above", "the port", "was",
                "the color of television", "tuned", "to", "a dead channel",
                ".", "All", "this happened", "more or less", ".", "I", "had",
                "the story", "bit by bit", "from various people", "and", "as generally",
                "happens", "in such cases", "each time", "it", "was", "a different story",
                ".", "It", "was", "a pleasure", "to", "burn"};

        ScrollAdapter adapter = new ScrollAdapter(dummy);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //detect when user stops scrolling
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {


                    //only show it when it is hidden
                    if (!btnScroll.isShowing())
                        btnScroll.show();

                } else {

                    btnScroll.hide();


                }
            }
        });

        rv.setAdapter(adapter);


        btnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rv.smoothScrollToPosition(dummy.length - 1);
            }
        });
    }
}
