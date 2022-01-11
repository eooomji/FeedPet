package com.example.firsttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<SingleItem> items;
    ListView customListView;
    private static CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        items = new ArrayList<SingleItem>();
        items.add(new SingleItem("막내", "11개월", "https://post-phinf.pstatic.net/MjAyMDA5MDFfMTg3/MDAxNTk4OTU0Mjg3ODY1.ScDj1g1gboyqfcQbp6NuBuT0iDBu2Pg_XnMz2UhFAcwg.jOo08-HSOT_iyTw7JE04-qao1J6MNEQbW9f6IQK7emgg.JPEG/1.JPG?type=w1200"));
        items.add(new SingleItem("포포", "2살", "https://blog.kakaocdn.net/dn/ej7HHN/btqEpJAha97/cSWVSFX8PrV03o15PZ8Bd1/img.jpg"));
        items.add(new SingleItem("멍멍", "3살", "https://image-notepet.akamaized.net/resize/620x-/seimage/20191114%2F6a4c967c5b14197dd5d2c47424ae8e82.jpg"));

        customListView = (ListView) rootView.findViewById(R.id.listView);
        customAdapter = new CustomAdapter(getContext(), items);
        customListView.setAdapter(customAdapter);
//        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String selectedItem = (String) view.findViewById(R.id.nameTextView).getTag().toString();
//                Toast.makeText(getContext(), "Clicked: " + position +" " + selectedItem, Toast.LENGTH_SHORT).show();
//            }
//        });

        return rootView;

    }
}

//data class
class SingleItem {
    String name;
    String age;
    String imageUrl;

    //생성
    public SingleItem(String name, String age, String imageUrl) {
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
