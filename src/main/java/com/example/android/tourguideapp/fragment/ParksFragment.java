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

public class ParksFragment extends Fragment
{
    private ArrayList<Card> cards;
    public ParksFragment() {}

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
        cards.add(new Card(getString(R.string.ladiespark), getString(R.string.ladiespark_location), getString(R.string.ladiespard_timing),
                getString(R.string.ladiespark_rating),R.drawable.ladiespark, Uri.parse(getString(R.string.ladiespark_map_location))));
        cards.add(new Card(getString(R.string.fp), getString(R.string.fp_location), getString(R.string.fp_timing),
                getString(R.string.fp_rating),R.drawable.jurfparkajman, Uri.parse(getString(R.string.fp_map_location))));
        cards.add(new Card(getString(R.string.helio), getString(R.string.helio_location), getString(R.string.helio_timing),
                getString(R.string.helio_rating),R.drawable.heliopark, Uri.parse(getString(R.string.helio_map_location))));
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