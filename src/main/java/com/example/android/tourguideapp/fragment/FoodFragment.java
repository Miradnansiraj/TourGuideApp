package com.example.android.tourguideapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.android.tourguideapp.Card;
import com.example.android.tourguideapp.R;
import com.example.android.tourguideapp.adapter.CardAdapter;

import java.util.ArrayList;

public class FoodFragment extends Fragment
{
    private ArrayList<Card> cards;
    public FoodFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View viewGroup = inflater.inflate(R.layout.activity_list, container, false);
        cards = new ArrayList<>();
        //map: geo:latitude,longitude?z=zoom
        //place: geo:latitude,longitude?q=query
        //      or geo:0,0?q=latitude,longitude(label)
        //          or geo:0,0?q=label
        cards.add(new Card(getString(R.string.kfc), getString(R.string.kfc_location), getString(R.string.kfc_timing),
                getString(R.string.kfc_rating),R.drawable.kfc, Uri.parse(getString(R.string.kfc_map_location))));
        cards.add(new Card(getString(R.string.pizza), getString(R.string.pizza_location), getString(R.string.pizza_timing),
                getString(R.string.pizza_rating),R.drawable.pizzahut, Uri.parse(getString(R.string.pizza_map_location))));
        cards.add(new Card(getString(R.string.hardees), getString(R.string.hardees_location), getString(R.string.hardees_timing),
                getString(R.string.hardees_rating),R.drawable.hardees, Uri.parse(getString(R.string.hardees_map_location))));
        cards.add(new Card(getString(R.string.caribou), getString(R.string.caribou_location), getString(R.string.caribou_timing),
                getString(R.string.caribou_rating),R.drawable.caribou, Uri.parse(getString(R.string.caribou_map_location))));
        cards.add(new Card(getString(R.string.kd), getString(R.string.kd_location), getString(R.string.kd_timing),
                getString(R.string.kd_rating),R.drawable.karachi, Uri.parse(getString(R.string.kd_map_location))));
        cards.add(new Card(getString(R.string.mc), getString(R.string.mc_location), getString(R.string.mc_timing),
                getString(R.string.mc_rating),R.drawable.mcdonald, Uri.parse(getString(R.string.mc_map_location))));
        CardAdapter cardAdapter = new CardAdapter(getActivity(), cards);
        ListView listView = viewGroup.findViewById(R.id.list_view);
        listView.setAdapter(cardAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, cards.get(i).getUri());
                mapIntent.setPackage(getString(R.string.map_intent));
                startActivity(mapIntent);
            }
        });
        return viewGroup;
    }
}
