package com.example.android.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter<Card>
{
    public CardAdapter(Context context, ArrayList<Card> words)
    {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.card_item, parent, false);
        }

        Card currentCard = getItem(position);

        ImageView imageButton = listItemView.findViewById(R.id.map_button);
        imageButton.setImageResource(R.drawable.round_location_on_black_48dp);

        ImageView imageView = listItemView.findViewById(R.id.card_image);
        imageView.setImageResource(R.drawable.round_location_on_black_48dp);

        TextView title, subtitle, extra1, extra2;

        title = listItemView.findViewById(R.id.title_string);
        title.setText(currentCard.getTitle());
        subtitle = listItemView.findViewById(R.id.subtitle_string);
        subtitle.setText(currentCard.getSubtitle());
        extra1 = listItemView.findViewById(R.id.extra_one);
        extra1.setText(currentCard.getExtra1());
        extra2 = listItemView.findViewById(R.id.extra_two);
        extra2.setText(currentCard.getExtra2());
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
