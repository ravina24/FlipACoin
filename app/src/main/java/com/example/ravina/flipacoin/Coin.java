package com.example.ravina.flipacoin;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
        flipButton.setBackgroundColor(Color.DKGRAY);
//        Typeface customFont = Typeface.createFromAsset(getAssets(), "Fonts/cooper.ttf");
//        flipButton.setTypeface(customFont);


        // on button clicked
        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coinSide = random.nextInt(2);

                if(coinSide == 0) {
                    coinIV.setImageResource(R.drawable.heads);

                    //toast
                    Toast toast = Toast.makeText(Coin.this, "Heads!", Toast.LENGTH_SHORT);
                    toast.setMargin(0, -1);
                    toast.show();
                } else {
                    coinIV.setImageResource(R.drawable.tails);

                    //toast
                    Toast toast = Toast.makeText(Coin.this, "Tails!", Toast.LENGTH_SHORT);
                    toast.setMargin(0, -1);
                    toast.show();
                }


                RotateAnimation rotate = new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                rotate.setDuration(1000);
                coinIV.startAnimation(rotate);

            }
        });

    }
}
