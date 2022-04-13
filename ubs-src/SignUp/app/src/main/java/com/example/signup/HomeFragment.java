package com.example.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView mRecyclerView = rootView.findViewById(R.id.recyclerView);
        //setting the layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        //setting the data
//        Homepage.BazaarList.add(new BazaarItem("Pizza", "Hey everyone, theres going to be pizza at the MAC lobby tonight at 7pm courtesy of the Civil Engineers Club! See you there.", "Event"));
//        Homepage.BazaarList.add(new BazaarItem("Roommates", "Looking for a roommate at Arbor Oaks, message me for details!","Event"));
//        Homepage.BazaarList.add(new BazaarItem("New CSE3318 Sections", "Due to great demand, we have opened two new sections of CSE3318. Computer science students register now, before spots are taken up!","Event"));
//        Homepage.BazaarList.add(new BazaarItem("Ping Pong Club", "Fall tournament is scheduled for September 14, please pay your dues before then!","Event"));
//        Homepage.BazaarList.add(new BazaarItem("Roommates", "Looking for a roommate at Mavs EDGE, message me for details! Internet and cable included....","Event"));

        RecyclerView.Adapter mAdapter = new BazaarAdapter(Homepage.BazaarList);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.top_nav, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.searchButton);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }
}
