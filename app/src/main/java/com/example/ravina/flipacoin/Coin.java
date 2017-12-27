package com.example.ravina.flipacoin;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class Coin extends AppCompatActivity {

    Button flipButton;
    ImageView coinIV;
    Random random;
    int coinSide; // 0 is for heads, 1 is for tails

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        // initialize fields
        flipButton = (Button) findViewById(R.id.flipButton);
        coinIV = (ImageView) findViewById(R.id.coinIV);
        random = new Random();

        // button aesthetics
        flipButton.setBackgroundColor(Color.BLACK);
//        Typeface customFont = Typeface.createFromAsset(getAssets(), "Fonts/cooper.ttf");
//        flipButton.setTypeface(customFont);


        // on button clicked
        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coinSide = random.nextInt(2);

                if(coinSide == 0) {
                    coinIV.setImageResource(R.drawable.heads);
                } else {
                    coinIV.setImageResource(R.drawable.tails);
                }

            }
        });

    }
}
