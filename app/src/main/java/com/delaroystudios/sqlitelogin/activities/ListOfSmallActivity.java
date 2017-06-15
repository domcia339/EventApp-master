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
import java.util.Date;

import static java.lang.Integer.parseInt;

public class ListOfSmallActivity extends AppCompatActivity {

    ArrayList<String> selectedItems=new ArrayList<>();
    public Tables  tables= new Tables();

    public  Tab3 tab3= new Tab3();
    public static int alarm_id;


   // AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
    Calendar calendar = Calendar.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_small);

        ListView chl=(ListView) findViewById(R.id.chekable_list);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

       // String[] item= {tables.timehour[0]+ ":" + tables.timemin1[0]+ tables.timemin2[0]+ "   " + tables.items[0] , tables.timehour[1]+ ":" + tables.timemin1[1]+ tables.timemin2[1]+ " " + tables.items[1], tables.timehour[2]+ ":" + tables.timemin1[2]+ tables.timemin2[2]+ " " + tables.items[2]    };

        final String[] tab={tables.mainTab[tables.postab3][0][0] + ":" + tables.mainTab[tables.postab3][0][1] + "   " + tables.mainTab[tables.postab3][0][2], tables.mainTab[tables.postab3][1][0] + ":" + tables.mainTab[tables.postab3][1][1] + "   " + tables.mainTab[tables.postab3][1][2], tables.mainTab[tables.postab3][2][0] + ":" + tables.mainTab[tables.postab3][2][1] + "   " + tables.mainTab[tables.postab3][2][2] };

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,  R.layout.list_of_activity_layout, R.id.txt_lan, tab );

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

                    alarm_id=position;
                  //  Intent intent0 = new Intent(ListOfSmallActivity.this, AlarmNotificationReceiver.class);
                   // PendingIntent pendingIntent0 = PendingIntent.getBroadcast(ListOfSmallActivity.this, position , intent0, PendingIntent.FLAG_UPDATE_CURRENT);;
                   // startAlarm(tables.timehour[0], tables.timemin1[0], tables.timemin2[0]);
                    tables.posList=position;

                    int a= Integer.parseInt(tables.mainTab[tables.postab3][tables.posList][0]);
                    int b=Integer.parseInt(tables.mainTab[tables.postab3][tables.posList][1]);
                   // tables.myEvent=  new String[]{a+":"+b+"  "+tables.mainTab[tables.postab3][tables.posList][2]};
                    tables.vector.add(a+":"+b+"  "+tables.mainTab[tables.postab3][tables.posList][2]);


                    startAlarm( a , b, tables.postab3, tables.posList, alarm_id);

                }
                if(position==1){

                    tables.posList=position;
                    alarm_id=position;
                    //Intent intent1 = new Intent(ListOfSmallActivity.this, AlarmNotificationReceiver.class);
                    //PendingIntent pendingIntent1 = PendingIntent.getBroadcast(ListOfSmallActivity.this, position , intent1, PendingIntent.FLAG_UPDATE_CURRENT);;

                    int a= Integer.parseInt(tables.mainTab[tables.postab3][tables.posList][0]);
                    int b=Integer.parseInt(tables.mainTab[tables.postab3][tables.posList][1]);
                   // tables.myEvent= new String[]{a+":"+b+"  "+tables.mainTab[tables.postab3][tables.posList][2]};
                    tables.vector.add(a+":"+b+"  "+tables.mainTab[tables.postab3][tables.posList][2]);

                    // startAlarm( a , b, tables.postab3, tables.posList, intent0);

                    startAlarm( a , b, tables.postab3, tables.posList,alarm_id);
                }
                if(position==2){
                    tables.posList=position;
                    alarm_id=position;
                    int a= Integer.parseInt(tables.mainTab[tables.postab3][tables.posList][0]);
                    int b=Integer.parseInt(tables.mainTab[tables.postab3][tables.posList][1]);
                   //tables.myEvent= new String[]{a+":"+b+"  "+tables.mainTab[tables.postab3][tables.posList][2]};
                    tables.vector.add(a+":"+b+"  "+tables.mainTab[tables.postab3][tables.posList][2]);
                    startAlarm( a , b, tables.postab3, tables.posList,alarm_id);
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




        public void startAlarm(int hour, int min, int postab3, int posList, int alarm_id) {

            AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);


            tables.postab3 = postab3;
            tables.posList = posList;

            Calendar calendar = Calendar.getInstance();

            //było set!!!!
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, min);
            // calendar.set(Calendar.DAY_OF_MONTH, 30);

        Intent myIntent;
        PendingIntent pendingIntent;


        if (System.currentTimeMillis() < calendar.getTimeInMillis()) {
            myIntent = new Intent(ListOfSmallActivity.this, AlarmNotificationReceiver.class);
          //  pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0);

            int  Unique_Integer_Number=(int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
            //myIntent.putExtra(AlarmNotificationReceiver.NOTIFICATION_ID, Unique_Integer_Number);
            myIntent.putExtra(AlarmNotificationReceiver.NOTIFICATION1, postab3);
            myIntent.putExtra(AlarmNotificationReceiver.NOTIFICATION2, posList);
            myIntent.putExtra(AlarmNotificationReceiver.NOTIFICATION_ID, alarm_id);



           pendingIntent = PendingIntent.getBroadcast(this, alarm_id , myIntent, PendingIntent.FLAG_UPDATE_CURRENT); //PendingIntent.FLAG_UPDATE_CURRENT  );//0);

            //bylo samo set
            manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

            //manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        }

        }

}
