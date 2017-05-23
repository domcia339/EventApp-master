package com.delaroystudios.sqlitelogin.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.delaroystudios.sqlitelogin.R;

/**
 * Created by Domi on 20.05.2017.
 */

public class AlarmNotificationReceiver extends BroadcastReceiver {

    String en;

    public Tables tables = new Tables();

    ListOfSmallActivity lo= new ListOfSmallActivity();


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Alarm actived!")
                .setContentText(tables.mainTab[tables.postab3][tables.posList][2] )//tables.items[lo.pos])
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .setContentInfo("Info");


        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }
}
