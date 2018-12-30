package com.ulan.timetable.Utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import com.ulan.timetable.Activities.WeekActivity;
import com.ulan.timetable.R;

public class NotificationHelper extends BroadcastReceiver {

    private final static String NOTIFICATION_CHANNEL_ID ="androidnotificationchannel.1";
    private static final String CHANNEL_NAME = "AnhHuy Channel";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        //Get id & massage from intent.
        int notificationId = intent.getIntExtra("notificationId", 0);
        String message = intent.getStringExtra("todo");

        //When notification is tapped, call WeekActivity
        Intent mainIntent = new Intent(context, WeekActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, mainIntent, 0);

        NotificationManager myNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Prepare notification.

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);
        builder.setSmallIcon(android.R.drawable.ic_popup_reminder)
                .setContentTitle("This week schedule")
                .setContentText(context.getString(R.string.Content_text))
                .setAutoCancel(true)
                .setContentIntent(contentIntent)
                .setContentTitle(message)
                .setTicker(message)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis());

        // Kiểm tra phiên bản SDK nếu 26+ thì chạy
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel HuyChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            HuyChannel.enableLights(true);
            HuyChannel.enableVibration(true);
            HuyChannel.setLightColor(Color.GREEN);
            HuyChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            assert myNotificationManager != null;
            builder.setChannelId(NOTIFICATION_CHANNEL_ID);
            myNotificationManager.createNotificationChannel(HuyChannel);
        }
        //Notify
        assert myNotificationManager != null;
        myNotificationManager.notify(notificationId, builder.build());

    }
}

