package com.delaroystudios.sqlitelogin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.delaroystudios.sqlitelogin.R;

/**
 * Created by Domi on 13.05.2017.
 */

public class Tab3 extends Fragment {

    public Tab3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);

        String[] menuItems= {"Mecz 1", "Mecz 2", "Mecz 3"};

        ListView listView = (ListView) rootView.findViewById(R.id.mainMenu); //mainMenu in xml

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id){

                if(position==0){
                    Toast.makeText(getActivity(), "First Item", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getActivity(), ListOfSmallActivity.class);
                    startActivity(intent);

                }else if (position==1){
                    Toast.makeText(getActivity(), "Second Item", Toast.LENGTH_SHORT).show();
                }else if (position==2){
                    Toast.makeText(getActivity(), "Third Item", Toast.LENGTH_SHORT).show();
                }
            }

        });
        return rootView;
    }
}
