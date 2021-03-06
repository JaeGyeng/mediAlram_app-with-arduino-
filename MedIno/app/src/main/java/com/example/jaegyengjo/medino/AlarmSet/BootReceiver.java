package com.example.jaegyengjo.medino.AlarmSet;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

        Intent myIntent = new Intent(context, BroadcastD.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, myIntent, 0);

        long period = 1000 * 5;
        long t = SystemClock.elapsedRealtime();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, t, period, pendingIntent);
    }
}