package com.example.android.dictionary;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlphabetActivity extends Activity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("A", "ای", R.raw.number_one));
        words.add(new Word("B", "بی", R.raw.number_two));
        words.add(new Word("C", "سی", R.raw.number_three));
        words.add(new Word("D", "دی", R.raw.number_four));
        words.add(new Word("E", "ای", R.raw.number_five));
        words.add(new Word("F", "اف", R.raw.number_six));
        words.add(new Word("G", "جی", R.raw.number_seven));
        words.add(new Word("H", "اچ", R.raw.number_eight));
        words.add(new Word("I", "آی", R.raw.number_nine));
        words.add(new Word("J", "جی", R.raw.number_ten));
        words.add(new Word("K", "کی", R.raw.number_ten));
        words.add(new Word("L", "ال", R.raw.number_ten));
        words.add(new Word("M", "ام", R.raw.number_ten));
        words.add(new Word("N", "ان", R.raw.number_ten));
        words.add(new Word("O", "اً", R.raw.number_ten));
        words.add(new Word("P", "پی", R.raw.number_ten));
        words.add(new Word("Q", "کیو", R.raw.number_ten));
        words.add(new Word("R", "آر", R.raw.number_ten));
        words.add(new Word("S", "اس", R.raw.number_ten));
        words.add(new Word("T", "تی", R.raw.number_ten));
        words.add(new Word("U", "یو", R.raw.number_ten));
        words.add(new Word("V", "وی", R.raw.number_ten));
        words.add(new Word("W", "دبلیو", R.raw.number_ten));
        words.add(new Word("X", "ایکس", R.raw.number_ten));
        words.add(new Word("Y", "وای", R.raw.number_ten));
        words.add(new Word("Z", "زد", R.raw.number_ten));

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
                R.color.category_alphabet
        );

        ListView rootView = findViewById(R.id.word_list);

        rootView.setAdapter(itemAdapter);

        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word w = words.get(i);

                mMediaPlayer = MediaPlayer.create(AlphabetActivity.this,
                        w.getAudioResourceId());
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
