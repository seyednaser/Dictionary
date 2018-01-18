package com.example.android.dictionary;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seyednaser on 06/01/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

/*
    //A new member to use as a resource id
    private int mColorResourceId;
*/


    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }
/*
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }
*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView persianTextView = listItemView.findViewById(R.id.persian_text_view);
        persianTextView.setText(currentWord.getPersianTranslation());

        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = listItemView.findViewById(R.id.image);
//        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
//            imageView.setVisibility(View.VISIBLE );

//        } else {
//            imageView.setVisibility(View.GONE);
//        }

        /**
         * Return a specified view to the calling method
         */

/*      //set the backgroung color of any category
        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = getContext().getColor(mColorResourceId);
        textContainer.setBackgroundColor(color);
*/

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = getContext().getColor(mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
