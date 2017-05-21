package com.delaroystudios.sqlitelogin.activities;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.delaroystudios.sqlitelogin.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ListOfSmallActivity extends AppCompatActivity {

    ArrayList<String> selectedItems=new ArrayList<>();
    public String eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_small);

        ListView chl=(ListView) findViewById(R.id.chekable_list);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        final int[] timehour= {16, 12, 13};
        final int[] timemin1= {3,0,0};
        final int[] timemin2= {1,0,0};
        final String[] items= {"Podnosimy szaliki!", "Fala!", "Klaszczemy!"};

        String[] item= {timehour[0]+ ":" + timemin1[0]+ timemin2[0]+ "   " + items[0] , timehour[1]+ ":" + timemin1[1]+ timemin2[1]+ " " + items[1], timehour[2]+ ":" + timemin1[2]+ timemin2[2]+ " " + items[2]    };

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

                if(position==0){
                    startAlarm(timehour[0], timemin1[0], timemin2[0], items[0]);
                }
                if(position==1){
                    showSelectedItems(view);
                }
                if(position==2){

                }
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

    public void startAlarm(int hour, int min1, int min2, String eventname){
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //eventName=eventname;
        setEventName(eventname);
        getEventName();

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min1*10+min2);

        Intent myIntent;
        PendingIntent pendingIntent;

        if (System.currentTimeMillis() < calendar.getTimeInMillis()) {
            myIntent = new Intent(ListOfSmallActivity.this, AlarmNotificationReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0);
            manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);


        }

        }

        public String getEventName(){
            return eventName;
        }

        public void setEventName(String eventName){
            this.eventName=eventName;
        }

}
