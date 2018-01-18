package com.example.android.dictionary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    int color;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onItemsClicked(View v) {
        Intent intent;
        switch (v.getId()){

            case R.id.numbers:
                 intent = new Intent(this, NumbersActivity.class);
                 startActivity(intent);
                 break;

            case R.id.alphabet:
                intent = new Intent(this, AlphabetActivity.class);
                startActivity(intent);
                break;

            case R.id.colors:
                intent = new Intent(this, ColorsActivity.class);
                startActivity(intent);
                break;

            case R.id.phrases:
                intent = new Intent(this, PhrasesActivity.class);
                startActivity(intent);
                break;
        }
    }
}
