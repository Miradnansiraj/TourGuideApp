package com.example.android.tourguideapp;


import android.net.Uri;

public class Card
{
    //Main title of the card
    private String title;
    //subtitle
    private String subtitle;
    //extra info's here
    private String extra1, extra2;
    //image resource ID
    private int imageResID;
    //Uri for the location of card item
    private Uri uri;

    //Identifier
    private final int NOIMAGE = 1;

    //Constructors


    public Card(String title, String subtitle, Uri uri) {
        this.title = title;
        this.subtitle = subtitle;
        this.uri = uri;
        imageResID = NOIMAGE;
    }

    public Card(String title, String subtitle, String extra1, Uri uri) {
        this.title = title;
        this.subtitle = subtitle;
        this.extra1 = extra1;
        this.uri = uri;
        imageResID = NOIMAGE;
    }

    public Card(String title, String subtitle, String extra1, String extra2, Uri uri) {
        this.title = title;
        this.subtitle = subtitle;
        this.extra1 = extra1;
        this.extra2 = extra2;
        this.uri = uri;
        imageResID = NOIMAGE;
    }

    public Card(String title, String subtitle, String extra1, String extra2, int imageResID, Uri uri) {
        this.title = title;
        this.subtitle = subtitle;
        this.extra1 = extra1;
        this.extra2 = extra2;
        this.imageResID = imageResID;
        this.uri = uri;
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getExtra1() {
        return extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public int getImageResID() {
        return imageResID;
    }

    public Uri getUri() {
        return uri;
    }

    //Code to check if card has image
    public boolean hasImage()
    {
        return imageResID!=NOIMAGE;
    }

    @Override
    public String toString() {
        return "Card{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", extra1='" + extra1 + '\'' +
                ", extra2='" + extra2 + '\'' +
                ", imageResID=" + imageResID +
                ", uri=" + uri +
                ", NOIMAGE=" + NOIMAGE +
                '}';
    }
}
