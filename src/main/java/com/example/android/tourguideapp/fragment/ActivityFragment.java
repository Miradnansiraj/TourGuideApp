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

public class ActivityFragment extends Fragment
{
    private ArrayList<Card> cards;
    public ActivityFragment() {}

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
        cards.add(new Card(getString(R.string.apajman), getString(R.string.apajman_location), getString(R.string.apajman_timing),
                getString(R.string.apajman_rating),R.drawable.aquapark, Uri.parse(getString(R.string.apajman_map_location))));
        cards.add(new Card(getString(R.string.hbc), getString(R.string.hbc_location), getString(R.string.hbc_timing),
                getString(R.string.hbc_rating),R.drawable.hbclub, Uri.parse(getString(R.string.hbc_map_location))));
        cards.add(new Card(getString(R.string.bodysoul), getString(R.string.bodysoul_location), getString(R.string.bodysoul_timing),
                getString(R.string.bodysoul_rating),R.drawable.bodysoul, Uri.parse(getString(R.string.bodysoul_map_location))));
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