package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.widget.ThemedSpinnerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    MediaPlayer player;
    Timer timer = new Timer();
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
   /*  player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();*/
       final long sistem=System.currentTimeMillis();

        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int count = 0;
                System.out.println(">TIMING"+ ++count);
               // timer.scheduleAtFixedRate(task,1000,1000);
            }
        };
        timer.schedule(task, 1000, 500);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       timer.cancel();
    }
}
