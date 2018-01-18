package com.example.android.dictionary;

/**
 * Created by seyednaser on 05/01/2018.
 */

public class Word    {



    private String mDefaultTranslation;
    private String mPersianTranslation;

    private int mImageResourceId;// = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

//    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     *
     * @param defaultTranslation
     * @param persianTranslation
     * @param audioResourceId
     */

    public Word(String defaultTranslation, String persianTranslation, int audioResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mPersianTranslation = persianTranslation;
        this.mAudioResourceId = audioResourceId;
    }

    /**
     *
     * @param defaultTranslation
     * @param persianTranslation
     * @param imageResourceId
     * @param audioResourceId
     */

    public Word(String defaultTranslation, String persianTranslation, int imageResourceId,
                int audioResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mPersianTranslation = persianTranslation;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = audioResourceId;
    }

//    public boolean hasImage(){
//        return mImageResourceId != NO_IMAGE_PROVIDED;
//    }
    /**
     *
     * @return
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     *
     * @return
     */

    public String getPersianTranslation() {
        return mPersianTranslation;
    }

    /**
     *
     * @return
     */

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }
}
