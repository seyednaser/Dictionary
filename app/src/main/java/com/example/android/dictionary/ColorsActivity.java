package com.example.android.dictionary;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends Activity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Black", "سیاه", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("White", "سفید", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("Red", "قرمز", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Green", "سبز", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Brown", "قهوه ای", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Yellow", "زرد", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Grey", "طوسی", R.drawable.color_gray, R.raw.color_gray));

/*
        WordAdapter itemAdapter = new WordAdapter(
                this,
                words,
                R.color.category_numbers
        );
*/
        WordAdapter itemAdapter = new WordAdapter(
                this,
                words,
                R.color.category_colors
        );

        ListView rootView = findViewById(R.id.word_list);

        rootView.setAdapter(itemAdapter);

        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word w = words.get(i);

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, w.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });

    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null){

            mMediaPlayer.reset();
            mMediaPlayer = null;
        }
    }
}
