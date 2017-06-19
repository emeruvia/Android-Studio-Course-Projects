package com.example.sumringah.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view){
        ImageView homer = (ImageView) findViewById(R.id.homer);
        //ImageView bart = (ImageView) findViewById(R.id.bart);
        homer.animate().translationXBy(1000f)
                        .translationYBy(1000f)
                        .rotation(1800f)
                        .setDuration(2000);


        //bart.animate().alpha(1f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView homer = (ImageView) findViewById(R.id.homer);

        homer.setTranslationX(-1000f);
        homer.setTranslationY(-1000f);
    }
}
