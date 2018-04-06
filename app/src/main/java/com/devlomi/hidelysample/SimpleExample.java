package com.devlomi.hidelysample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.devlomi.hidely.HidelyAnimationCallbacks;
import com.devlomi.hidely.hidelyviews.HidelyImageButton;


public class SimpleExample extends AppCompatActivity {
    private HidelyImageButton hidelyImageButton;
    private Button changeButtonState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_example);
        hidelyImageButton = findViewById(R.id.simple_example_hidely);
        changeButtonState = findViewById(R.id.change_button_state);

        changeButtonState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hidelyImageButton.isShowing())
                    hidelyImageButton.hide();
                else
                    hidelyImageButton.show();
            }
        });

        hidelyImageButton.setAnimationCallbacks(new HidelyAnimationCallbacks() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {

            }
        });
    }
}
