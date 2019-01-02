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
    private CardAdapter cardAdapter;
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
        cards.add(new Card("Ajman City Centre", "Al Jurf - Al Ittihad St", "Closes 11:30 AM",
                "4.2/5",R.drawable.ccajman, Uri.parse("geo:0,0?q=City+Centre+Ajman")));
        cards.add(new Card("Mir\'s House", "Al Karama", "Open 24 hours",
                                            "5/5", Uri.parse("geo:25.4099934,55.4372015")));
        cards.add(new Card("Mir\'s House", "Al Karama", "Open 24 hours",
                "5/5", Uri.parse("geo:25.4099934,55.4372015")));
        cards.add(new Card("Mir\'s House", "Al Karama", "Open 24 hours",
                "5/5", Uri.parse("geo:25.4099934,55.4372015")));
        cards.add(new Card("Mir\'s House", "Al Karama", "Open 24 hours",
                "5/5", Uri.parse("geo:25.4099934,55.4372015")));
        cards.add(new Card("Mir\'s House", "Al Karama", "Open 24 hours",
                "5/5", Uri.parse("geo:25.4099934,55.4372015")));
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
