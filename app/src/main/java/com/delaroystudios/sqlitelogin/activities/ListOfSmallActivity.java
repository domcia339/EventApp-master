package com.delaroystudios.sqlitelogin.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.delaroystudios.sqlitelogin.R;

import java.util.ArrayList;

public class ListOfSmallActivity extends AppCompatActivity {

    ArrayList<String> selectedItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_small);

        ListView chl=(ListView) findViewById(R.id.chekable_list);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items= {"xxxxxxxx", "yyyyyyyyy", "ggggggggggggg"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.list_of_activity_layout,
                R.id.txt_lan, items);
        chl.setAdapter(adapter);

        chl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String selectedItem= ((TextView) view).getText().toString();
                if(selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);  //uncheck item
                }else{
                    selectedItems.add(selectedItem);
                }
            }
        });

    }

    public void showSelectedItems(View view){
        String items="";
        for(String item:selectedItems){
            items+="-"+item+"\n";
        }
        Toast.makeText(this,"You have selected \n"+items, Toast.LENGTH_SHORT).show();
    }
}
