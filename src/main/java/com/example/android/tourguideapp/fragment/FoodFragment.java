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
    private CardAdapter cardAdapter;
    public FoodFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View viewGroup = inflater.inflate(R.layout.activity_list, container, false);

        cards = new ArrayList<>();
        //25.4099934 , 55.4372015
        cards.add(new Card("KFC", "Ajman Beach", "Closes at 2am",
                "3.8",R.drawable.kfc, Uri.parse("geo:0,0?q=KFC+Ajman+Corniche")));
        cards.add(new Card("Pizza Hut", "Ajman Beach", "Closes at 2am",
                "3.9",R.drawable.pizzahut, Uri.parse("geo:0,0?q=Pizza+Hut+Ajman+Corniche")));
        cards.add(new Card("Hardee\'s", "Ajman Beach", "Closes at 2am",
                "3.8",R.drawable.hardees, Uri.parse("geo:0,0?q=Hardee's")));
        cards.add(new Card("KFC", "Ajman Beach", "Closes at 2am",
                "3.8",R.drawable.kfc, Uri.parse("geo:0,0?q=KFC+Ajman+Corniche")));
        cards.add(new Card("KFC", "Ajman Beach", "Closes at 2am",
                "3.8",R.drawable.kfc, Uri.parse("geo:0,0?q=KFC+Ajman+Corniche")));
        cards.add(new Card("KFC", "Ajman Beach", "Closes at 2am",
                "3.8",R.drawable.kfc, Uri.parse("geo:0,0?q=KFC+Ajman+Corniche")));
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
