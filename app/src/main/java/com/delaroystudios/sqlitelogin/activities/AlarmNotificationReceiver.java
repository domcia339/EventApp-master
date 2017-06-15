package com.delaroystudios.sqlitelogin.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.delaroystudios.sqlitelogin.R;

import java.util.Date;

/**
 * Created by Domi on 20.05.2017.
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {

    String en;

    public Tables tables = new Tables();

    ListOfSmallActivity lo= new ListOfSmallActivity();

    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION1 = "notification1";
    public static String NOTIFICATION2 = "notification2";
    //public static int NOTIFICATION1;


    @Override
    public void onReceive(Context context, Intent intent) {
       NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alarm actived!")
                .setContentText(tables.mainTab[intent.getIntExtra(NOTIFICATION1,0)][intent.getIntExtra(NOTIFICATION2,0)][2] )
                //.setContentText(tables.mainTab[intent.getIntExtra(NOTIFICATION1,0)][tables.posList][2] )//tables.items[lo.pos])
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setContentInfo("Info");


        int Unique_Integer_Number=(int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

          NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        //  Notification notification = intent.getParcelableExtra(NOTIFICATION1);
          // int id = intent.getIntExtra(NOTIFICATION_ID,Unique_Integer_Number);


            notificationManager.notify(intent.getIntExtra(NOTIFICATION_ID,0), builder.build());

        // int Unique_Integer_Number=(int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

//        notificationManager.notify(Unique_Integer_Number ,builder.build());



    }
}
