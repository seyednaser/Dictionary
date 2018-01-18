package com.example.android.dictionary;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends Activity {
    MediaPlayer mMediaPlayer;

//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this, "Stoped!", Toast.LENGTH_SHORT).show();
//        releaseMediaPlayer();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("OnCreat: ", "Created!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("One", "یک", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "دو", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "سه", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "چهار", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "پنج", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "شش", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "هفت", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "هشت", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "نه", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "ده", R.drawable.number_ten, R.raw.number_ten));

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
                R.color.category_numbers
        );

        ListView rootView = findViewById(R.id.word_list);

        rootView.setAdapter(itemAdapter);

        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word w = words.get(i);

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,
                        w.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });

//                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, R.raw.phrase_where_are_you_going);
//                mMediaPlayer.start();
//                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mediaPlayer) {
//                        releaseMediaPlayer();
//                    }
//                });
//
//                Word w = words.get(i);
            }
        });

        rootView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(NumbersActivity.this, "Long Click!", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        releaseMediaPlayer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("OnResume", "Resumed!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("OnPause", "Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("OnStop", "Stopped!");
    }

    private void releaseMediaPlayer() {
        if (mMediaPlayer != null) {

            //We release the resources so that the android can reuse them
            //for other apps when needed.
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}
