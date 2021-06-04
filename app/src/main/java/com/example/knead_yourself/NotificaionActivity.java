package com.example.knead_yourself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NotificaionActivity extends AppCompatActivity {
    TextView textView;
    Switch aSwitch;
    TimePicker pickerTime;
    private static String CHANNEL_ID = "Cat channel";

    private Notification getNotification() {
        Intent notificationIntent = new Intent(NotificaionActivity.this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(NotificaionActivity.this,
               0, notificationIntent,
               PendingIntent.FLAG_CANCEL_CURRENT);
        String[] randomWords = new String[]{"«Делай сегодня то, что другие не хотят, завтра будешь жить так, как другие не могут». Джаред Лето (Jared Joseph Leto)",
                "«Лучший способ взяться за что-то — перестать говорить и начать делать». Уолт Дисней (Walter Elias Disney)",
                "«Бездействие порождает беспокойство и страх. Действие — уверенность и смелость. Если ты хочешь победить страх, не сиди дома и не думай об этом. Встань и действуй». Мэг Джей (Meg Jay)",
                "«Многое кажется невозможным, пока ты этого не сделаешь». Нельсон Мандела (Nelson Rolihlahla Mandela)",
                "«Всегда помните о том, что ваша решимость преуспеть важнее всего остального». Авраам Линкольн (Abraham Lincoln)",
                "«Великие дела нужно совершать, а не обдумывать их бесконечно». Юлий Цезарь (Gaius Iulius Caesar)",
                "«Не бойтесь пожертвовать хорошим ради еще лучшего». Джон Рокфеллер (John D. Rockfeller)"};
        int n = (int)Math.floor(Math.random() * randomWords.length);
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(NotificaionActivity.this, CHANNEL_ID)
                        .setAutoCancel(true)
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.time)
                        .setContentTitle("Пора работать")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(randomWords[n]))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(contentIntent);

        return builder.build();
    }

    private void scheduleNotification(Notification notification, Calendar targetCal){

        Intent notificationIntent = new Intent(getBaseContext(), NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), 0, notificationIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= 19)
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
        else
            alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaion);
        this.aSwitch = findViewById(R.id.switch1);
        this.pickerTime = findViewById(R.id.timePicker);
        this.textView = findViewById(R.id.textVie);
        Calendar now = Calendar.getInstance();

        aSwitch.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/simpletext.ttf"));
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/simpletext.ttf"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            pickerTime.setHour(now.get(Calendar.HOUR_OF_DAY));
            pickerTime.setMinute(now.get(Calendar.MINUTE));
        } else {
            pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
            pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));
        }

        if (aSwitch != null) {
            aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(aSwitch.isChecked()){
                        Calendar current = Calendar.getInstance();
                        Calendar cal = Calendar.getInstance();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) cal.set( cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),pickerTime.getHour(), pickerTime.getMinute(), 0);
                        else cal.set( cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),pickerTime.getCurrentHour(), pickerTime.getCurrentMinute(), 0);
                        Context context = getApplicationContext();
                        if(cal.compareTo(current) <= 0) Toast.makeText(getApplicationContext(), "Что-то не так со временем", Toast.LENGTH_LONG).show();
                        else {
                            scheduleNotification(getNotification(), cal);
                            Toast.makeText(context, "Уведомление придёт", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }
    }
