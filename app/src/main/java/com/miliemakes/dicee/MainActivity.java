package com.miliemakes.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonRoll;
    ImageView imageLeftDice;
    ImageView imageRightDice;
    int num;
    int num2;
    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLeftDice = findViewById(R.id.imageLeftDice);
        imageRightDice = findViewById(R.id.imageRightDice);
        imageLeftDice.setVisibility(View.INVISIBLE);
        imageRightDice.setVisibility(View.INVISIBLE);
        buttonRoll = findViewById(R.id.buttonRoll);
        final int[] diceArray = {R.drawable.nebula1dice,
                R.drawable.nebula2dice,
                R.drawable.nebula3dice,
                R.drawable.nebula4dice,
                R.drawable.nebula5dice,
                R.drawable.nebula6dice
        };

        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageLeftDice.setVisibility(View.VISIBLE);
                imageRightDice.setVisibility(View.VISIBLE);
                Random randomNumGen = new Random();
                num = randomNumGen.nextInt(6);
                Log.d("Dicee", "Number:" + num);
                imageLeftDice.setImageResource(diceArray[num]);
                num2 = randomNumGen.nextInt(6);
                imageRightDice.setImageResource(diceArray[num2]);
                sum = num + num2 + 2;
                Toast.makeText(MainActivity.this, "You rolled " + sum, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
