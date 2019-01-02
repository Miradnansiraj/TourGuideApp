package com.example.android.tourguideapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguideapp.Card;
import com.example.android.tourguideapp.R;

import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter<Card>
{
    public CardAdapter(Context context, ArrayList<Card> words)
    {
        super(context, 0, words);
    }

    static class ViewHolder
    {
        private ImageView imageView, imageButton;
        private TextView title, subtitle, extra1, extra2;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.card_item, parent, false);
            holder = new ViewHolder();
            holder.imageButton = convertView.findViewById(R.id.map_button);
            holder.imageView = convertView.findViewById(R.id.card_image);
            holder.title = convertView.findViewById(R.id.title_string);
            holder.subtitle = convertView.findViewById(R.id.subtitle_string);
            holder.extra1 = convertView.findViewById(R.id.extra_one);
            holder.extra2 = convertView.findViewById(R.id.extra_two);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Card currentCard = getItem(position);

        holder.imageButton.setImageResource(R.drawable.twotone_location_on_24);
        if(currentCard.hasImage())
            holder.imageView.setImageResource(currentCard.getImageResID());
        else
            holder.imageView.setImageResource(R.drawable.baseline_photo_24);

        holder.title.setText(currentCard.getTitle());
        holder.subtitle.setText(currentCard.getSubtitle());
        holder.extra1.setText(currentCard.getExtra1());
        holder.extra2.setText(currentCard.getExtra2());
        return convertView;
    }
}
