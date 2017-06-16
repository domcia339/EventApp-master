package com.delaroystudios.sqlitelogin.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.delaroystudios.sqlitelogin.R;

/**
 * Created by Domi on 13.05.2017.
 */

public class Tab2 extends Fragment {

    public Tab2() {

    }

    public Tables tables = new Tables();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.mainMenu); //mainMenu in xml

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                tables.vector
        );


        listView.setAdapter(listViewAdapter);

        return rootView;
    }


}
