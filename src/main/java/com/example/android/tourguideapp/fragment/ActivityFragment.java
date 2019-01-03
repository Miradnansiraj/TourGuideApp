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
    private CardAdapter cardAdapter;
    public ActivityFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View viewGroup = inflater.inflate(R.layout.activity_list, container, false);

        cards = new ArrayList<>();
        //25.4099934 , 55.4372015
        cards.add(new Card("Aqua Park Ajman", "Ajman Beach", "Closes at 8pm",
                "2.6",R.drawable.aquapark, Uri.parse("geo:0,0?q=Aqua+Bounce+Ajman")));
        cards.add(new Card("HOLIDAY BEACH CLUB", "Ajman Beach", "Closes at 2am",
                "3.7",R.drawable.hbclub, Uri.parse("geo:0,0?q=HOLIDAY+BEACH+CLUB,+Ajman")));
        cards.add(new Card("Body and Soul Spa", "villa 8 16th street Rumeilah 2", "Closes at 12am",
                "3.7",R.drawable.bodysoul, Uri.parse("geo:0,0?q=Body+and+Soul+Elite+Health+Club+and+SPA")));
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