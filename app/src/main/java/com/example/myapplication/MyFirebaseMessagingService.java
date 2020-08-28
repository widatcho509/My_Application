package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        if (null != remoteMessage.getNotification().getClickAction()) {
            startActivity(new Intent(this, Welcome.class));

        }
        showNotification(remoteMessage);

        //super.onMessageReceived(remoteMessage);
        Log.e("REMOTE",remoteMessage.getNotification().getBody());
       /* if (remoteMessage.getData().isEmpty()){

        }else{
            Log.d("Remote Message", "RemoteMessage: " + remoteMessage.getData());

        }*/

      //
    }

    private void showNotification(RemoteMessage message) {
        Intent intent = new Intent(this, Welcome.class);
        String myNot=message.getNotification().getBody();
        intent.putExtra("Noti",myNot);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK );
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent, PendingIntent.FLAG_ONE_SHOT);



        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String notificationChanel=" com.example.myapplication";
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel(notificationChanel,"notification",NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("My code");
            channel.enableLights(true);
            channel.setLightColor(Color.BLUE);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,notificationChanel);
        builder.setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(message.getNotification().getTitle())
                .setContentText(message.getNotification().getBody())
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSmallIcon(R.drawable.cart);

        notificationManager.notify(new Random().nextInt(), builder.build());
    }




    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }
}
