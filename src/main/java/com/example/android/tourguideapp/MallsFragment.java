package com.example.android.tourguideapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_list, container, false);

        cards = new ArrayList<>();
        //25.4099934 , 55.4372015
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

        return viewGroup;
    }
}
