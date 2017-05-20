package com.delaroystudios.sqlitelogin.activities;

import android.content.Intent;
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
        int[] timehour= {11, 12, 13};
        int[] timemin1= {0,0,0};
        int[] timemin2= {0,0,0};
        String[] items= {"Podnosimy szaliki!", "Fala!", "Klaszczemy!"};

        String[] item= {timehour[0]+ ":" + timemin1[0]+ timemin2[0]+ " " + items[0] , timehour[1]+ ":" + timemin1[1]+ timemin2[1]+ " " + items[1], timehour[2]+ ":" + timemin1[2]+ timemin2[2]+ " " + items[2]    };

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,  R.layout.list_of_activity_layout, R.id.txt_lan, item );

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
                showSelectedItems(view);
            }
        });

    }

    public void showSelectedItems(View view){
        String items="";
        int nr=0;

        for(String item:selectedItems){
            //items+="-"+items+"\n";
            nr+=1;
        }
        Toast.makeText(this,"You have selected \n"+nr, Toast.LENGTH_SHORT).show();
    }
}
