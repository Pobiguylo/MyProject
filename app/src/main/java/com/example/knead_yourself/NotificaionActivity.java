package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class NotificaionActivity extends AppCompatActivity {
    Switch aSwitch;
    EditText time;
    private static final int NOTIFY_ID = 1;
    private static String CHANNEL_ID = "Cat channel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaion);
        this.aSwitch = findViewById(R.id.switch1);
        this.time = findViewById(R.id.time);
        Intent notificationIntent = new Intent(NotificaionActivity.this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(NotificaionActivity.this,
                0, notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(NotificaionActivity.this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.sym_def_app_icon)
                        .setContentTitle("Пора работать")
                        .setContentText("Пора покормить кота")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(contentIntent);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(NotificaionActivity.this);
        notificationManager.notify(NOTIFY_ID, builder.build());
        if (aSwitch != null) {
            aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                }
            });
        }
    }
    }
