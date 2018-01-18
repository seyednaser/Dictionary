package com.example.android.dictionary;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends Activity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("How are you feeling?", "چه احساسی داری؟", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "حس خوبی دارم.", R.raw.phrase_im_feeling_good));
        words.add(new Word("What's your name?", "اسمت چیه؟", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is", "اسمم هست", R.raw.phrase_my_name_is));
        words.add(new Word("Where are you going?", "کجا داری میری؟", R.raw.phrase_where_are_you_going));
        words.add(new Word("Let's go.", "بزن بریم.", R.raw.phrase_lets_go));
        words.add(new Word("Are you coming?", "داری میای؟", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes I'm coming.", "بله دارم میام.", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.", "دارم میام.", R.raw.phrase_im_coming));
        words.add(new Word("Come here.", "بیا اینجا.", R.raw.phrase_come_here));

        WordAdapter itemAdapter = new WordAdapter(
                this,
                words,
                R.color.category_phrases
        );
//        WordAdapter itemAdapter = new WordAdapter(
//                this,
//                words,
//                R.color.category_phrases
//        );

        ListView rootView = findViewById(R.id.word_list);

        rootView.setAdapter(itemAdapter );
        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word w = words.get(i);

                mMediaPlayer = MediaPlayer.create( PhrasesActivity.this,
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
