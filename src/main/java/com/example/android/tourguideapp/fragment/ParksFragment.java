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
    private CardAdapter cardAdapter;
    public ParksFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View viewGroup = inflater.inflate(R.layout.activity_list, container, false);

        cards = new ArrayList<>();
        //25.4099934 , 55.4372015
        cards.add(new Card("Ladies Park", "Al Rashidiya", "Closes at 12am",
                "3.7",R.drawable.ladiespark, Uri.parse("geo:0,0?q=Rashidiya+Park+for+families+and+children")));
        cards.add(new Card("Family Park", "Al Jurf", "Closes at 8pm",
                "3.8",R.drawable.jurfparkajman, Uri.parse("geo:0,0?q=Al+Jurf+Family+Park")));
        cards.add(new Card("Helio Park", "Helio", "Closes at 8pm",
                "3.8",R.drawable.heliopark, Uri.parse("geo:0,0?q=Helio+Park")));
        cardAdapter = new CardAdapter(getActivity(), cards);
        ListView listView = viewGroup.findViewById(R.id.list_view);
        listView.setAdapter(cardAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, cards.get(i).getUri());
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        return viewGroup;
    }
}