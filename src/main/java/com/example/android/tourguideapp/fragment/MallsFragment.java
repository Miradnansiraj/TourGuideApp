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

public class MallsFragment extends Fragment
{
    private ArrayList<Card> cards;
    public MallsFragment() {}

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
        cards.add(new Card(getString(R.string.acc), getString(R.string.acc_location), getString(R.string.acc_timing),
                getString(R.string.acc_rating),R.drawable.ccajman, Uri.parse(getString(R.string.acc_map_location))));
        cards.add(new Card(getString(R.string.lulu), getString(R.string.lulu_location), getString(R.string.lulu_timing),
                                            getString(R.string.lulu_rating),R.drawable.luluajman, Uri.parse(getString(R.string.lulu_map_location))));
        cards.add(new Card(getString(R.string.nesto), getString(R.string.nesto_location), getString(R.string.nesto_timing),
                getString(R.string.nesto_rating),R.drawable.nestoajman, Uri.parse(getString(R.string.nesto_map_location))));
        cards.add(new Card(getString(R.string.safeer), getString(R.string.safeer_location), getString(R.string.safeer_timing),
                getString(R.string.safeer_rating),R.drawable.safeerajman, Uri.parse(getString(R.string.safeer_map_location))));
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
