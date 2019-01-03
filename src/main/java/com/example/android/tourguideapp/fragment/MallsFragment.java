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
        cards.add(new Card("Ajman City Centre", "Al Jurf - Al Ittihad St", "Closes 11:30am",
                "4.2",R.drawable.ccajman, Uri.parse("geo:0,0?q=City+Centre+Ajman")));
        cards.add(new Card("LuLu Hypermarket", "Al Karama", "Closes at 12am",
                                            "4",R.drawable.luluajman, Uri.parse("geo:0,0?q=LuLu+Hypermarket,+Ajman")));
        cards.add(new Card("Nesto Hypermarket", "Ittehad street", "Closes at 12am",
                "4.1",R.drawable.nestoajman, Uri.parse("geo:0,0?q=Nesto+Hypermarket,+Mushrif")));
        cards.add(new Card("Safeer Mall", "Al Nuaimia", "Closes 12am",
                "3.9",R.drawable.safeerajman, Uri.parse("geo:0,0?q=Safeer+Mall+Ajman")));
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
